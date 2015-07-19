package com.mkyong.database;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mykong.pojo.Product;

public class mongoInsertServerRegistration {
	public void insertdata(NewClentData c,MongoClient mongoClient)
	{
		
		DB db = mongoClient.getDB( "server_db" );
		DBCollection table = db.getCollection("device");
		BasicDBObject document = new BasicDBObject();
		document.put("object_id", c.getObject_id());
		document.put("resource_id", c.getResources());
		document.put("lifetime", c.getLifetime());
		table.insert(document);
	
	}

}
