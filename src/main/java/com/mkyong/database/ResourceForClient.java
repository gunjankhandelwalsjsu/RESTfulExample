package com.mkyong.database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mykong.pojo.Attributes;

public class ResourceForClient {
	String Rid;
	String name;
	public String getRid() {
		return Rid;
	}
	public void setRid(String rid) {
		Rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void makePojoFromBson(BasicDBObject bson) {
		// TODO Auto-generated method stub
		BasicDBObject b = bson;
		this.setRid(( String ) b.get("Rid"));	
    	this.setName(( String ) b.get("Name"));
		
	}
	public DBObject bsonFromPojo(){
		
		BasicDBObject document = new BasicDBObject();		
		document.put( "Rid",    this.Rid );
		document.put( "Name ",   this.name );	
		return document;
		
		}
}


