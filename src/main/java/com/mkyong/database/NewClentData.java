package com.mkyong.database;

import java.util.ArrayList;

import com.mykong.pojo.Resource;

public class NewClentData {

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
	public String getInstance_id() {
		return instance_id;
	}
	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}
	String instance_id;


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
	public void setR(ArrayList<ResourceForClient> resourceList) {
		// TODO Auto-generated method stub
		this.resources=resourceList;
	}

}

