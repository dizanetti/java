package com.lab.workflow.camunda.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "updateCollaborator", url = "${portal.url-collaborator}")
public interface UpdateCollaboratorInformation {

    @PostMapping(value = "/update/collaborator/{id}", produces = "application/json")
    void update(@PathVariable("id") Long id, Object body);
}
