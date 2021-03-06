package com.avis.qa.orchestration.controller;

import com.avis.qa.orchestration.dto.EmployeeInfo;
import com.avis.qa.orchestration.service.OrchestrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/orchestration")
public class OrchestrationController {

    private final OrchestrationService orchestrationService;

    public OrchestrationController(OrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    @GetMapping("/{idString}")
    private Flux<EmployeeInfo> getCeoCompanyAndLocation(@PathVariable String idString) throws IOException {
        Long id = Long.valueOf(idString);
        return orchestrationService.getEmployeeCompanyAndLocation(id);
    }
}
