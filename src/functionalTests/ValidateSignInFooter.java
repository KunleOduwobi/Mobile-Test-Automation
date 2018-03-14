package functionalTests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ValidateSignInFooter extends Helper {

	Elements elements = new Elements();

	private String HomeDir = System.getProperty("user.dir");

	@Parameters({ "app-session", "android-version", "TestMode", "app-version",
			"country" })
	@Test(groups = { "ValidateSignInFooter.validateSignInFooter" })
	public void validateTutorialSlides(Boolean appSession,
			String androidVersion, String TestMode, String AppVersion,
			String Country) throws InterruptedException {

		// Configure Logger
		Logger logger = Logger
				.getLogger("ValidateSignInFooter.validateSignInFooter");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		logger.info("Test Mode: " + TestMode);

		// Dismiss slides
		CustomWaitForElement(elements.getSkipSlidesId(), 15);
		try {
			ClickId(elements.getSkipSlidesId());
			logger.info("On-boarding slides skipped");
		} catch (Exception e) {
			logger.error("Unable to skip on-boarding slides");
		}

		// Accept Call Permission for Android version =/> 6
		if (Float.parseFloat(androidVersion) >= 6.0) {
			CustomWaitForElement(elements.getCallDialogId(), 10);
			try {
				ClickId(elements.getCallPermissionAllowId());
				logger.info("Call permission allowed");
			} catch (Exception e) {
				logger.error("Unable to allow call permission");
			}
		}

		// Select Login button
		waitForElement(elements.getLandingSignInBtnId());
		try {
			ClickId(elements.getLandingSignInBtnId());
			logger.info("Sign in button clicked");
		} catch (Exception e) {
			logger.error("Unable to click log in button");
		}

		// Validate Company Footer
		CustomWaitForElement(elements.getSignInCompanyNameId(), 10);
		// Ghana
		if (Country.equals("Ghana")) {
			assertEquals(GetTextId(elements.getSignInCompanyNameId()),
					elements.getGHCompanyName());
			logger.info("OneFi Login Footer found: "
					+ GetTextId(elements.getSignInCompanyNameId()));
		}
		// Nigeria
		else {
			assertEquals(GetTextId(elements.getSignInCompanyNameId()),
					elements.getNGCompanyName());
			logger.info("OneFi Login Footer found: "
					+ GetTextId(elements.getSignInCompanyNameId()));
		}

		// Validate App version
		assertEquals(GetTextId(elements.getSignInAppVersionId()), AppVersion);
		logger.info("App version found: "
				+ GetTextId(elements.getSignInAppVersionId()));
	}
}