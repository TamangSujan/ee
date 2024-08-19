package pro.sujan.ee.controller;

import jakarta.json.Json;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
public class RestController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHome(){
        return Json.createObjectBuilder()
                .add("key", "value")
                .build()
                .toString();
    }
}
