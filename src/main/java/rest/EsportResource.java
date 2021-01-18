package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.EsportFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author Malthe
 */
@Path("esports")
public class EsportResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    private static final EsportFacade FACADE = EsportFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public String getEsportsCount() {
        long count = FACADE.getEsportCount();
        return "{\"count\":" + count + "}";
    }
    
    @GET
    @Path("/populate")
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        FACADE.populateDB();
        long count = FACADE.getEsportCount();
        return "{\"msg\":\"" + count + " rows added\"}";
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEsports() {
        return GSON.toJson(FACADE.getAllEsports());
    }
}
