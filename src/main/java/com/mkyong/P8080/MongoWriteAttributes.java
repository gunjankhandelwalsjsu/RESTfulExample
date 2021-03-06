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
	import com.mykong.pojo.Product;
	import com.mykong.pojo.Resource;
	//changing a particular resource_id(from 0 to 4)
	public class MongoWriteAttributes {
		 public void updatedata(String device,String resource_id,String product_id, MongoClient mongoClient) {
				DB db = mongoClient.getDB( "client_db_attributes" );
				DBCollection table = db.getCollection(device);
		/*		BasicDBObject newDocument = new BasicDBObject();		
				newDocument.append("$set", new BasicDBObject().append("resource_id.Rid", "5").append("resource_id.Name", "Maximum Voltage"));
				BasicDBObject searchQuery = new BasicDBObject().append("resource_id.Rid", resource_id).append("object_id", product_id);		 
				table.update(searchQuery, newDocument);
		*/
		        DBObject query = new BasicDBObject("resource_id.Rid",resource_id);

		        BasicDBObject listItem = new BasicDBObject();
		   //   listItem.append("$set", new BasicDBObject().append("resource_id.Rid", "5"));
		     listItem.put("Rid", "5");
		     listItem.put("Name", "Maximum Voltage");
		        BasicDBObject update = new BasicDBObject("$set",
		        	    new BasicDBObject("resource_id", listItem));

		       DBObject updateObj = new BasicDBObject("resource_id.Rid", listItem);
	       //      table.update(query,updateObj);
		     //   table.update(query, update);
		   /*    
		       BasicDBObject query = new BasicDBObject("_id", id);
		       query.append( new BasicDBObject("stats.employee", "rob") );

		       BasicDBObject update = new BasicDBObject("$set",
		           new BasicDBObject("stats.$.stat2", value));*/
/*********Change attributes at instance level
 *******/
		    /* table.update(new BasicDBObject().append("object_id", "3333").append("instance_id.instance_id", "0").append("instance_id.Attributes.Step", "12"),
		                  new BasicDBObject("$set", new BasicDBObject("instance_id.$.Attributes.Step", "5")));
		     
		*/
	//update MinimumPeriod to 5  at resource level    
	     
     table.update(new BasicDBObject().append("object_id", "3333").append("instances.instance_id", "0").append("instance_id.resource.Resource_id", resource_id),
            new BasicDBObject("$set", new BasicDBObject("instance_id.$.resource.0.Minimum Period", "5")));
     

	}
	


}
