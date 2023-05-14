package rest;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.MotorData;
import data.measureData;

@Path("/robot")
public class send {
	@POST
	@Path("/speeds")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public MotorData postBookByParams(@FormParam("speed") int speed) {
	    MotorData motorData = new MotorData(speed);
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("info");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(motorData);
	    em.getTransaction().commit();
	    return motorData;
	}


@GET
@Path("/distance/{distance}/{time}")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public measureData getMileage(@PathParam("distance") float miles, @PathParam("time") long time) {
	measureData mileage=new measureData(miles,time);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("info");
    EntityManager em = emf.createEntityManager(); 	
    em.getTransaction().begin();
    em.persist(mileage);
    em.getTransaction().commit();
    return mileage;
}
}