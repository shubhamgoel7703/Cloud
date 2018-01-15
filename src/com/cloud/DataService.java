package com.cloud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/PostService")
public class DataService 
{
	
	 @GET
	   @Path("/restGet")
	   @Produces(MediaType.APPLICATION_JSON)
	   public String getUsers(@QueryParam("user_id") String name){
		   
		   System.out.println("coming in java");
		   System.out.println(name);
		   
		
		   
	      return "Shubham";//userDao.getAllUsers();
	   }
	   
	   
	   @POST
	   @Path("/restPost")
	   @Produces(MediaType.APPLICATION_JSON)
	   public void saveUser(String data) throws JsonParseException, JsonMappingException, IOException, JSONException
	   {
		   
		   System.out.println(data);
		   System.out.println("coming in post");
		   
		
	   }
	 
	
}
