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
    
    /**
     *
     */
    public ProfileFacadeREST() {
        super(Profile.class);
    }

    /**
     *
     * @param entity
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Profile entity) {
        super.create(entity);
    }

    /**
     *
     * @param id
     * @param entity
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Profile entity) {
        super.edit(entity);
    }

    /**
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Profile find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     *
     * @return
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profile> findAll() {
        return super.findAll();
    }

    /**
     *
     * @param from
     * @param to
     * @return
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profile> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     *
     * @return
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     *
     * @param username
     * @param lastname
     * @param FirstName
     * @param Email
     * @param Password
     * @param confrimPassword
     */
    @Path("register")
     @POST
     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
     public void register(@FormParam("firstName") String firstName,@FormParam("lastName") String lastName,@FormParam("UserName") String username, @FormParam("Email") String Email,
             @FormParam("Password") String Password, @FormParam("confrimPassword") String confrimPassword) 
     {
         Profile p = new Profile();
         p.setEmail(Email);
         p.setUsername(username);
         p.setPassword(Password);
         p.setFirstname(lastName);
         p.setLastName(firstName);
         
//         super.create(p);
         pIOBean.register(p);
      
    }
    
    /**
     *
     * @param loginEmail
     * @param loginPassword
     * @param UserName
     * @param password
     * @return
     */
    @GET
    @Path("login/{Email}/{Password}") //path for html
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    @Produces({MediaType.APPLICATION_XML})



    public Profile login(@PathParam("Email") String loginEmail, @PathParam("Password") String loginPassword) {
        TypedQuery<Profile> query = em.createQuery("SELECT a FROM Profile a WHERE a.email = '"+loginEmail + "'AND a.password= '"+loginPassword+"'",Profile.class);
        Profile profile = query.getSingleResult(); //gets the object containing the username and password
        
            return profile;
        
    }
    
    @GET
    @Path("retrieveProfile/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML})
    public Profile retrieveProperties(@PathParam("id") Long id) {
        
        if(id == -1)
            throw new ArithmeticException("invalid input");
        
        TypedQuery<Profile> query = em.createQuery("SELECT a FROM Profile a WHERE a.id = "+id+"",Profile.class);
        Profile p = query.getSingleResult();

        return p;
    }  
    
    @Path("/deleteProfile")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
     public  void deleteProfile(@FormParam("profileID") int profileID){

         if(profileID < 0)
           throw new ArithmeticException("invalid input");     
         else{
           int  query = em.createQuery("DELETE FROM Property a WHERE a.id = "+profileID+"",Profile.class).executeUpdate();
         }


     }
}
