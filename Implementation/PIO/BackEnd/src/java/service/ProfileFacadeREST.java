/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Profile;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

/**
 *
 * @author Khumalo
 */
@Stateless
@Path("profile")
public class ProfileFacadeREST extends AbstractFacade<Profile> {

    @EJB
    private PIOBeanLocal pIOBean;

    @PersistenceContext(unitName = "BackEndPU")
    private EntityManager em;
    
    

    public ProfileFacadeREST() {
        super(Profile.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Profile entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Profile entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Profile find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profile> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profile> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Path("register")
     @POST
     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
     public void login(@FormParam("UserName") String username, @FormParam("LastName") String lastname,
     @FormParam("FirstName") String FirstName, @FormParam("Email") String Email,
             @FormParam("Password") String Password, @FormParam("confrimPassword") String confrimPassword) 
     {
         Profile p = new Profile();
         p.setFirstName(FirstName);
         p.setSurname(lastname);
         p.setEmail(Email);
         p.setUsername(username);
         p.setPassword(Password);
//         super.create(p);
         pIOBean.register(p);
      
    }
    
     @GET
    @Path("login/{UserName}/{Password}") //path for html
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    @Produces({MediaType.APPLICATION_XML})
    public Profile login(@PathParam("UserName") String UserName, @PathParam("Password") String password) {
        TypedQuery<Profile> query = em.createQuery("SELECT a FROM Profile a WHERE a.username = '"+UserName + "'AND a.password= '"+password+"'",Profile.class);
        Profile profile = query.getSingleResult(); //gets the object containing the username and password
        if(profile == null){
            return profile;
        }
        else{
            return profile;
        }
    }
    
}
