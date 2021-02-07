package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	/*
	This class reads the configuration.properties file
	 */

	private  static Properties properties;

	static {
		try {
			String path = "configuration.properties";
			//open file
			FileInputStream fileInputStream = new FileInputStream(path);
			properties = new Properties();
			properties.load(fileInputStream);  // read file
			//close file
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key){
		return properties.getProperty(key);
	}

}
