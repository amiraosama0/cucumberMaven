package org.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = "src/main/resources/features",
                glue = "org.example.stepDefs",
                tags = "@g15"
        )
public class TestRanner extends AbstractTestNGCucumberTests {
}
