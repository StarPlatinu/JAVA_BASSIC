package com.training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ReadFileProperties {
	public static Properties readFileProperties() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("resources/config/config.properties"));
			String user = properties.getProperty("remote.user");
			System.out.println("User: " + user);
			System.out.println("Password: " + properties.getProperty("remote.password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	public static void writeProperties() {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("resources/config/config.properties");

			// set the properties value
			prop.setProperty("remote.server", "192.168.1.100");
			prop.setProperty("remote.server.port", "8080");
			prop.setProperty("remote.user", "sa");
			prop.setProperty("remote.password", "sa");

			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	
	

	public static void main(String[] args) {
      readFileProperties();
    //  writeProperties();
      
	}
}
