package com.lab.mspartner.usecase;

import com.lab.mspartner.entity.PartnerEntity;
import com.lab.mspartner.exception.PartnerException;
import com.lab.mspartner.exception.PartnerNotFoundException;
import com.lab.mspartner.gateways.PartnerGateway;
import com.lab.mspartner.model.PartnerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;

@Slf4j
@Service
public class PartnerService {

    @Autowired
    private PartnerGateway partnerGateway;

    @CacheEvict(cacheNames = "partner", allEntries = true)
    public PartnerEntity insert(PartnerRequest request) {
        log.info("Insert new Partner {}", request.getName());

        if (FALSE.equals(isPartnerExists(request.getCnpjCpf()))) {
            PartnerEntity partner = PartnerEntity
                    .builder()
                    .name(request.getName())
                    .cnpjCpf(request.getCnpjCpf())
                    .address(request.getAddress())
                    .phone(request.getPhone())
                    .build();

            log.debug(partner.toString());
            return partnerGateway.save(partner);
        }

        throw new PartnerException("Partner already exists " + request.getCnpjCpf());
    }

    @Cacheable(cacheNames = "partner", key="#root.method.name")
    public List<PartnerEntity> getAllPartners() {
        log.info("Find all partners");

        return partnerGateway.findAll();
    }

    @Cacheable(cacheNames = "partner", key="#cnpjCpf")
    public PartnerEntity getPartner(Long cnpjCpf) {
        log.info("Find a partner with {}", cnpjCpf);

        return Optional.ofNullable(partnerGateway.findByCnpjCpf(cnpjCpf))
                .orElseThrow(() -> new PartnerNotFoundException("Can not find partner by " + cnpjCpf));
    }

    private boolean isPartnerExists(Long cnpjCpf) {
        try {
            getPartner(cnpjCpf);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
