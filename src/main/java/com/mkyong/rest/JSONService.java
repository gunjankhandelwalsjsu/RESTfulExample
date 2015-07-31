package com.mkyong.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.P8080.MongoCreate;
import com.mkyong.P8080.MongoDelete;
import com.mkyong.P8080.MongoDiscover;
import com.mkyong.P8080.MongoFullUpdateResource;
import com.mkyong.P8080.MongoPartialUpdateResource;
import com.mkyong.P8080.MongoRead;
import com.mkyong.P8080.MongoWriteAttributes;
import com.mkyong.database.ClentData;
import com.mkyong.database.NewClentData;
import com.mkyong.database.mongo;
import com.mkyong.database.mongoDelete;
import com.mkyong.database.mongoInsert;
import com.mkyong.database.mongoInsertServerRegistration;
import com.mkyong.database.mongoUpdate;
import com.mkyong.rest.client.DeviceName;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mykong.pojo.Attributes;
import com.mykong.pojo.DatabaseWithAttributes;
import com.mykong.pojo.FinalDatabase;
import com.mykong.pojo.NewProduct;
import com.mykong.pojo.Product;
@Path("/device")
public class JSONService {

	String NewtextUri_bootstrap_db ="mongodb://gunjan:khandelwal@ds037837.mongolab.com:37837/newbootstrap_db";
	MongoClientURI uri = new MongoClientURI(NewtextUri_bootstrap_db);
	MongoClient mongoClient = new MongoClient( uri );
	String textUri_bootstrap_db ="mongodb://gunjan:khandelwal@ds047802.mongolab.com:47802/bootstrap_db";
	MongoClientURI uri1 = new MongoClientURI(textUri_bootstrap_db);
	MongoClient mongoClient1 = new MongoClient( uri1 );
	String textUri_client_db = "mongodb://gunjan:khandelwal@ds047592.mongolab.com:47592/client_db";
	MongoClientURI uri2 = new MongoClientURI(textUri_client_db);
	MongoClient mongoClient2 = new MongoClient( uri2 );
	String textUri_server_db = "mongodb://gunjan:khandelwal@ds047722.mongolab.com:47722/server_db";
	MongoClientURI uri3 = new MongoClientURI(textUri_server_db);
	MongoClient mongoClient3 = new MongoClient( uri3 );
	String textUri_client_db_attributes = "mongodb://gunjan:khandelwal@ds047632.mongolab.com:47632/client_db_attributes";
	MongoClientURI uri4 = new MongoClientURI(textUri_client_db_attributes);
	MongoClient mongoClient4 = new MongoClient( uri4 );
	
	@GET
	@Path("{productId}")
	@Produces("application/json")
	public NewProduct bootstrap(@PathParam("productId")String productId) throws Exception {
		mongo mongo=new mongo();
		mongoInsert s=new mongoInsert();
		NewProduct p=new NewProduct();
	    p=mongo.getdata(productId,mongoClient);	  		
        s.insertdata(p,mongoClient2);
		return mongo.getdata(productId,mongoClient);
		}
		
	@GET
	@Path("/read/{objectId}")
	@Produces("application/json")
	public FinalDatabase readResponse(@PathParam("objectId")String objectId) throws Exception {
		
		MongoRead mongo=new MongoRead();	
		String deviceName=DeviceName(objectId);
		return mongo.getdata(deviceName,objectId,mongoClient4);
		}
	 
	private String DeviceName(String objectId) {
		// TODO Auto-generated method stub
		String deviceName = null;
		if(objectId.equals("3333"))
		  {
			 deviceName="Bulb";
		  }

		  else if(objectId.equals("3539"))
		  {
			  deviceName="Thermostat";
		  }
		  
		  else if(objectId.equals("3434"))
		  {
			  deviceName="Refrigerator";
		  }
		  return deviceName;
	}

	@GET
	@Path("/discover/{objectId}/{instanceId}")
	@Produces("application/json")
	public ArrayList<Attributes> discoverResponseInstance(@PathParam("objectId")String objectId,@PathParam("instanceId")String instanceId) throws Exception {
		MongoDiscover mongo=new MongoDiscover();
		String deviceName=DeviceName(objectId);

		return mongo.getdata(deviceName,objectId,instanceId,mongoClient4);
		}

