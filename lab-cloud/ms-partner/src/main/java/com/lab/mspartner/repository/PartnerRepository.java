package com.lab.mspartner.repository;

import com.lab.mspartner.model.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends MongoRepository<Partner, String> {
}
