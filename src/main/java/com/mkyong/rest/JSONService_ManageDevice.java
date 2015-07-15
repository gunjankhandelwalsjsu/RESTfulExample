package com.mkyong.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.mkyong.database.ClentData;

import com.mkyong.database.Database;
import com.mkyong.database.Device;

import com.mkyong.database.mongo;
import com.mkyong.database.mongoDelete;
import com.mkyong.database.mongoInsert;
import com.mkyong.database.mongoInsertServerRegistration;
import com.mkyong.database.mongoUpdate;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mykong.pojo.Product;

 
@Path("/ManageDevice")
public class JSONService_ManageDevice {
	
	@GET
	@Path("{objectId}")
	@Produces("application/json")
	public void readResponse(@PathParam("objectId")String objectId) throws Exception {
		
	}
	@POST
	@Path("read")
	@Consumes("application/json")
	@Produces("text/plain")
	public void sendReadToClient() throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet("http://localhost:8080/RESTfulExample/ManageDevice/read/3333");
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {

			System.out.println(output);
		}

		httpClient.getConnectionManager().shutdown();
		
	}

}
