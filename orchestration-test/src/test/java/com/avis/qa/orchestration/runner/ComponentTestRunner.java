package com.avis.qa.orchestration.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.avis.qa.orchestration.steps",
        stepNotifications = true
)
public class ComponentTestRunner {

    private static final DockerComposeContainer<?> composeContainer =
            new DockerComposeContainer(
                    new File("src/test/resources/docker-compose-mock.yml"))
                    .withExposedService("orchestration-api_1", 9300);

    @BeforeClass
    public static void setup() {
        composeContainer.start();
    }

    @AfterClass
    public static void teardown() {
        composeContainer.stop();
    }
}
