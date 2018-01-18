package com.cloud;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
	public static String CurrentTemperature="23 °C";
	
	   @GET
	   @Path("/restGet")
	   @Produces(MediaType.APPLICATION_JSON)
	   public String getUsers(@QueryParam("user_id") String name){
		   
		   System.out.println("coming in java");
		   System.out.println(name);
		   
		 //  HttpRequest(name);
		   
	      return CurrentTemperature;//userDao.getAllUsers();
	   }
	   
	   
	   @POST
	   @Path("/restPost")
	   @Produces(MediaType.APPLICATION_JSON)
	   public void saveUser(String data) throws JsonParseException, JsonMappingException, IOException, JSONException
	   {
		   
		   System.out.println(data);
		   System.out.println("coming in post");
		   CurrentTemperature=data;
		
	   }
	 
	   
	   public void HttpRequest(String browserUrl)
	   {
		   HttpURLConnection connection = null;
		   String targetURL = browserUrl+"rest/PostService/restPost";
		   String urlParameters="";
		   try {
			    //Create connection
			    URL url = new URL(targetURL);
			    connection = (HttpURLConnection) url.openConnection();
			    connection.setRequestMethod("POST");
			    connection.setRequestProperty("Content-Type", 
			        "application/x-www-form-urlencoded");

			    connection.setRequestProperty("Content-Length", 
			        Integer.toString(urlParameters.getBytes().length));
			    connection.setRequestProperty("Content-Language", "en-US");  

			    connection.setUseCaches(false);
			    connection.setDoOutput(true);

			    //Send request
			    DataOutputStream wr = new DataOutputStream (
			        connection.getOutputStream());
			    wr.writeBytes(urlParameters);
			    wr.close();

			    //Get Response  
			    InputStream is = connection.getInputStream();
			    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			    String line;
			    while ((line = rd.readLine()) != null) {
			      response.append(line);
			      response.append('\r');
			    }
			    rd.close();
			    System.out.println( response.toString());
			  } catch (Exception e) {
			    e.printStackTrace();
			  
			  } finally {
			    if (connection != null) {
			      connection.disconnect();
			    }
			  }
	   }
	
}
