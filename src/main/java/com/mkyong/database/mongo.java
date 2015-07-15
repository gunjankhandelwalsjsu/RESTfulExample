package com.mkyong.database;

import java.sql.Connection;
import java.sql.Statement;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mykong.pojo.Product;

public class mongo {
	 public Product getdata(String product_id,MongoClient mongoClient) {
		   Product product=new Product();
		   Statement stmt = null;
			DB db = mongoClient.getDB( "bootstrap_db" );

        	BasicDBObject query = new BasicDBObject("object_id", product_id);
        	DBCollection coll = db.getCollection("device");
        	DBCursor cursor = coll.find(query);

	try {
	   while(cursor.hasNext()) {
		   DBObject tobj = cursor.next();
           System.out.println(tobj);
           product.setObjectId((String) tobj.get("object_id"));
           product.setResourceId1( (String) tobj.get("resource_id1"));
           product.setResourceId2((String) tobj.get("resource_id2"));
           product.setUri((String) tobj.get("uri"));


   	   }
	} finally {
	   cursor.close();
	}
	return product;
}
}

