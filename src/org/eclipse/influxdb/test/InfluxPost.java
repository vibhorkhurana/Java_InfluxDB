package org.eclipse.influxdb.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import javax.security.auth.login.Configuration;
import com.db.influxdb.Configuration;
import com.db.influxdb.DataWriter;

public class InfluxPost {

	//private int port;
	private String hostAddr, ports ,username, password, dbName, measurementName;
	private Map<String, String> tags; 
	private Map<String, Object> fields;
	
	public InfluxPost(String hostAddr, int port, String username, String password, String dbName,
			String measurementName, Map<String, String> tags, Map<String, Object> fields) {
		this.hostAddr = hostAddr;
		this.ports = String.valueOf(port);
		this.username = username;
		this.password = password;
		this.dbName = dbName;
		this.measurementName = measurementName;
		this.tags = tags;
		this.fields = fields;
	}
	
	

	void PostData(){
		DataWriter writer = connectDb();
		
		writer.setMeasurement(measurementName);
		writer.setTimeUnit(TimeUnit.SECONDS);
		writer.setTime(System.currentTimeMillis()/1000);
//		Map<String, String> tags = new HashMap<>();
//		tags.put("hha", "huhu");
		writer.setTags(tags);
//		Map<String, Object> fields = new HashMap<>();
		writer.setFields(fields);
//		writer.addField("field1", 1234);
//		writer.addField("field3", "Hello");
		

		try {
			writer.writeData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	/**
	 * @return
	 * This function will be used to Connect to the database and returns the writer object.
	 */
	public DataWriter connectDb() {
		Configuration configuration = new Configuration(hostAddr,ports,username,password,dbName);
		DataWriter writer = null;
		try {
			writer = new DataWriter(configuration);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer;
	}
	
	public static void main(String[] args) {
	//	InfluxPost ip = new InfluxPost();
		InfluxReader ir = new InfluxReader();
		
//		ip.PostData();
		ir.readPost();
	}

}
