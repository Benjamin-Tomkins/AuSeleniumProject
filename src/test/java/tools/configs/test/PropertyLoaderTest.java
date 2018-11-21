package tools.configs.test;

import net.serenitybdd.junit.runners.SerenityRunner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tools.configs.PropertyLoader;

/**
 * This file contains unit tests for the property loader class
 */
@RunWith(SerenityRunner.class)
public class PropertyLoaderTest {

    String expectedResult;
    String propertyKey = "BASE_URL_GOOGLE";
    String actualResult;

    @Before
    public void initialize() {

    }

    @Test
    public void getPropertyReturnsGoogleUrl() {
        expectedResult = "https://www.google.com/";
        actualResult = PropertyLoader.getProperty(propertyKey);
        assertEquals(expectedResult, actualResult);
    }

}
