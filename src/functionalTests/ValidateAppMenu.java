package functionalTests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ValidateAppMenu extends PhoneLoginParameterized {

	AppMenuPageObject appMenuPageObject = new AppMenuPageObject();

	private static String HomeDir = System.getProperty("user.dir");

	@Parameters({ "TestMode", "FirstName", "ClientId", "RefCode",
			"app-version", "country" })
	@Test(dependsOnGroups = { "PhoneLoginParameterized.phoneLoginParameterized" }, groups = { "ValidateAppMenu.validateAppMenu" })
	public void validateAppMenu(String TestMode, String FirstName,
			String ClientId, String RefCode, String AppVersion, String Country)
			throws InterruptedException {
		// TODO Auto-generated method stub

		// Configure Logger
		Logger logger = Logger.getLogger("ValidateAppMenu");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		// Click Menu Button
		try {
			ClickId(appMenuPageObject.getMenuBtnId());
			logger.info("App menu button clicked");
		} catch (Exception e) {
			logger.error("Unable to click app menu button");
		}

		// Validate Menu Options
		CustomWaitForElement(appMenuPageObject.getProfileId(), 15);

		assertElement(appMenuPageObject.getAvatarId(), "Profile Photo");

		assertEquals(GetTextId(appMenuPageObject.getFirstNameId()), FirstName);
		logger.info("First Name found: "
				+ GetTextId(appMenuPageObject.getFirstNameId()));

		assertEquals(GetTextId(appMenuPageObject.getClientIdId()), ClientId);
		logger.info("Client ID found: "
				+ GetTextId(appMenuPageObject.getClientIdId()));

		assertEquals(GetTextId(appMenuPageObject.getRefCodeId()), RefCode);
		logger.info("Referral Code found: "
				+ GetTextId(appMenuPageObject.getRefCodeId()));
		
		if(AppVersion.equals("Version 3.2.0")) {
			assertEquals(GetTextId(appMenuPageObject.getHomeId()),
					"Home");
			logger.info("Home menu found: "
					+ GetTextId(appMenuPageObject.getHomeId()));
		}

		assertEquals(GetTextId(appMenuPageObject.getYourLoansId()),
				"Your loans");
		logger.info("Loans menu found: "
				+ GetTextId(appMenuPageObject.getYourLoansId()));

		assertEquals(GetTextId(appMenuPageObject.getReferFriendId()),
				"Refer a friend");
		logger.info("Referral menu found: "
				+ GetTextId(appMenuPageObject.getReferFriendId()));

		assertEquals(GetTextId(appMenuPageObject.getNotificationsId()),
				"Notifications");
		logger.info("Notifications menu found: "
				+ GetTextId(appMenuPageObject.getNotificationsId()));
		
		try {
			ScrollDown(0.01);
			logger.info("App menu scrolled");
		}
		catch(Exception e) {
			logger.error("Unable to scroll App Menu");
		}

		// Nigeria
		if (Country.equals("Nigeria")) {
			assertEquals(GetTextId(appMenuPageObject.getManageCardsId()),
					"Manage cards");
			logger.info("Manage cards found: "
					+ GetTextId(appMenuPageObject.getManageCardsId()));
		}

		assertEquals(GetTextId(appMenuPageObject.getContactUsId()),
				"Contact us");
		logger.info("Contact menu found: "
				+ GetTextId(appMenuPageObject.getContactUsId()));

		assertEquals(GetTextId(appMenuPageObject.getLogOutId()), "Log Out");
		logger.info("Log Out menu found: "
				+ GetTextId(appMenuPageObject.getLogOutId()));

		assertEquals(GetTextId(appMenuPageObject.getAppVersionId()), AppVersion);
		logger.info("App Version found: "
				+ GetTextId(appMenuPageObject.getAppVersionId()));

	}

}
