package org.mouthaan.demo;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.isChrome;
import static com.codeborne.selenide.WebDriverRunner.isFirefox;

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

        Capabilities capabilities = getCapabilities();

        properties.put("Browser", capabilities.getBrowserName());
        properties.put("Browser.version", capabilities.getVersion());
        properties.put("Platform", capabilities.getPlatform().name());

        properties.put("Stand", "Test");
        properties.store(fos, "Allure Environment Properties");
        fos.flush();
        fos.close();
    }

    private static Capabilities getCapabilities() {
        if (isChrome()) {
            ChromeDriver chromeDriver = (ChromeDriver) WebDriverRunner.getWebDriver();
            return chromeDriver.getCapabilities();
        } else if (isFirefox()) {
            FirefoxDriver firefoxDriver = (FirefoxDriver) WebDriverRunner.getWebDriver();
            return firefoxDriver.getCapabilities();
        } else {
            SafariDriver safariDriver = (SafariDriver) WebDriverRunner.getWebDriver();
            return safariDriver.getCapabilities();
        }
    }

}
