package com.graalvmdemo.lab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping
    public String demo() {
        log.info("Controller demo");

        return "Demo Native image";
    }
}
