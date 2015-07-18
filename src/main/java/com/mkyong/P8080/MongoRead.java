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
import com.mykong.pojo.Resource;

public class MongoRead {
	 public DatabaseWithAttributes getdata(String product_id,MongoClient mongoClient) {
		 DatabaseWithAttributes product=new DatabaseWithAttributes();
			DB db = mongoClient.getDB( "client_db_attributes" );

        	BasicDBObject query = new BasicDBObject("object_id", product_id);
        	DBCollection coll = db.getCollection("device");
        	DBCursor cursor = coll.find(query);

	try {
	   while(cursor.hasNext()) {
		   DBObject tobj = cursor.next();
           System.out.println(tobj);
           product.setObject_id((String) tobj.get("object_id"));
           ArrayList<Resource> resourceList = new ArrayList<Resource>(); 
           BasicDBList list = (BasicDBList)tobj.get("resource_id");
           System.out.println(list.size());

            for( Iterator< Object > it = list.iterator(); it.hasNext(); )
                {
                   BasicDBObject dbo = (BasicDBObject)it.next();
                   Resource resource = new Resource();
                   resource.makePojoFromBson( dbo );
                   resourceList.add(resource);
                }
           
           product.setR(resourceList);
           BasicDBObject attri= (BasicDBObject) tobj.get("Attributes");
           Attributes a=new Attributes();
           a.makePojoFromBson( attri );
           product.setObject_attributes(a);
           product.setLifetime((String) tobj.get("lifetime"));

   	   }
	} finally {
	   cursor.close();
	}
	return product;
}
}

