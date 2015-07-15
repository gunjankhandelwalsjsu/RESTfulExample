package com.mkyong.database;

import java.util.HashMap;
import java.util.Map;

import com.mkyong.database.Device;

public class Database {
	private static Map<String, Device> devices = new HashMap<String, Device>();
	static Device clientdevice = new Device();

	public static Map<String, Device> getDevices() {
		return devices;
	}
	public static  void setClientDevice(Device d) {
		clientdevice= d;
}
}
