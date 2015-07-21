package com.mkyong.database;

import java.sql.Connection;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mykong.pojo.NewProduct;
import com.mykong.pojo.Product;

public class mongoInsert {
	public void insertdata(NewProduct product,MongoClient mongoClient)
	{
		
		DB db = mongoClient.getDB( "client_db" );
		DBCollection table = db.getCollection("device");
		BasicDBObject document = new BasicDBObject();
		document.put("object_id", product.getObject_id());
		document.put("instance_id", product.getInstance_id());

		ArrayList<ResourceForClient> resourceList=product.getResources();
		DBObject dbo;

		ArrayList< DBObject > array = new ArrayList< DBObject >();
	
		 
		for(int i=0;i<resourceList.size();i++)
		{
			dbo=resourceList.get(i).bsonFromPojo();
			array.add(dbo);
	//	document.put("resource_id", product.getResources());
		}
		document.put( "resource_id", array );

		document.put("uri", product.getUri());
		document.put("lifetime", 5);
		table.insert(document);
	
	}
}
