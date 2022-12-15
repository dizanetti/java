package com.demo.temporal.io.temporal.usecases;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface HelloworldWorkflow {

    @WorkflowMethod
    String getGreeting(String name);
    
}
