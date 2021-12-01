package com.avis.qa.orchestration.service;

import com.avis.qa.orchestration.dto.CudLocationDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CudGateway {

    @Value("${cud-api.base-url}")
    private String cudApiUrl;
    @Value("${graph-api.base-url}")
    private String graphApiUrl;

    private final RestTemplate restTemplate;

    public CudGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CudLocationDto get() {
        CudLocationDto dto = restTemplate.getForObject(cudApiUrl + "/locations", CudLocationDto.class);
        System.out.println(dto);
        return dto;
    }
}
