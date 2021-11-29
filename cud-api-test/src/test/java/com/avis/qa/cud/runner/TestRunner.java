package com.avis.qa.cud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.avis.qa.cud.steps",
        stepNotifications = true
)
public class TestRunner {

    private static final DockerComposeContainer<?> composeContainer =
            new DockerComposeContainer(
                    new File("src/test/resources/docker-compose.yaml"))
                    .withExposedService("cud-api_1", 9100);

    @BeforeClass
    public static void setup() {
        composeContainer.start();
    }

    @AfterClass
    public static void teardown() {
        composeContainer.stop();
    }
}
