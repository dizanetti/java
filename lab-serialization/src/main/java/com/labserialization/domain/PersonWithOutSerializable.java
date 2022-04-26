package com.labserialization.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonWithOutSerializable {

    private String name;

    private int age;

    private BigDecimal salary;
}
