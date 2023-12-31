package com.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PropertiesHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesHelper.class);
	private Properties propertiesFile;
	Properties pobj = new Properties();
	public PropertiesHelper() {
		FileInputStream reader = null;
		
		try {
			reader = new FileInputStream("src\\resources\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pobj.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getBrowserName() {
		return pobj.getProperty("browser");
	}
	
	public String getWebDriver() {
		return pobj.getProperty("browser");
	}
	
	public String getURL() {
		String url = System.getProperty("url") != null ? System.getProperty("url") : pobj.getProperty("url");
		LOGGER.debug("Using url {}", url);
		return url;
	}
	
	public String logoutURL() {
		return pobj.getProperty("logout");
	}
	
	public String getPmUser() {
		return pobj.getProperty("username");
	}

	public String getPmPass() {
		return pobj.getProperty("password");
	}
	
	public Integer getWaitTimeout() {
		return Integer.parseInt(pobj.getProperty("waitTimeout"));
	}
}
