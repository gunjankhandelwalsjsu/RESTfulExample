package com.mykong.pojo;

import java.util.ArrayList;

import com.mkyong.database.ResourceForClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class NewProduct {
	String object_id;
	String lifetime;
	String uri;
	
	ArrayList<ResourceForClient> resources ;
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public ArrayList<ResourceForClient> getResources() {
		return resources;
	}
	public void setResources(ArrayList<ResourceForClient> resourceList) {
		this.resources = resourceList;
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
	

}
