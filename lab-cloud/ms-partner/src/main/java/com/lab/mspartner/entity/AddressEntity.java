package com.lab.mspartner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    private String street;
    private String number;
    private String complement;
    private Integer postalCode;
    private String country;
}
