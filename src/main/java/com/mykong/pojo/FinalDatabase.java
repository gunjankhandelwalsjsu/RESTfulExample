package com.mykong.pojo;

import java.util.ArrayList;

public class FinalDatabase {
	public ArrayList<DatabaseWithAttributes> getDwa() {
		return dwa;
	}
	public void setDwa(ArrayList<DatabaseWithAttributes> dwa) {
		this.dwa = dwa;
	}
	ArrayList<DatabaseWithAttributes> dwa ;

	String object_id;

	public String getObject_id() {
		return object_id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
}
