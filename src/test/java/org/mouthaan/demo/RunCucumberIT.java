package org.mouthaan.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

        @AfterClass
        public static void generateEnvironmentProperties() throws IOException {
                FileOutputStream fos = new FileOutputStream("target/results/allure-results/environment.properties");
                Properties properties = new Properties();
                properties.put("Browser", "Safari");
                properties.put("Browser.version", "12");
                properties.put("Stand", "Test");
                properties.store(fos, "Allure Environment Properties");
                fos.flush();
                fos.close();
        }
}
