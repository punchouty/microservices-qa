package com.avis.qa.orchestration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {

    private String employeeName;
    private String companyCode;
    private String company;
    private String location;
    private String city;
}
