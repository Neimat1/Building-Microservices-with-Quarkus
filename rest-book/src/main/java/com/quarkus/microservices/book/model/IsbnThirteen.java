package com.quarkus.microservices.book.model;

import jakarta.json.bind.annotation.JsonbProperty;

public class IsbnThirteen {
    @JsonbProperty("isbn_13")
    public String isbn13;
}
