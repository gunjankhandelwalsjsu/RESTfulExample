package com.mykong.pojo;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class DatabaseWithAttributes {
	String object_id;
	String lifetime;
	Attributes object_attributes;
//	Resource r;
	ArrayList<Resource> resources ;
	
	public ArrayList<Resource> getResources() {
		return resources;
	}

	public Attributes getObject_attributes() {
		return object_attributes;
	}
	public void setObject_attributes(Attributes object_attributes) {
		
		this.object_attributes = object_attributes;
	}
	public String getObject_id() {
		return object_id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	
	
	public String getLifetime() {
		return lifetime;
	}
	public void setLifetime(String lifetime) {
		this.lifetime = lifetime;
	}
	public void setR(ArrayList<Resource> resourceList) {
		// TODO Auto-generated method stub
		this.resources=resourceList;
	}

	public void makePojoFromBson(BasicDBObject bson) {
		BasicDBObject b = bson;
		
	//	this.setObject_attributes(( String )b.get("Maximum Period"),( String ) b.get("Minimum Period"),( String ) b.get("Greater Than"),( String ) b.get("Less Than"),( String ) b.get("cancel"),( String ) b.get( "Step" ));
		
	}

	
	
	
}
