package com.avis.qa.orchestration.repository;

import com.avis.qa.orchestration.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
