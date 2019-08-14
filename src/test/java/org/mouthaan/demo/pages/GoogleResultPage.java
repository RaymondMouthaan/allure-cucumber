package org.mouthaan.demo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultPage {
    private ElementsCollection results = $$("h3");

    public void bla(int i, String result) {
        results.get(i - 1).shouldHave(Condition.text(result));
    }


}
