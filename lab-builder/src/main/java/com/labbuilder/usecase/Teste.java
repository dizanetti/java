package com.labbuilder.usecase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teste {

    private Long priority;

    private BigDecimal fee;

    private String name;
}
