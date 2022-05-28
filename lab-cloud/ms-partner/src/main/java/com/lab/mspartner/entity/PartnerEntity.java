package com.lab.mspartner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document("partner")
public class PartnerEntity {

    @Id
    private String id;
    private String name;
    private AddressEntity address;
    private Long cnpjCpf;
    private String phone;
}
