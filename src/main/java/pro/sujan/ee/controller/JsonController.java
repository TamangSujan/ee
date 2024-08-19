package pro.sujan.ee.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pro.sujan.ee.database.entity.UserEntity;

@Path("/test/bind")
public class JsonController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("Sujan");
        user.setPassword("Password");
        try(Jsonb json = JsonbBuilder.create()){
            return json.toJson(user);
        }
    }
}
