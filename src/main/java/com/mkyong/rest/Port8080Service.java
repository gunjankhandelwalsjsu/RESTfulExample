package com.mkyong.rest;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mkyong.P8080.Mongod;
import com.mkyong.database.ClentData;
import com.mkyong.database.mongo;
import com.mkyong.database.mongoInsert;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mykong.pojo.Product;

@Path("/clientSide")

public class Port8080Service {
	String textUri_client_db = "mongodb://gunjan:khandelwal@ds047592.mongolab.com:47592/client_db";
	MongoClientURI uri2 = new MongoClientURI(textUri_client_db);
	MongoClient mongoClient2 = new MongoClient( uri2 );
	@GET
	@Path("{objectId}")
	@Produces("application/json")
	public ClentData readResponse(@PathParam("objectId")String objectId) throws Exception {
		Mongod mongo=new Mongod();
	//	mongoInsert s=new mongoInsert();
	//	Sql sql=new Sql();
		//SqlInsert s=new SqlInsert();
	//	CustomConnection conn =new CustomConnection();
	 
		
//        s.insertdata(p,mongoClient2);
		return mongo.getdata(objectId,mongoClient2);
		}
		
	

}
