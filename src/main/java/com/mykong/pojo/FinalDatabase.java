package com.mykong.pojo;

import java.util.ArrayList;

public class FinalDatabase {
	public ArrayList<DatabaseWithAttributes> getAttributesOfItem() {
		return AttributesOfItem;
	}
	public void setAttributesOfItem(ArrayList<DatabaseWithAttributes> AttributesOfItem) {
		this.AttributesOfItem = AttributesOfItem;
	}
	ArrayList<DatabaseWithAttributes> AttributesOfItem ;

	String object_id;

	public String getObject_id() {
		return object_id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
}
