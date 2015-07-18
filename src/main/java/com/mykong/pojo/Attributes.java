package com.mykong.pojo;

import com.mongodb.BasicDBObject;

public class Attributes {
	String MaximumPeriod;
	String MinimumPeriod;
    String GreaterThan;
    String LessThan;
    String Step;
    String Cancel;
    public String getMaximumPeriod() {
		return MaximumPeriod;
	}
	public void setMaximumPeriod(String maximumPeriod) {
		this.MaximumPeriod = maximumPeriod;
	}
	public String getMinimumPeriod() {
		return MinimumPeriod;
	}
	public void setMinimumPeriod(String minimumPeriod) {
		this.MinimumPeriod = minimumPeriod;
	}
	public String getGreaterThan() {
		return GreaterThan;
	}
	public void setGreaterThan(String greaterThan) {
		this.GreaterThan = greaterThan;
	}
	public String getLessThan() {
		return LessThan;
	}
	public void setLessThan(String lessThan) {
		this.LessThan = lessThan;
	}
	public String getStep() {
		return Step;
	}
	public void setStep(String step) {
		this.Step = step;
	}
	public String getCancel() {
		return Cancel;
	}
	public void setCancel(String cancel) {
		this.Cancel = cancel;
	}
	public void makePojoFromBson(BasicDBObject attri) {
		BasicDBObject b = attri;
		this.setMaximumPeriod(( String ) b.get("Maximum Period"));	
    	this.setMinimumPeriod(( String ) b.get("Minimum Period"));		
    	this.setGreaterThan(( String ) b.get("Greater Than"));	
    	this.setLessThan(( String ) b.get("Less Than"));		
    	this.setStep(( String ) b.get("Step"));	
    	this.setCancel(( String ) b.get("cancel"));		
	}
	
}