	//needs incorporation
/*	
	@GET
	@Path("/discover/{objectId}/{instanceId}/{resourceId}}")
	@Produces("application/json")
	public ArrayList<Attributes> discoverResponseResource(@PathParam("objectId")String objectId) throws Exception {
		MongoDiscover mongo=new MongoDiscover();	
		return mongo.getdata(objectId,mongoClient4);
		}
	
	*/
	
	
	@POST
	@Path("register")
	@Consumes("application/json")
	@Produces("text/plain")
	public Response registration(NewClentData c) throws Exception {
	//	SqlInsertSeverRegisteration s=new SqlInsertSeverRegisteration();
		mongoInsertServerRegistration s=new mongoInsertServerRegistration();

	//	CustomConnection conn =new CustomConnection();
	      s.insertdata(c,mongoClient3);
		String result = "Device registered : ";
		return Response.status(201).entity(result).build();
		
	}
	
	/**********WRITE UpdateResource*****************/
	@PUT
	@Path("/PartialUpdate/{object_id}/{instanceId}/{resource_id}")
	@Produces("text/plain")
	
	public String PartialUpdateResource(@PathParam("instanceId") String instanceId,@PathParam("resource_id") String resource_id,@PathParam("object_id") String objectId) throws Exception {
		MongoPartialUpdateResource s=new MongoPartialUpdateResource();
		DeviceName d=new DeviceName();
		String deviceName=DeviceName(objectId);
	    s.updatedata(deviceName,instanceId,resource_id,objectId,mongoClient4);
		return "updated registration";
	}
	
	@PUT
	@Path("/FullUpdate/{object_id}/{resource_id}")
	public String FullUpdateResource(@PathParam("resource_id") String resource_id,@PathParam("object_id") String object_id) throws Exception {
		MongoFullUpdateResource s=new MongoFullUpdateResource();
		String deviceName=DeviceName(object_id);

	    s.updatedata(deviceName,resource_id,object_id,mongoClient4);
		return "updated registration";
	}
	
	@PUT
	@Path("/WriteAttributes/{object_id}/{resource_id}")
	public String WriteAttributesResource(@PathParam("resource_id") String resource_id,@PathParam("object_id") String object_id) throws Exception {
		MongoWriteAttributes s=new MongoWriteAttributes();
		String deviceName=DeviceName(object_id);

	    s.updatedata(deviceName,resource_id,object_id,mongoClient4);
		return "updated registration";
	}
	
	@PUT
	@Path("/Create/{object_id}/{instance_id}")
	public String CreateInstance(@PathParam("instance_id") String instance_id,@PathParam("object_id") String object_id) throws Exception {
		MongoCreate s=new MongoCreate();
		String deviceName=DeviceName(object_id);

		s.updatedata(deviceName,instance_id,object_id,mongoClient4);
		return "instance Created";
	}
	
	@PUT
	@Path("/{object_id}/{lifetime}")
	public String update(@PathParam("lifetime") String lifetime,@PathParam("object_id") String object_id) throws Exception {
		mongoUpdate s=new mongoUpdate();
	    s.updatedata(lifetime,object_id,mongoClient3);

		return "updated registration";
	}
	
	@DELETE
	@Path("/delete/{object_id}")
	public String DeRegister(@PathParam("object_id") String object_id) throws Exception {
	//	CustomConnection conn =new CustomConnection();
		mongoDelete s=new mongoDelete();
	    s.deletedata(object_id,mongoClient3);
		return "de-registered";
	}
	
	@DELETE
	@Path("/delete/{object_id}/{instance_id}")
	public String deleteInstance(@PathParam("object_id") String object_id,@PathParam("instance_id") String instance_id) throws Exception {
	//	CustomConnection conn =new CustomConnection();
		MongoDelete s=new MongoDelete();
		String deviceName=DeviceName(object_id);

	    s.deletedata(deviceName,instance_id,object_id, mongoClient4);
		return "deleting";
	}
	

}