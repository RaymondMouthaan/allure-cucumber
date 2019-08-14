package org.mouthaan.demo;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void sum() {
        // Given
        int a = 10;
        int b = 20;
        int expected = 30;
        Calculator calculator = new Calculator();

        // When
        int result = calculator.sum(a, b);

        // Then
        Assert.assertEquals(expected, result);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void multiply() {
        // Given
        int a = 10;
        int b = 20;
        int expected = 200;
        Calculator calculator = new Calculator();

        // When
        int result = calculator.multiply(a, b);

        // Then
        Assert.assertEquals(expected, result);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void subtract() {
        // Given
        int a = 10;
        int b = 20;
        int expected = -10;
        Calculator calculator = new Calculator();

        // When
        int result = calculator.subtract(a, b);

        // Then
        Assert.assertEquals(expected, result);
    }
}
