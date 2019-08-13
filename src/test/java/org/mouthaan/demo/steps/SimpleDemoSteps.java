package org.mouthaan.demo.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class SimpleDemoSteps {

    private int numberA;
    private int numberB;
    private int sum;

    @Given("number {int} and number {int}")
    public void numberAndNumber(int a, int b) {
        numberA = a;
        numberB = b;
    }

    @When("the numbers are added together")
    public void theNumbersAreAddedTogether() {
        sum = numberA + numberB;
    }

    @Then("the sum must be equal to {int}")
    public void theSumMustBeEqualTo(int sum) {
        assertEquals(sum, this.sum);
    }
}
