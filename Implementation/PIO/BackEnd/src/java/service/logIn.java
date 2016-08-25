package service;
import Entities.UpFrontCosts;
import static com.sun.faces.facelets.util.Path.context;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


/**
 *
 * @author Khumalo
 */
@Path("login")
public class logIn {

    /**
     *
     * @param username
     */
    @POST
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 public void login(@FormParam("UserName") String username){
     System.out.print(username);
     if(username.equals("Sandile")){
    
     }
 }
}
