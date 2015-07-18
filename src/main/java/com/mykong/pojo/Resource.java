package com.mykong.pojo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Resource {
	String Rid;
	String name;
	Attributes resAttribute;
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
	public Attributes getResAttribute() {
		return resAttribute;
	}
	public void setResAttribute(String maximumPeriod,String minimumPeriod, String greaterThan,String lessThan, String cancel,String step) {
		Attributes resAttribute = new Attributes();

		resAttribute.setMaximumPeriod(maximumPeriod);
		resAttribute.setLessThan(lessThan) ;
		resAttribute.setCancel(cancel);
		resAttribute.setStep(step);
		resAttribute.setGreaterThan(greaterThan);
		resAttribute.setMinimumPeriod(minimumPeriod);
		this.resAttribute=resAttribute;
	}
	
	public void makePojoFromBson(BasicDBObject bson) {
		BasicDBObject b = bson;
		this.setRid(( String ) b.get("Rid"));	
    	this.setName(( String ) b.get("Name"));
		this.setResAttribute(( String )b.get("Maximum Period"),( String ) b.get("Minimum Period"),( String ) b.get("Greater Than"),( String ) b.get("Less Than"),( String ) b.get("cancel"),( String ) b.get( "Step" ));
		
	}

}
