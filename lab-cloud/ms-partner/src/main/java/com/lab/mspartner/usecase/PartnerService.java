package com.lab.mspartner.usecase;

import com.lab.mspartner.entity.PartnerEntity;
import com.lab.mspartner.exception.PartnerException;
import com.lab.mspartner.exception.PartnerNotFoundException;
import com.lab.mspartner.gateways.PartnerGateway;
import com.lab.mspartner.model.PartnerRequest;
import com.mongodb.MongoTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PartnerService {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    private PartnerGateway partnerGateway;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @CacheEvict(cacheNames = "partner", allEntries = true)
    @Retryable(value = {MongoTimeoutException.class}, maxAttempts = 2, backoff = @Backoff(delay = 200), label = "Retry Insert Partner")
    public PartnerEntity insert(PartnerRequest request) {
        log.info("Insert new Partner {}", request.getName());

        PartnerEntity partner = partnerWrapper(request);
        log.debug(partner.toString());

        try {
            partner = partnerGateway.save(partner);
        } catch (Exception ex) {
            throw new PartnerException("Cannot insert partner", ex);
        }
        return partner;
    }

    @Cacheable(cacheNames = "partner", key = "#root.method.name")
    public List<PartnerEntity> getAllPartners() {
        log.info("Find all partners");

        return partnerGateway.findAll();
    }

    @Cacheable(cacheNames = "partner", key = "#cnpjCpf")
    public PartnerEntity getPartner(Long cnpjCpf) {
        log.info("Find a partner with {}", cnpjCpf);

        return Optional.ofNullable(partnerGateway.findByCnpjCpf(cnpjCpf))
                .orElseThrow(() -> new PartnerNotFoundException("Can not find partner by " + cnpjCpf));
    }

    public Long deletePartner(Long cnpjCpf) {
        log.info("delete partner {}", cnpjCpf);

        partnerGateway.deleteByCnpjCpf(cnpjCpf);

        return cnpjCpf;
    }

    @Recover
    public PartnerEntity recoverPartnerServiceFallback(PartnerException partnerException, PartnerRequest request) {
        log.info("Recover from a connection error. Put the partner on a queue to be process lately!");

        amqpTemplate.convertAndSend(exchange, routingkey, request);

        PartnerEntity partner = partnerWrapper(request);
        log.debug(partner.toString());

        return partner;
    }

    private PartnerEntity partnerWrapper(PartnerRequest request) {
        return PartnerEntity
                .builder()
                .name(request.getName())
                .cnpjCpf(request.getCnpjCpf())
                .address(request.getAddress())
                .phone(request.getPhone())
                .build();
    }
}
