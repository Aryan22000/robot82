package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import data.MotorData;
import java.util.List;
@Path("/tadaa")
public class readData {
  @GET
  @Path("/tuduu")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSpeed() {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("info"); //to execute a query to retrieve MotorData objects from the database
      EntityManager em = emf.createEntityManager();
      TypedQuery<MotorData> query = em.createQuery("SELECT m FROM MotorData m", MotorData.class);
      List<MotorData> motorDataList = query.getResultList();
      MotorData motorData = motorDataList.get(motorDataList.size() - 1);
      int speedA = motorData.getSpeed();
      return ""+speedA; //convert return to integer
  }
}
