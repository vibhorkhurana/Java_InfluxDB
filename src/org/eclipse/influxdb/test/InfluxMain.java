package org.eclipse.influxdb.test;

import java.util.Map;
import java.util.Random;

public class InfluxMain {

	String hostAddr,username, password, dbName, measurementName;
	int port;
	Map<String, String> tags; 
	Map<String, Object> fields;
	private final Random m_random= new Random();
	
	void PostData(){
		hostAddr = "localhost";
		port = 8086;
		username="root";
		password="root";
		dbName="myNewTest";
		measurementName="newInfluxTest";
		tags.put("language", "java");
		tags.put("user", "vibhor");
		m_random.nextInt(10);
		fields.put("random1",m_random.nextInt(10));
		fields.put("random2",m_random.nextInt(20));
		
	}
	
	
}
