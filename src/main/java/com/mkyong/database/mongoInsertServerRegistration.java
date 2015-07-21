package com.mkyong.database;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mykong.pojo.Product;

public class mongoInsertServerRegistration {
	public void insertdata(NewClentData c,MongoClient mongoClient)
	{
		
		DB db = mongoClient.getDB( "server_db" );
		DBCollection table = db.getCollection("device");
		BasicDBObject document = new BasicDBObject();
		document.put("object_id", c.getObject_id());
		ArrayList<ResourceForClient> resourceList=c.getResources();
		DBObject dbo;

		ArrayList< DBObject > array = new ArrayList< DBObject >();
	
		 
		for(int i=0;i<resourceList.size();i++)
		{
			dbo=resourceList.get(i).bsonFromPojo();
			array.add(dbo);
		}
		document.put( "resource_id", array );
		document.put("lifetime", c.getLifetime());
		document.put("instance_id", c.getInstance_id());

		table.insert(document);
	
	}

}
