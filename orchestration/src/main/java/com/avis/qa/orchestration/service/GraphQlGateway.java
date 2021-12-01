package com.avis.qa.orchestration.service;

import com.avis.qa.orchestration.dto.GraphQlDataDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class GraphQlGateway {

    @Value("${graph-api.base-url}")
    private String graphApiUrl;

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final RestTemplate restTemplate;

    public GraphQlGateway(ResourceLoader resourceLoader, RestTemplate restTemplate) {
        this.resourceLoader = resourceLoader;
        this.restTemplate = restTemplate;
    }

    public GraphQlDataDto get() throws IOException {
        String graphql = load("request.graphql");
        String payload = createJsonQuery(graphql, null);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(payload, headers);
//        ResponseEntity<String> response = restTemplate.exchange(graphApiUrl + "/graphql", HttpMethod.POST, httpEntity, String.class);
//        System.out.println(response.getBody());
        ResponseEntity<GraphQlDataDto> graphQlDataDtoResponseEntity = restTemplate.exchange(graphApiUrl + "/graphql", HttpMethod.POST, httpEntity, GraphQlDataDto.class);
        //ResponseEntity<GraphQlDataDto> graphQlDataDtoResponseEntity = restTemplate.postForEntity(graphApiUrl + "/graphql", new HttpEntity<>(payload, headers), GraphQlDataDto.class);
        return graphQlDataDtoResponseEntity.getBody();
    }

    private String createJsonQuery(String graphql, String operationName) throws JsonProcessingException {
        ObjectNode wrapper = objectMapper.createObjectNode();
        wrapper.put("query", graphql);
        wrapper.put("operationName", operationName);
        return objectMapper.writeValueAsString(wrapper);
    }

    HttpEntity<Object> forJson(String json, HttpHeaders headers) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(json, headers);
    }
    private String load(String location) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:graphql/" + location);
        return loadResource(resource);
    }

    private String loadResource(Resource resource) throws IOException {
        try (InputStream inputStream = resource.getInputStream()) {
            return StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }
}
