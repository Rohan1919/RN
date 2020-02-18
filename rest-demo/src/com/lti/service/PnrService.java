package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.lti.model.Passenger;
import com.lti.model.Passenger.Gender;
import com.lti.model.Passenger.Status;
import com.lti.model.PnrStatus;

/**
 * 
 * @author IRCTC
 *
 */
@Path("/pnr")
public class PnrService {
	List<Passenger> passenger=new ArrayList<Passenger>();
	@GET    //which method of HTTP (GET,POST,PUT,DELETE,....)
	@Produces("application/json")   //converting object into json to travel over the network
	                                 //how will be the data will represented(xml/json)
	
	public PnrStatus getStatus(@QueryParam("pnrNo")long pnrNo,@Context HttpServletResponse response){
		//How will the client send the pnrNo(QueryParam/PathParam/MutrixParam
		//IN REAL SYSTEM ,WE MIGHT INVOKE SOME DAO CLASS FROM HERE TO GET THE PNR 
		//STATUS FROM THE DATABASE AND THEN RETURN IT
		//FOR THE TIME BEING WE WILL RETURN SOME DUMMY DATA
		//enabling CORS
		response.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
		PnrStatus pnrStatus=new PnrStatus();
		pnrStatus.setPnrNo(pnrNo);
		pnrStatus.setTrainNo(12345);
		pnrStatus.setTravelDate(LocalDate.of(2020,2,10));
		Passenger p1=new Passenger();
		Passenger p2=new Passenger();
		
		p1.setName("rohan");
		p1.setAge("21");
		p1.setGender(Gender.MALE);
	    p1.setStatus(Status.CONFIRMED);
	    
	    p2.setName("sohan");
		p2.setAge("25");
		p2.setGender(Gender.MALE);
	    p2.setStatus(Status.RAC);
		
	    passenger.add(p1);
	    passenger.add(p2);
	    pnrStatus.setPassenger(passenger);
		
	   return pnrStatus;
		
	}

}
