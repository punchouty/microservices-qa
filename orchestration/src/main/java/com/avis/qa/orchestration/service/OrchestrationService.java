package com.avis.qa.orchestration.service;

import com.avis.qa.orchestration.dto.Info;
import com.avis.qa.orchestration.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OrchestrationService {

    private final EmployeeRepository employeeRepository;

    public OrchestrationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Flux<Info> getCeoCompanyAndLocation(String id) {
        return null;
    }
}
