package com.quarkus.microservices.number;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/numbers")
public class NumberResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getNumber(){
        return "1";
    }
}
