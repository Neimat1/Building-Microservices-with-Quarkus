package com.quarkus.microservices.book;

import com.quarkus.microservices.book.model.Book;
import com.quarkus.microservices.book.proxy.NumberProxy;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.time.Instant;

@Path("/api/books")
@Tag( name = "Book Rest endpoint")
public class BookResource {


    @Inject
    @RestClient
    NumberProxy proxy;

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
        book.isbn13 = proxy.generateIsbnNumbers().isbn13;
        book.title = title;
        book.author = author;
        book.yearOfPublication = yearOfPublication;
        book.genre = genre;
        book.creationDate = Instant.now();

        logger.info("Book created: "+ book);
        return Response.status(201).entity(book).build();
    }
}
