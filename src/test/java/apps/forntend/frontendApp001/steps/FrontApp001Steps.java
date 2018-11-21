package apps.forntend.frontendApp001.steps;

import apps.forntend.frontendApp001.pages.FrontApp001HomePage;
import net.thucydides.core.annotations.Step;

public class FrontApp001Steps {

    FrontApp001HomePage googleHomePage;

    @Step
    public void inputSearchQuery(String query) {
        googleHomePage.inputSearchQuery(query);
    }

    @Step
    public void navigateToUrl(String url) {
        googleHomePage.getDriver().get(url);
    }

    @Step
    public boolean verifyText(String expectedText) {
        String c = googleHomePage.getWikiText();
        boolean i = googleHomePage.getWikiText().contains(expectedText);
        return googleHomePage.getWikiText().contains(expectedText);
    }
}
