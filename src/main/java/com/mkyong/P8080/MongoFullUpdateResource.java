package com.mkyong.P8080;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoFullUpdateResource {
	 public void updatedata(String resource_id,String product_id,MongoClient mongoClient) {
			DB db = mongoClient.getDB( "client_db_attributes" );
			DBCollection table = db.getCollection("device");
	
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("resource_id.$.Rid", "5");
			

			 table.update(new BasicDBObject().append("object_id", "3333").append("instance_id.instance_id", "0").append("instance_id.resource_id.Rid", resource_id),
					             new BasicDBObject("$set", new BasicDBObject("instance_id.$.resource_id", "5")));
	
}
}
