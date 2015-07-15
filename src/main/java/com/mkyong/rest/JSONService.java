package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mkyong.database.ClentData;
import com.mkyong.database.ClientDataStore;
import com.mkyong.database.CustomConnection;
import com.mkyong.database.Database;
import com.mkyong.database.Device;
import com.mkyong.database.FillDeviceDetails;
import com.mkyong.database.Sql;
import com.mkyong.database.SqlDelete;
import com.mkyong.database.SqlInsert;
import com.mkyong.database.SqlInsertSeverRegisteration;
import com.mkyong.database.SqlUpdate;
import com.mkyong.database.mongo;
import com.mkyong.database.mongoDelete;
import com.mkyong.database.mongoInsert;
import com.mkyong.database.mongoInsertServerRegistration;
import com.mkyong.database.mongoUpdate;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mykong.pojo.Product;

 
@Path("/device")
public class JSONService {
	String textUri_bootstrap_db = "mongodb://gunjan:khandelwal@ds047802.mongolab.com:47802/bootstrap_db";
	MongoClientURI uri = new MongoClientURI(textUri_bootstrap_db);
	MongoClient mongoClient = new MongoClient( uri );
	String textUri_client_db = "mongodb://gunjan:khandelwal@ds047592.mongolab.com:47592/client_db";
	MongoClientURI uri2 = new MongoClientURI(textUri_client_db);
	MongoClient mongoClient2 = new MongoClient( uri2 );
	String textUri_server_db = "mongodb://gunjan:khandelwal@ds047722.mongolab.com:47722/server_db";
	MongoClientURI uri3 = new MongoClientURI(textUri_server_db);
	MongoClient mongoClient3 = new MongoClient( uri3 );
	@GET
	@Path("{productId}")
	@Produces("application/json")
	public Product bootstrap(@PathParam("productId")String productId) throws Exception {
		mongo mongo=new mongo();
		mongoInsert s=new mongoInsert();
	//	Sql sql=new Sql();
		//SqlInsert s=new SqlInsert();
	//	CustomConnection conn =new CustomConnection();
		Product p=new Product();
	    p=mongo.getdata(productId,mongoClient);	  
		
        s.insertdata(p,mongoClient2);
		return mongo.getdata(productId,mongoClient);
		}
		

	 
		
	

	@POST
	@Path("register")
	@Consumes("application/json")
	@Produces("text/plain")
	public Response registration(ClentData c) throws Exception {
	//	SqlInsertSeverRegisteration s=new SqlInsertSeverRegisteration();
		mongoInsertServerRegistration s=new mongoInsertServerRegistration();

	//	CustomConnection conn =new CustomConnection();
	      s.insertdata(c,mongoClient3);
		String result = "Device registered : ";
		return Response.status(201).entity(result).build();
		
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
}