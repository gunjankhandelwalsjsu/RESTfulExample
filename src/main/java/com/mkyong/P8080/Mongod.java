package com.mkyong.P8080;

import java.sql.Connection;
import java.sql.Statement;

import com.mkyong.database.ClentData;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mykong.pojo.Product;

public class Mongod {
	 public ClentData getdata(String product_id,MongoClient mongoClient) {
		   ClentData product=new ClentData();
		   Statement stmt = null;
			DB db = mongoClient.getDB( "client_db" );

        	BasicDBObject query = new BasicDBObject("object_id", product_id);
        	DBCollection coll = db.getCollection("device");
        	DBCursor cursor = coll.find(query);

	try {
	   while(cursor.hasNext()) {
		   DBObject tobj = cursor.next();
           System.out.println(tobj);
           product.setObject_id((String) tobj.get("object_id"));
           product.setResource_id1((String) tobj.get("resource_id1"));
           product.setResource_id2((String) tobj.get("resource_id2"));
           product.setLifetime((String) tobj.get("lifetime"));

   	   }
	} finally {
	   cursor.close();
	}
	return product;
}
}

