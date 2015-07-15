package com.mkyong.database;

import java.sql.Connection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class mongoUpdate {
	   public void updatedata(String lifetime,String object_id,MongoClient mongoClient) {
		   DB db = mongoClient.getDB( "server_db" );
			DBCollection table = db.getCollection("device");
			BasicDBObject query = new BasicDBObject();
			query.put("object_id", object_id);
		 
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("lifetime", lifetime);
		 
			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);
		 
			table.update(query, updateObj);
		 
	   }
}
