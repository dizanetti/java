package com.labsolid.pattern.o.model;

import lombok.Data;

@Data
public class Account {

    private Long id;

    private String accountNumber;

    private String accountName;

    private String status;

    private String type;
}
