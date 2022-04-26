package com.labsolid.pattern.l.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Engine {

    public void on() {
        log.info("Turn On the Engine!!!");
    }

    public void powerOn(int value) {
        log.info("Accelerate with " + value);
    }
}
