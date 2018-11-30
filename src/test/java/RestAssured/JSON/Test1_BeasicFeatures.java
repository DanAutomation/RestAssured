package RestAssured.JSON;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class Test1_BeasicFeatures {

    @Test
    public void testStatusCode() {
        given().
                get("http://jsonplaceholder.typicode.com/posts/3")
                .then()
                .statusCode(200);
    }

    @Test
    public void testLogging() {
        given()
                .get("http://jsonplaceholder.typicode.com/posts/3")
                .then()
                .log().all();
    }

    @Test
    public void testEqualToFunction() {
        given()
                .get("http://jsonplaceholder.typicode.com/posts/3")
                .then()
                //.body("userId", equalTo(1))
                .body("title", equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"));
    }

    @Test
    public void testHasIteFunction() {
        given()
                .get("http://services.groupkt.com/country/get/all")
                .then()
                .body("RestResponse.result.name", hasItems("��land Islands", "Botswana", "Cameroon"));
    }

    @Test
    public void testParametersAndHeaders() {
        given()
                .param("key1", "value1")
                .header("headA", "valueA")
                .when()
                .get("http://services.groupkt.com/country/get/all")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testAndFeaturesForReadability(){
        given().param("key1", "value1")
                .and()
                .header("key2", "value2")
                .when()
                .get("http://services.groupkt.com/country/get/all")
                .then()
                .statusCode(200)
                .and()
                .body("RestResponse.result.name",hasItems("Afghanistan"));
    }
}
