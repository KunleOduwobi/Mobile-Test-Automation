package functionalTests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogOut extends PhoneLoginParameterized {
	AppMenuPageObject appMenuPageObject = new AppMenuPageObject();
	private static String HomeDir = System.getProperty("user.dir");

	@Parameters({ "app-session", "app-version" })
	@Test(dependsOnGroups = { "PhoneLoginParameterized.phoneLoginParameterized" }, groups = { "LogOut.logOut" })
	public void logout(Boolean appSession, String AppVersion) throws InterruptedException {

		// Configure Logger
		Logger logger = Logger.getLogger("LogOut");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		logger.info("Log out Test");

		// Click Menu Button
		try {
			ClickId(appMenuPageObject.getMenuBtnId());
			logger.info("App menu button clicked");
		} catch (Exception e) {
			logger.error("Unable to click app menu button");
		}

		if (AppVersion.equals("Version 3.2.0")) {
			// Scroll Menu Down
			try {
				Thread.sleep(3000);
				ScrollDown(0.01);
				logger.info("App menu scrolled");
			} catch (Exception e) {
				logger.error("Unable to scroll app menu");
			}
		}

		// Select Logut option
		try {
			ClickId(appMenuPageObject.getLogOutId());
			logger.info("Logout option clicked");
		} catch (Exception e) {
			logger.error("Unable to click logout option");
		}

		// Verify Logout
		waitForElement(elements.getLandingPageTitleId());
		assertEquals(GetTextId(elements.getLandingPageTitleId()), elements.getLandingPageTitle());
		logger.info("Logout successful!");
	}
}
