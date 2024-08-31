package com.quarkus.microservices.book;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testGetBookEndpoint() {
        given()
                .when().get("/api/numbers")
                .then().statusCode(200).body(is("new book"));
    }
}
