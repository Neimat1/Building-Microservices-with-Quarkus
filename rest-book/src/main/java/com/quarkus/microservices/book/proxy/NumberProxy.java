package com.quarkus.microservices.book.proxy;

import com.quarkus.microservices.book.model.IsbnThirteen;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "number.proxy")
@Path("/api/numbers")
public interface NumberProxy {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    IsbnThirteen generateIsbnNumbers();
}
