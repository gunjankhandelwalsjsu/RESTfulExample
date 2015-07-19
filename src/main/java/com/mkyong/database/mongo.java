package com.mkyong.database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mykong.pojo.NewProduct;
import com.mykong.pojo.Product;
import com.mykong.pojo.Resource;

public class mongo {
	 public NewProduct getdata(String product_id,MongoClient mongoClient) {
		   NewProduct product=new NewProduct();
		   Statement stmt = null;
			DB db = mongoClient.getDB( "newbootstrap_db" );

        	BasicDBObject query = new BasicDBObject("object_id", product_id);
        	DBCollection coll = db.getCollection("device");
        	DBCursor cursor = coll.find(query);

	try {
	   while(cursor.hasNext()) {
		   DBObject tobj = cursor.next();
           System.out.println(tobj);
           product.setObject_id((String) tobj.get("object_id"));
           ArrayList<ResourceForClient> resourceList = new ArrayList<ResourceForClient>(); 
           BasicDBList list = (BasicDBList)tobj.get("resource_id");

            for( Iterator< Object > it = list.iterator(); it.hasNext(); )
                {
                   BasicDBObject dbo = (BasicDBObject)it.next();
                   ResourceForClient resource = new ResourceForClient();
                   resource.makePojoFromBson( dbo );
                   resourceList.add(resource);
                }
           
           product.setResources(resourceList);
           product.setUri((String) tobj.get("uri"));


   	   }
	} finally {
	   cursor.close();
	}
	return product;
}
}

