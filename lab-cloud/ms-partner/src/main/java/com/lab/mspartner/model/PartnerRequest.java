package com.lab.mspartner.model;

import com.lab.mspartner.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerRequest {

    @NotBlank(message = "Name is blank")
    private String name;

    @Valid
    private AddressEntity address;

    @NotNull(message = "Cnpj/CPF not null")
    private Long cnpjCpf;
    private String phone;
}
