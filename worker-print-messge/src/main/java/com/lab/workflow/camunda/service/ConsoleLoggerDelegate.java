package com.lab.workflow.camunda.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("consoleLoggerDelegate")
public class ConsoleLoggerDelegate implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(ConsoleLoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Message inbox to: {}", delegateExecution.getVariable("userName"));
    }
}
