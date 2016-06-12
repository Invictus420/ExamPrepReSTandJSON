/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReST;

import static stuff.CreateData.getData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Alex
 */
@Path("addresses")
public class Restful {

    @Context
    private UriInfo context;
    private Gson gson;
    /**
     * Creates a new instance of Restful
     */
    public Restful() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    
    @GET
    @Produces("application/json")
    @Path("/{num}/{props}")
    public String getJson(@PathParam("num") int num,@PathParam("props") String props) {
        return gson.toJson(getData(num,props));
    }

    /**
     * PUT method for updating or creating an instance of Restful
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
