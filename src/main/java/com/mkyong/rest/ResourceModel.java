package com.mkyong.rest;

public class ResourceModel {

	String name;
	String ObjectId;
	String resourceId;
	String uri;
	
	public String getObjectId() {
		return ObjectId;
	}

	public void setObjectId(String objectId) {
		ObjectId = objectId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public String toString() {


		return "Device [name=" + name + ", objectid=" + ObjectId + ",ResourceId " + resourceId +"uri=" + uri +"]";
	}

}