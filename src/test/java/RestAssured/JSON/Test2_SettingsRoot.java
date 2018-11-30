package RestAssured.JSON;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Test2_SettingsRoot {

    @Test
    public void testWithoutRoot() {
        given()
                .get("http://services.groupkt.com/country/get/iso2code/IT")
                .then()
                .body("RestResponse.result.name", is("Italy"))
                .body("RestResponse.result.alpha2_code", is("IT"))
                .body("RestResponse.result.alpha3_code", is("ITA"));
    }

    @Test
    public void testWithRoot() {
        given()
                .get("http://services.groupkt.com/country/get/iso2code/IT")
                .then()
                .root("RestResponse.result.")
                .body("name", is("Italy"))
                .body("alpha2_code", is("IT"))
                .detachRoot("result")  //  hasn't result
                .body("result.alpha3_code", is("ITA"));
    }
}
