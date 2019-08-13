package org.mouthaan.demo.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.mouthaan.demo.pages.GoogleSearchPage;

public class GoogleSearchSteps {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("the Google search page")
    public void theGoogleSearchPage() {
        googleSearchPage.openUrl("https://google.com");
    }

    @When("we search for {string}")
    public void weForSearch(String arg0) {
        googleSearchPage.googleSearchFor(arg0);
    }

}
