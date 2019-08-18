package org.mouthaan.demo.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.mouthaan.demo.restcall.restcallDemo;


public class RestCallSteps {

   restcallDemo restcallDemo = new restcallDemo();

    @Given("Ik succesvol een REST call verstuur met de methode GET")
    public void theFirstResultMustBe() throws Exception {
        restcallDemo.sendGet();
    }


    @Given("ik een typfout maak in de feature file verschijnt er een paarse balk")
    public void ikEenTypfoutMaakInDeFeatureFileVerschijntErEenPaarseBalk() throws Exception {
        restcallDemo.sendPost();
    }
}
