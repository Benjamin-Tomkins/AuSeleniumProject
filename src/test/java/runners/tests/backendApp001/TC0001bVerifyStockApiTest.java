package runners.tests.backendApp001;

import apps.backend.backendApp001.endpoiont.data.ApiGetProcessor;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tools.configs.PropertyLoader;

@RunWith(SerenityRunner.class)
public class TC0001bVerifyStockApiTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    ApiGetProcessor apiSteps;

    private String url = PropertyLoader.getProperty("BASE_URL_STOCKAPI");
    private String urlParams = PropertyLoader.getProperty("TC0001BURL_PARAMS1");
    private String expectedDesc = PropertyLoader.getProperty("TC0001BEXPECTED_TEXT_DESC");
    private String expectedName = PropertyLoader.getProperty("TC0001BEXPECTED_TEXT_Name");
    private String descMatcher = PropertyLoader.getProperty("TC0001BDESC_MATCHER");
    private String nameMatcher = PropertyLoader.getProperty("TC0001BNAME_MATCHER");

    @Test
    public void stockApiReturnsValidStockCompanyDescription() {
        apiSteps.searchStockBySymbol(url.concat(urlParams));
        apiSteps.verifyResponseCode(200);
        apiSteps.shouldReturnCorrectData(descMatcher, expectedDesc);
    }

    @Test
    public void stockApiReturnsValidStockCompanyName() {
        apiSteps.searchStockBySymbol(url.concat(urlParams));
        apiSteps.verifyResponseCode(200);
        apiSteps.shouldReturnCorrectData(nameMatcher, expectedName) ;
    }

}
