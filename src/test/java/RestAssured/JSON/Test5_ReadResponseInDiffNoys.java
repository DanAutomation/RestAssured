package RestAssured.JSON;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class Test5_ReadResponseInDiffNoys {

    @Test
    public void testGetResponseAsString() {
        String responseAsString = get("http://services.groupkt.com/country/search?text=lands").asString();
        System.out.println("My response:\n\n\n" + responseAsString);
    }

    @Test
    public void testGetResponseAsInputStream() throws IOException {
        InputStream stream = get("http://services.groupkt.com/country/get/iso2code/CN").asInputStream();
        System.out.println("Stream length: " + stream.toString().length());
        stream.close();
    }

    @Test
    public void testGetResponseAsByteArray() {
        byte[] byteArray = get("http://services.groupkt.com/country/get/iso2code/CN").asByteArray();
        System.out.println(byteArray.length);
    }

    /*
    extract details using path
     */
    @Test
    public void testExtractDetailsUsingPath() {
        String href =
                when()
                .get("http://jsonplaceholder.typicode.com/photos/1")
                .then()
                .contentType(ContentType.JSON)
                .body("albumId", equalTo(1))
                .extract()
                .path("url");
        System.out.println(href);

        when().get(href).then().statusCode(200); // check that extracted url from JSON has status 200
    }

    @Test
    public void testExtractPathInOneLine() {
        // type 1
        String href = get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
        System.out.println("Fetched url is: " + href);
        when().get(href).then().statusCode(200);
    }


}
