package io.swagger.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

public class Firsttest {
    @Test
    public void petTest() {
        String idTestValue = RandomStringUtils.randomNumeric(5);
        RestAssured.given()
                .baseUri("http://petstore.swagger.io/")
                .basePath("/v2/pet")
                .contentType(ContentType.JSON)
                .header("api_key", "12345")
                .body("{\n" +
                        " \"id\": " + idTestValue + ",\n" +
                        "\"name\": \" asdasdas \",\n" +
                        "\"photoUrls\": [],\n" +
                        "\"tags\": [],\n" +
                        "\"status\": \"pending\"\n" +
                        "}")
                .when().post()
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(Integer.valueOf(idTestValue)));
    }


}
