package runners.tests.frontendApp001;

import apps.forntend.frontendApp001.steps.FrontApp001Steps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tools.configs.PropertyLoader;

@RunWith(SerenityRunner.class)
public class TC0001aSearchGoogleTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    private String url = PropertyLoader.getProperty("BASE_URL_GOOGLE");

    @Steps
    private FrontApp001Steps testSteps;

    @Test
    public void userCanSearchItemOnGoogle() {
        String query = PropertyLoader.getProperty("TC0001aSearchQuery1");
        String expectedText = PropertyLoader.getProperty("TC0001aExpectedText");
        testSteps.navigateToUrl(url);
        testSteps.inputSearchQuery(query);
        Assert.assertTrue(testSteps.verifyText(expectedText));
    }

}
