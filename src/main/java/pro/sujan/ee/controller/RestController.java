package pro.sujan.ee.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/rest/controller/get")
public class RestController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHome(){
        return "Hello";
    }
}
