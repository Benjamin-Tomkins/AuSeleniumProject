package apps.backend.backendApp001.endpoiont.data;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.*;

public class ApiGetProcessor {

    private Response response;

    @Step
    public void searchStockBySymbol(String url) {
        response = RestAssured.when().get(url);
    }

    @Step
    public void verifyResponseCode(int code) {
        response.then().assertThat().statusCode(code);
    }

    @Step
    public void shouldReturnCorrectData(String matcher, String expectedContent) {
        response.then().body(matcher, is(expectedContent));
    }

}
