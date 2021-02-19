package com.epam.task.fourth;

import com.epam.task.fourth.parser.validator.SaxValidator;
import org.junit.Assert;
import org.junit.Test;


public class ValidatorTest {

    @Test
    public void testIsValidShouldReturnTrueWhenInputFileValid() {
        SaxValidator validator = new SaxValidator("src/test/resources/tariffs.xsd");

        boolean isValid = validator.isValid("src/test/resources/tariffs.xml");

        Assert.assertTrue(isValid);
    }


    @Test
    public void testIsValidShouldReturnFalseWhenInputFileInvalid() {
        SaxValidator validator = new SaxValidator("src/test/resources/tariffs.xsd");

        boolean isValid = validator.isValid("src/test/resources/tariffs_invalid_data.xml");

        Assert.assertFalse(isValid);
    }
}