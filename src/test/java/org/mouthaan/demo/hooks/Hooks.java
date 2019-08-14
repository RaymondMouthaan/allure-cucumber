package org.mouthaan.demo.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;

public class Hooks {

    @Before
    public void setup() {
        Configuration.reportsFolder = "target/results/selenide-screenshots";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
