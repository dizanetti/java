package com.lab.workflow.camunda.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lab.workflow.camunda.gateway.collaborator.UpdateCollaboratorGateway;

@Component("updateCollaboratorDelegate")
public class UpdateCollaboratorDelegate implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(UpdateCollaboratorDelegate.class.getName());

    @Autowired
    private UpdateCollaboratorGateway updateCollaborator;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Update fields in Data Base to service {}", delegateExecution.getVariable("service"));

        updateCollaborator.update(
            Long.parseLong(delegateExecution.getVariable("collaboratorId").toString()), 
            delegateExecution.getVariables());
    }
}
