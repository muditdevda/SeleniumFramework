package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
	Properties pobj = new Properties();
	public PropertiesHelper() {
		FileInputStream reader = null;
		
		try {
			reader = new FileInputStream("D:\\NIkhlesh_Ruby\\SeleniumFramework\\src\\resources\\config.properties");
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
}
