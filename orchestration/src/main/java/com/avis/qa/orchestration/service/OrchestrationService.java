package com.avis.qa.orchestration.service;

import com.avis.qa.orchestration.domain.Employee;
import com.avis.qa.orchestration.dto.*;
import com.avis.qa.orchestration.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrchestrationService {

    private final EmployeeRepository employeeRepository;
    private final CudGateway cudGateway;
    private final GraphQlGateway graphql;

    public OrchestrationService(EmployeeRepository employeeRepository, CudGateway cudGateway, GraphQlGateway graphql) {
        this.employeeRepository = employeeRepository;
        this.cudGateway = cudGateway;
        this.graphql = graphql;
    }

    public Flux<EmployeeInfo> getEmployeeCompanyAndLocation(Long id) throws IOException {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()) {
            Employee employee = optional.get();
            String employeeName = employee.getName();
            String companyCode = employee.getCompanyCode();
            BrandDto brand = getBrand(companyCode);
            String companyName = brand.getName();

            ArrayList<LocationDto> locations = getLocations(companyCode);
            ArrayList<EmployeeInfo> employeeInfoList = new ArrayList<>();
            for (LocationDto location : locations) {
                EmployeeInfo employeeInfo = EmployeeInfo.builder()
                        .companyCode(companyCode)
                        .company(companyName)
                        .employeeName(employeeName)
                        .location(location.getName())
                        .city(location.getCity())
                        .build();
                employeeInfoList.add(employeeInfo);
            }
            Flux<EmployeeInfo> fluxFromList = Flux.fromIterable(employeeInfoList);
            return fluxFromList;
        }
        else throw new RuntimeException("Bad Data");
    }

    private BrandDto getBrand(String companyCode) throws IOException {
        GraphQlDataDto graphQlDataDto = graphql.get();
        List<BrandDto> dtoList = graphQlDataDto.getData().getDtoList();
        for (BrandDto brandDto : dtoList) {
            if(brandDto.getCode().equals(companyCode)) {
                return brandDto;
            }
        }
        return null;
    }

    private ArrayList<LocationDto> getLocations(String companyCode) {
        CudLocationDto cudLocationDto = cudGateway.get();
        List<LocationDto> locations = cudLocationDto.getEmbedded().getDtoList();
        ArrayList<LocationDto> dtos = new ArrayList<>();
        for (LocationDto location : locations) {
            if(location.getCompanyCode().equals(companyCode)) {
                dtos.add(location);
            }
        }
        return dtos;
    }
}
