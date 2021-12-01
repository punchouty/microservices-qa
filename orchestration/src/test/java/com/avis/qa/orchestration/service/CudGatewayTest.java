package com.avis.qa.orchestration.service;

import com.avis.qa.orchestration.dto.CudLocationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CudGatewayTest {

    @Autowired
    private CudGateway cudGateway;

    @Test
    void get() {
        CudLocationDto cudLocationDto = cudGateway.get();
        System.out.println(cudLocationDto);
    }
}