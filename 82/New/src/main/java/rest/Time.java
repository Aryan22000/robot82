package rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/robot")
public class Time {
	@POST
	@Path("/time")
    public String doSomething() {
        // Do something when the button is clicked
        System.out.println("Button clicked!");
        return null;
    }
}