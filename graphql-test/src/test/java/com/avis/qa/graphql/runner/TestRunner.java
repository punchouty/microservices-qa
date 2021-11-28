package com.avis.qa.graphql.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.avis.qa.graphql.test",
        stepNotifications = true
)
public class TestRunner {
}
