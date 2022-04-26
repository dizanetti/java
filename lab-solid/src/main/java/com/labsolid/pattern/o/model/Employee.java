package com.labsolid.pattern.o.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Employee extends Person {

    @Override
    public void welcomeMessage() {
        log.info("Hello " + this.getFirstName() + " " + this.getLastName());
    }
}
