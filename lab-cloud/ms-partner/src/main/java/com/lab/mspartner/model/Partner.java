package com.lab.mspartner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("partner")
public class Partner {

    @Id
    private String id;
    private String name;
    private Address address;
    private String phone;
}
