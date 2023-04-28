package com.lab.workflow.camunda.gateway.collaborator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "${portal.collaborator.name}", url = "${portal.collaborator.url}")
public interface UpdateCollaboratorGateway {

    @PostMapping(value = "/update/collaborator/{id}", produces = "application/json")
    void update(@PathVariable("id") Long id, Object body);
}
