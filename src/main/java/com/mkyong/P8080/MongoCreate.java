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
	public class MongoCreate {
		 public void updatedata(String instance_id,String product_id,MongoClient mongoClient) {
				DB db = mongoClient.getDB( "client_db_attributes" );
				DBCollection table = db.getCollection("device");
		
		      
/*********Change attributes at instance level
 *******/
		    /* table.update(new BasicDBObject().append("object_id", "3333").append("instance_id.instance_id", "0").append("instance_id.Attributes.Step", "12"),
		                  new BasicDBObject("$set", new BasicDBObject("instance_id.$.Attributes.Step", "5")));
		     
		*/
	//update MinimumPeriod to 5  at resource level    
				BasicDBObject query = new BasicDBObject();
				query.put( "object_id", "3333");

				BasicDBObject obj = new BasicDBObject();
				obj.put("instance_id", instance_id);
			//	tenant.put("Tenant_Info", "check");
			//	tenant.put("Prop_Info", "client");

				BasicDBObject update = new BasicDBObject();
				update.put("$push", new BasicDBObject("instance_id", obj));

				table.update(query, update,true,true);
   //  table.update(new BasicDBObject().append("object_id", "3333"),
    //        new BasicDBObject("$push", new BasicDBObject("instance_id", instance_id)));

	}
	


}
