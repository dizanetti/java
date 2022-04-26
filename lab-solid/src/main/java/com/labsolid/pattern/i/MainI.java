package com.labsolid.pattern.i;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MainI {

    /**
     * ISP = Interface Segregation Principle
     *
     * It is applicable to interfaces as single responsibility principle holds to classes. ISP says:
     *
     * “Clients should not be forced to implement unnecessary methods which they will not use”
     */
    public void start() {
        log.info("ISP");
    }
}
