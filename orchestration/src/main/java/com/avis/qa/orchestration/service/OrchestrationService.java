package com.avis.qa.orchestration.service;

import com.avis.qa.orchestration.domain.Employee;
import com.avis.qa.orchestration.dto.EmployeeInfo;
import com.avis.qa.orchestration.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class OrchestrationService {

    private final EmployeeRepository employeeRepository;
    private final WebClient webClientCud;
    private final WebClient webClientGraph;

    public OrchestrationService(EmployeeRepository employeeRepository, WebClient webClientCud, WebClient webClientGraph) {
        this.employeeRepository = employeeRepository;
        this.webClientCud = webClientCud;
        this.webClientGraph = webClientGraph;
    }

    public Mono<EmployeeInfo> getCeoCompanyAndLocation(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()) {
            Employee employee = optional.get();
            String employeeName = employee.getName();
            String companyCode = employee.getCompany();
            EmployeeInfo employeeInfo = EmployeeInfo.builder().companyCode(companyCode).employeeName(employeeName).build();
        }
        else throw new RuntimeException("Bad Data");
        return null;
    }
}
