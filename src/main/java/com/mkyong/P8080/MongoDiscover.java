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
import com.mykong.pojo.Product;
import com.mykong.pojo.Resource;

public class MongoDiscover {
	 public ArrayList<Attributes> getdata(String product_id,MongoClient mongoClient) {
		    FinalDatabase product=new FinalDatabase();
			DB db = mongoClient.getDB( "client_db_attributes" );

        	BasicDBObject query = new BasicDBObject("object_id", product_id);
        	DBCollection coll = db.getCollection("device");
        	DBCursor cursor = coll.find(query);
	        ArrayList<DatabaseWithAttributes> d =new ArrayList<DatabaseWithAttributes>();
	        ArrayList<Attributes> a =new ArrayList<Attributes>();

        	try {
        		   while(cursor.hasNext()) {
        			   DBObject tobj = cursor.next();
        	           System.out.println(tobj);
        	           product.setObject_id((String) tobj.get("object_id"));
        	           
        	           ArrayList<DatabaseWithAttributes> instanceList = new ArrayList<DatabaseWithAttributes>(); 
        	           BasicDBList list1 = (BasicDBList)tobj.get("instance_id");
        	           for( Iterator< Object > it = list1.iterator(); it.hasNext(); )
        	           {
        	              BasicDBObject dbo = (BasicDBObject)it.next();
        	              DatabaseWithAttributes instance = new DatabaseWithAttributes();
        	              instance.makePojoFromBson( dbo );
        	              instanceList.add(instance);
        	           }   
           
        	           product.setDwa(instanceList);
        	          d=product.getDwa();
                      for(int i=0;i<d.size();i++){
                    	  a.add(d.get(i).getObject_attributes());
                      }
         
          
   	   }
	} finally {
	   cursor.close();
	}
	return a;
}
}

