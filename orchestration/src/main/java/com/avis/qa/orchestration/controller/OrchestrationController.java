package com.avis.qa.orchestration.controller;

import com.avis.qa.orchestration.dto.Info;
import com.avis.qa.orchestration.service.OrchestrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/orchestration")
public class OrchestrationController {

    private final OrchestrationService orchestrationService;

    public OrchestrationController(OrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    @GetMapping("/{id}")
    private Flux<Info> getCeoCompanyAndLocation(@PathVariable String id) {
        return orchestrationService.getCeoCompanyAndLocation(id);
    }
}
