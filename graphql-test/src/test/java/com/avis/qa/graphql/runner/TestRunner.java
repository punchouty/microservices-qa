package com.avis.qa.graphql.runner;

import com.avis.qa.graphql.test.BrandStepDefinition;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.avis.qa.graphql.test",
        stepNotifications = true
)
public class TestRunner {

    private static final DockerComposeContainer<?> composeContainer =
            new DockerComposeContainer(
                    new File("src/test/resources/docker-compose.yaml"))
                    .withExposedService("graphql_1", 9200);

    @BeforeClass
    public static void setup() {
        composeContainer.start();
    }

    @AfterClass
    public static void teardown() {
        composeContainer.stop();
    }
}
