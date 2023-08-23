package Utility;

import org.slf4j.LoggerFactory;

import com.pages.BasePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.selenium.PropertiesHelper;

import io.qameta.allure.Step;

public class Loginer extends BasePage {

	private static PropertiesHelper propertiesHelper = new PropertiesHelper();
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(Loginer.class);

	public  Loginer(){
		super();
	}
	
	@Step("login as pm")
	public static HomePage doLoginAsPM() {
		doGenericLogin(propertiesHelper.getPmUser(), propertiesHelper.getPmPass());
		HomePage homepage = new HomePage();
		return homepage;
	}
	
	private static void doGenericLogin(String username, String password) {
		logger.info("Login with credentials {},{}", username, password);
//		FlowNavigateToHelper.navigateTo(propertiesHelper.getURL());
		LoginPage loginPage = new LoginPage();
		loginPage.navigateToLogin();
		try {
			loginPage.waitForPageToLoad();
		}catch(org.openqa.selenium.TimeoutException toe){
			logger.info("unable to wait for the page retrying");
			loginPage.navigateToLogin();
			loginPage.waitForPageToLoad();
		}
		finally {
			loginPage.doLogin(username, password);
			loginPage.navigateToDashBoard();
		}
	}
}
