package com.mkyong.P8080;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.mkyong.database.ClentData;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

//changing a particular resource_id(from 0 to 4)
public class MongoPartialUpdateResource {
	 public void updatedata(String resource_id,String product_id,MongoClient mongoClient) {
			DB db = mongoClient.getDB( "client_db_attributes" );
			DBCollection table = db.getCollection("device");

	        DBObject query = new BasicDBObject("resource_id.Rid",resource_id);

	        BasicDBObject listItem = new BasicDBObject();
	   //   listItem.append("$set", new BasicDBObject().append("resource_id.Rid", "5"));
	     listItem.put("Rid", "5");
	     listItem.put("Name", "Maximum Voltage");
	        BasicDBObject update = new BasicDBObject("$set",
	        	    new BasicDBObject("resource_id", listItem));

	       DBObject updateObj = new BasicDBObject("resource_id.Rid", listItem);
   
//
	     table.update(new BasicDBObject().append("object_id", "3333").append("instance_id.instance_id", "0").append("instance_id.resource_id.Rid", resource_id),
	                  new BasicDBObject("$set", new BasicDBObject("instance_id.$.instance_id", "5")));
	//update Rid to 5     
	     
//	     table.update(new BasicDBObject().append("object_id", "3333").append("instance_id.instance_id", "0").append("instance_id.resource_id.Rid", resource_id),
 //                new BasicDBObject("$set", new BasicDBObject("instance_id.$.resource_id.0.Rid", "5")));
}
}

