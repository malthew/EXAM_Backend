package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CourseDTO;
import errorhandling.AlreadyExistsException;
import facades.CourseFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author Malthe
 */
@Path("courses")
public class CourseResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    private static final CourseFacade FACADE = CourseFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"This is the 'courses' endpoint\"}";
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCourseCount() {
        long count = FACADE.getCourseCount();
        return "{\"count\":" + count + "}";
    }
    
    @GET
    @Path("/populate")
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        FACADE.populateDB();
        long count = FACADE.getCourseCount();
        return "{\"msg\":\"" + count + " rows added\"}";
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCourses() {
        return GSON.toJson(FACADE.getAllCourses());
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCourse(CourseDTO course) {
        try {
            return GSON.toJson(FACADE.addCourse(course));
        } catch (AlreadyExistsException ex) {
            throw new WebApplicationException(ex.getMessage(), 400);
        }
    }
}
