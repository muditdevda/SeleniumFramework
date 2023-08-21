package Utility;

import com.orange.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.qameta.allure.Step;
import io.qameta.allure.Attachment;
public class FlowNavigateToHelper extends BasePage {
	private static final Logger LOGGER = LoggerFactory.getLogger(FlowNavigateToHelper.class);

	// To prevent instantiation
	private FlowNavigateToHelper(){}


	@Step("Navigate to given URL")
	public static void navigateTo(String url) {
		LOGGER.info("Navigating to {}", url);
		getDriver().get(url);
		LOGGER.info(getDriver().toString());
		waitException(100);
	}
}
