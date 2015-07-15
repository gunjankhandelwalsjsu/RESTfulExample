package com.mkyong.database;

import java.sql.Connection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mykong.pojo.Product;

public class mongoInsert {
	public void insertdata(Product product,MongoClient mongoClient)
	{
		
		DB db = mongoClient.getDB( "client_db" );
		DBCollection table = db.getCollection("device");
		BasicDBObject document = new BasicDBObject();
		document.put("object_id", product.getObjectId());
		document.put("resource_id1", product.getResourceId1());
		document.put("resource_id2", product.getResourceId2());
		document.put("uri", product.getUri());
		document.put("lifetime", 5);
		table.insert(document);
	
	}
}
