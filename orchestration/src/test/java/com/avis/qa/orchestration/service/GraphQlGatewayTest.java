package com.avis.qa.orchestration.service;

import com.avis.qa.orchestration.dto.GraphQlDataDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GraphQlGatewayTest {

    @Autowired
    private GraphQlGateway graphQlGateway;

    @Test
    void get() throws IOException {
        GraphQlDataDto graphQlDataDto = graphQlGateway.get();
        System.out.println(graphQlDataDto);
    }
}