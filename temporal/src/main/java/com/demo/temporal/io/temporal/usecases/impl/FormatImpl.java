package com.demo.temporal.io.temporal.usecases.impl;

import com.demo.temporal.io.temporal.usecases.Format;

public class FormatImpl implements Format {

    @Override
    public String composeGreeting(String name) {
        return "Hello " + name + "!";
    }
}
