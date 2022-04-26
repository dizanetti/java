package com.labsolid.pattern.o.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public abstract class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private List<Account> accounts;

    public void welcomeMessage() {
        log.info("Hello " + this.firstName);
    }
}
