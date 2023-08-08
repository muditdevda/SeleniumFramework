package Utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
	
	public static Properties pobj = new Properties();
	public PropertiesHelper() {
		FileReader reader = null;
		try {
			reader = new FileReader("src/resources/config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties pobj = new Properties();
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
