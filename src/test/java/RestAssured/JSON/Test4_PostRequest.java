package RestAssured.JSON;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Test4_PostRequest {

    @Test
    public void testPostReq() {
        given()
                .headers("AppKey", "Key-value1")
                .param("bla-bla_name", "first")
                .param("ble-ble_name", "last")
                .param("blu-blumail","test@test.com")
                .when()
                .post("http://api.fonts.com/rest/json/Accounts/")
                .then()
                .statusCode(401).log().all();
    }

}
