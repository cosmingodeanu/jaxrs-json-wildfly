package com.poc.endpoints;

import org.glassfish.jersey.process.internal.RequestScoped;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class Login {

    @Path("/login")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public JsonObject login(@FormParam("username") String username, @FormParam("password") String password) {
        if (username.equals("me") && password.equals("me")){
            JsonObject jsObj = Json.createObjectBuilder().add("authToken", "jwt_token").add("username", username).build();
            return Json.createObjectBuilder()
                    .add("user", jsObj).add("status", "success")
                    .build();
        }
        return Json.createObjectBuilder().add("status", "failed").add("message", "YOU SHALL NOT PASS!").build();
    }

    @GET
    @RequestScoped
    @Path("/status")
    @Produces({MediaType.APPLICATION_JSON})
    public JsonObject getStatus() {

        return Json.createObjectBuilder()
                .add("status", "ko")
                .build();
    }
}
