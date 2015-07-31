package com.mykong.pojo;

import java.util.ArrayList;
import java.util.Iterator;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class DatabaseWithAttributes {
	String lifetime;
	Attributes object_attributes;
//	Resource r;
	ArrayList<Resource> resources ;
	public String getInstance_id() {
		return instance_id;
	}
	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}
	String instance_id;
	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}

	public ArrayList<Resource> getResources() {
		return resources;
	}

	public Attributes getObject_attributes() {
		return object_attributes;
	}
	public void setObject_attributes(Attributes object_attributes) {
		
		this.object_attributes = object_attributes;
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
		// TODO Auto-generated method stub
		BasicDBObject b = bson;
		this.setLifetime(( String ) b.get("Resource_id"));	
    	this.setInstance_id(( String ) b.get("Name"));
    	ArrayList<Resource> resourceList = new ArrayList<Resource>(); 
        BasicDBList list = (BasicDBList)bson.get("resources");

         for( Iterator< Object > it = list.iterator(); it.hasNext(); )
             {
                BasicDBObject dbo = (BasicDBObject)it.next();
                Resource resource = new Resource();
                resource.makePojoFromBson( dbo );
                resourceList.add(resource);
             }
         this.resources=resourceList;
         BasicDBObject attri= (BasicDBObject) bson.get("Attributes");
         Attributes a=new Attributes();
         a.makePojoFromBson( attri );
         this.object_attributes=a;
         this.setLifetime((String) bson.get("lifetime"));

         
	}

	

	
	
	
}
