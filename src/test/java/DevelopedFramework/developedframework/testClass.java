package DevelopedFramework.developedframework;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.DriverManager;
import Utility.PropertiesHelper;

public class testClass {
	
	@BeforeTest
	public void setup() {
		System.out.println("print");
		DriverManager.getChromeDriver();
	}

	@Test
	public void firstTest() {
		
	}
	

}
