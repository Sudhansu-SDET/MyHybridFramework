package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop ; 
	
	public ConfigDataProvider() throws Exception {
		
		File src = new File("./Config/Config.properties");
		FileInputStream fis = new FileInputStream(src);
		
		prop = new Properties() ;
		prop.load(fis);
		
	}
	


	public String getDataFromConfig(String propKeyName) {
		return prop.getProperty(propKeyName);
	}
}

