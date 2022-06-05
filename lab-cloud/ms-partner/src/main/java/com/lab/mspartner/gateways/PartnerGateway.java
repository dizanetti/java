package com.lab.mspartner.gateways;

import com.lab.mspartner.entity.PartnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerGateway extends MongoRepository<PartnerEntity, String> {

    PartnerEntity findByCnpjCpf(Long cnpjCpf);

    void deleteByCnpjCpf(Long cnpjCpf);
}
