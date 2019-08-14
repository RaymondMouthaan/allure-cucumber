package org.mouthaan.demo.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

public class Hooks {

    @Before
    public void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.reportsFolder = "target/results/selenide-screenshots";
    }
}
