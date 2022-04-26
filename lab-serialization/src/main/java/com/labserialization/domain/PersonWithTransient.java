package com.labserialization.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonWithTransient implements Serializable {

    private static final long serialVersionUID = -7831763830796089037L;

    private transient String name;

    private int age;

    private BigDecimal salary;
}
