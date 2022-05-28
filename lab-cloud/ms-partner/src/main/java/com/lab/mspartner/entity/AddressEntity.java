package com.lab.mspartner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @NotBlank(message = "Street no blank")
    private String street;

    @NotBlank(message = "Number not null")
    private String number;

    private String complement;

    @NotNull(message = "Postal code not null")
    private Integer postalCode;

    @NotBlank(message = "Country not null")
    private String country;
}
