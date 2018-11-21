package apps.forntend.frontendApp001.pages;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrontApp001HomePage extends PageObject {

    @FindBy(css = "input[name='q']")
    private WebElement searchInput;

    @FindBy(css = "div.mJ2Mod")
    private WebElement wikiTextDiv;

    public void inputSearchQuery(String searchQuery) {
        element(searchInput).waitUntilVisible();
        searchInput.sendKeys(searchQuery);
        searchInput.sendKeys(Keys.ENTER);
    }

    public String getWikiText() {
        return wikiTextDiv.getText();
    }

}
