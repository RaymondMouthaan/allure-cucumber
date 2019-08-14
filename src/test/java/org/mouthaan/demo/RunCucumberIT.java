package org.mouthaan.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/results/cucumber-reports/html-report",
                "json:target/results//cucumber-reports/cucumber.json",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
        },
        features = "src/test/resources/features",
        glue = {"org.mouthaan.demo.steps", "org.mouthaan.demo.hooks"}
)
public class RunCucumberIT {

}
