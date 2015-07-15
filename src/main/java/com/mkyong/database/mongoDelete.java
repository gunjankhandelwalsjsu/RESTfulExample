package com.mkyong.database;

import java.sql.Connection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class mongoDelete {
	   public void deletedata(String object_id,MongoClient mongoClient) {
		   DB db = mongoClient.getDB( "server_db" );

       	BasicDBObject query = new BasicDBObject("object_id", object_id);
	DBCollection table = db.getCollection("device");
 
	table.remove(query);
}
}