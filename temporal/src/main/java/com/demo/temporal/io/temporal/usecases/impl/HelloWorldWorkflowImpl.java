package com.demo.temporal.io.temporal.usecases.impl;

import java.time.Duration;

import com.demo.temporal.io.temporal.usecases.Format;
import com.demo.temporal.io.temporal.usecases.HelloworldWorkflow;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class HelloWorldWorkflowImpl implements HelloworldWorkflow {

    ActivityOptions options = ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofSeconds(2))
            .build();

    private final Format format = Workflow.newActivityStub(Format.class, options);

    @Override
    public String getGreeting(String name) {
        return format.composeGreeting(name);
    }
}
