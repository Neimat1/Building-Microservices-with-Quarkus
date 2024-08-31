package com.quarkus.microservices.book;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBook(){
        return "new book";
    }
}
