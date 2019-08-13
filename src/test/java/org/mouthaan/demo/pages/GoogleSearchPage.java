package org.mouthaan.demo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.name;

public class GoogleSearchPage {

    SelenideElement searchField = $(name("q"));

    public void openUrl(String url) {
        open(url);
    }
    
    public void googleSearchFor(String searchString) {
        searchField.setValue(searchString).pressEnter();
    }
}
