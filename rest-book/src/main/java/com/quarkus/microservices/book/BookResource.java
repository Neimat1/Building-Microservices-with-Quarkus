package com.quarkus.microservices.book;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import java.time.Instant;

@Path("/api/books")
@Tag( name = "Book Rest endpoint")
public class BookResource {

    @Inject
    Logger logger;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(
            summary = "Create a Book",
            description = "Creates a Book with an ISBN number ")
    public Response createABook(@FormParam("title") String title,
                                @FormParam("author") String author,
                                @FormParam("yearOfPublication") int yearOfPublication,
                                @FormParam("genre") String genre) {
        Book book = new Book();
        book.isbn13 = "We will get it later from the Number Microservice";
        book.title = title;
        book.author = author;
        book.yearOfPublication = yearOfPublication;
        book.genre = genre;
        book.creationDate = Instant.now();

        logger.info("Book created: "+ book);
        return Response.ok(201).entity(book).build();
    }
}
