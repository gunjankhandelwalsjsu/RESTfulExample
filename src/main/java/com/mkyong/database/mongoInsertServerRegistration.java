package com.mkyong.database;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mykong.pojo.Product;

public class mongoInsertServerRegistration {
	public void insertdata(ClentData product,MongoClient mongoClient)
	{
		
		DB db = mongoClient.getDB( "server_db" );
		DBCollection table = db.getCollection("device");
		BasicDBObject document = new BasicDBObject();
		document.put("object_id", product.getObject_id());
		document.put("resource_id1", product.getResource_id1());
		document.put("resource_id2", product.getResource_id2());
		document.put("lifetime", product.getLifetime());
		table.insert(document);
	
	}

}
