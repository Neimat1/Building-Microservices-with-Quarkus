package com.quarkus.microservices.book;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldCreateBook() {
        given().formParam("title", "Book Title").formParam("author", "John Doe").formParam("yearOfPublication",2021).formParam("genre", "IT")
                .when().post("api/books")
                .then().statusCode(201).body("title", is("Book Title")).body("author", is("John Doe")).body("year_of_publication", is(2021)).body("genre", is("IT")).body("isbn_13",startsWith("13-"));
    }
}
