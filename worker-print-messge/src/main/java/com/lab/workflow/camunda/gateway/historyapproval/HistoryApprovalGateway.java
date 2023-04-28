package com.lab.workflow.camunda.gateway.historyapproval;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "${portal.history-approval.name}", url = "${portal.history-approval.url}")
public interface HistoryApprovalGateway {

    @PostMapping(value = "/save/history", produces = "application/json")
    void save(Object body);
}
