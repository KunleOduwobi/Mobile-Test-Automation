package functionalTests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UnlockApp extends PhoneLoginParameterized {
	UnlockAppPageObject unlockAppPageObject = new UnlockAppPageObject();
	Elements elements = new Elements();

	private static String HomeDir = System.getProperty("user.dir");

	@Parameters({ "app-session", "app-version", "PIN" })
	@Test(dependsOnGroups = { "PhoneLoginParameterized.phoneLoginParameterized" }, groups = { "UnlockApp.unlockApp" })
	public void unlockApp(Boolean appSession, String AppVersion, String PIN) throws InterruptedException {

		// Configure Logger
		Logger logger = Logger.getLogger("UnlockApp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		logger.info("Unlock app test");

		// Minimize App
		try {
			SendHomeKey();
			logger.info("App minimized");
		} catch (Exception e) {
			logger.error("Unable to minimize app");
		}

		Thread.sleep(1000);

		try {
			ClickPaylater();
			logger.info("App maximized");
		} catch (Exception e) {
			logger.error("Unable to maximize app");
		}

		// Verify Lock Screen is displayed
		try {
			CustomWaitForElement(unlockAppPageObject.getUnlockPageTitleId(), 10);
			if (AppVersion.equals("Version 3.2.0")) {
				assertEquals(GetTextId(unlockAppPageObject.getUnlockPageTitleId()), "Enter PIN");

				ScrollDown(0.01);
			} else {
				assertEquals(GetTextId(unlockAppPageObject.getUnlockPageTitleId()),
						unlockAppPageObject.getUnlockPageTitle());
			}
			logger.info("Unlock screen verified");
		} catch (Exception e) {
			logger.error("Unlock screen not verified");
		}

		// Enter PIN
		try {
			SendKeysId(unlockAppPageObject.getPinId(), PIN);
			logger.info("PIN entered");
		} catch (Exception e) {
			logger.error("Unable to enter PIN");
		}

		if (AppVersion.equals("Version 3.2.0")) {
			try {
				ClickId(unlockAppPageObject.getDoneBtnId());
				logger.info("Done button clicked");
			} catch (Exception e) {
				logger.error("Unable to click Done button");
			}
		}

		// Check if PIN is incorrect
		try {
			CustomWaitForElement(elements.getSignInFailedAlertId(), 5);
			if (isElementPresent(elements.getSignInFailedAlertId())) {
				logger.error("Sign in failed!: Invalid phone number or PIN");
			}
		} catch (Exception e) {
			logger.info("User credentials verified");
		}

		// Check if user is new with Welcome popup
		try {
			CustomWaitForElement(elements.getWelcomeBeginBtnId(), 3);
			ClickId(elements.getWelcomeBeginBtnId());
			logger.info("Begin button clicked. Verifying login status...");
		} catch (Exception e) {
			logger.info("Verifying login status...");
		}
		// Verify App Menu Button is found
		assertElement(elements.getMenuButtonId(), "Menu Button");
		logger.info("User login successful!");

	}
}
