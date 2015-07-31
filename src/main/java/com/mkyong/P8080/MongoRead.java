package com.mkyong.P8080;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.mkyong.database.ClentData;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mykong.pojo.Attributes;
import com.mykong.pojo.DatabaseWithAttributes;
import com.mykong.pojo.FinalDatabase;
import com.mykong.pojo.Resource;

public class MongoRead {
	 public FinalDatabase getdata(String device,String product_id, MongoClient mongoClient) {
		    FinalDatabase product=new FinalDatabase();
			DB db = mongoClient.getDB( "client_db_attributes" );

        	BasicDBObject query = new BasicDBObject("object_id", product_id);
        	System.out.println(device);
        	DBCollection coll = db.getCollection(device);
        	DBCursor cursor = coll.find(query);

	try {
	   while(cursor.hasNext()) {
		   DBObject tobj = cursor.next();
           System.out.println(tobj);
           product.setObject_id((String) tobj.get("object_id"));
           
           ArrayList<DatabaseWithAttributes> instanceList = new ArrayList<DatabaseWithAttributes>(); 
           BasicDBList list1 = (BasicDBList)tobj.get("instances");
           for( Iterator< Object > it = list1.iterator(); it.hasNext(); )
           {
              BasicDBObject dbo = (BasicDBObject)it.next();
              DatabaseWithAttributes instance = new DatabaseWithAttributes();
              instance.makePojoFromBson( dbo );
              instanceList.add(instance);
           }    
           //2
           product.setAttributesOfItem(instanceList);
          

   	   }
	} finally {
	   cursor.close();
	}
	return product;
}
}

