package com.demo.temporal.io.temporal.usecases;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface Format {

    @ActivityMethod
    String composeGreeting(String name);    
}
