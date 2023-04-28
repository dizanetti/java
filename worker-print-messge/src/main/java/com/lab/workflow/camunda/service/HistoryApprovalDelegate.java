package com.lab.workflow.camunda.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lab.workflow.camunda.gateway.historyapproval.HistoryApprovalGateway;

@Component("historyApprovalDelegate")
public class HistoryApprovalDelegate implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(HistoryApprovalDelegate.class.getName());

    @Autowired
    private HistoryApprovalGateway historyApproval;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Save history approval for service {}", delegateExecution.getVariable("service"));

        historyApproval.save(delegateExecution.getVariables());                
    }
}
