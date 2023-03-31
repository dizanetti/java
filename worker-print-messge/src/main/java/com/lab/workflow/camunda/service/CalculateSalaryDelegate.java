package com.lab.workflow.camunda.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("calculateSalaryDelegate")
public class CalculateSalaryDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(CalculateSalaryDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Old salary: {} and new bonus: {}", delegateExecution.getVariable("salary"), delegateExecution.getVariable("bonus"));

        Integer newSalary = Integer.parseInt(delegateExecution.getVariable("salary").toString());
        newSalary += Integer.parseInt(delegateExecution.getVariable("bonus").toString());

        LOGGER.info("New salary: {}", newSalary);
    }
}
