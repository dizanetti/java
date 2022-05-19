package com.lab.mspartner.usecase;

import com.lab.mspartner.entity.PartnerEntity;
import com.lab.mspartner.gateways.PartnerGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PartnerService {

    @Autowired
    private PartnerGateway partnerGateway;

    public List<PartnerEntity> getAllPartners() {
        log.info("Find all partners");

        return partnerGateway.findAll();
    }
}
