package com.quarkus.microservices.number;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class NumberResourceTest {

    @Test
    public void testGetNumberEndpoint(){
        given()
                .when().get("api/numbers")
                .then().statusCode(200).body("isbn_13",startsWith("13-")).body(not(hasKey("generationDate")));
    }
}
