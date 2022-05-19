package com.lab.mspartner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("partner")
public class PartnerEntity {

    @Id
    private String id;
    private String name;
    private AddressEntity address;
    private String phone;
}
