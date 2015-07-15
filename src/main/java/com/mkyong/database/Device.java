package com.mkyong.database;

public class Device {
	String objectId;
	 public Device() {
	    	
	    }
	    
		public Device(String id,String name, String resourceId, String uri) {
			this.objectId = id;
			this.name = name;
			this.resourceId = resourceId;
			this.uri = uri;
		}

	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	String name;
	String resourceId;
	String uri;

}
