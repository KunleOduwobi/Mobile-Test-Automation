package functionalTests;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactUs extends PhoneLoginParameterized {

	AppMenuPageObject appMenuPageObject = new AppMenuPageObject();
	ContactUsPageObject contactUsPageObject = new ContactUsPageObject();

	private static String HomeDir = System.getProperty("user.dir");
	private String ButtonName;

	@Parameters({ "TestMode", "app-version" })
	@Test(dependsOnGroups = { "PhoneLoginParameterized.phoneLoginParameterized" }, groups = { "ContactUs.contactUs" })
	public void contactUs(String TestMode, String AppVersion) throws InterruptedException {

		// Configure Logger
		Logger logger = Logger.getLogger("LoanStatus");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		logger.info("Test Mode: " + TestMode);

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

		// Select Contact option
		try {
			ButtonName = GetTextId(appMenuPageObject.getContactUsId());
			ClickId(appMenuPageObject.getContactUsId());
			logger.info(ButtonName + " option clicked");
		} catch (Exception e) {
			logger.error("Unable to click Contact Us option");
		}

		// Validate Contact Us Page
		Thread.sleep(3000);
		assertEquals(GetTextId(contactUsPageObject.getPageTitleId()), "Contact us");
		//
		// List<AndroidElement> icons = ElementsId(contactUsPageObject
		// .getIconsId());
		List<AndroidElement> contacts = ElementsId(contactUsPageObject.getContactsId());

		// Facebook
		assertEquals(contacts.get(0).getAttribute("text"), "Facebook");
		logger.info("Facebook contact validated: " + contacts.get(0).getAttribute("text"));

		// Twitter
		assertEquals(contacts.get(1).getAttribute("text"), "Twitter");
		logger.info("Twitter contact validated: " + contacts.get(1).getAttribute("text"));

		// Instagram
		assertEquals(contacts.get(2).getAttribute("text"), "Instagram");
		logger.info("Instagram contact validated: " + contacts.get(2).getAttribute("text"));

		// Medium Blog
		assertEquals(contacts.get(3).getAttribute("text"), "Medium Blog");
		logger.info("Medium Blog contact validated: " + contacts.get(3).getAttribute("text"));

		// Help
		assertEquals(contacts.get(4).getAttribute("text"), "Help");
		logger.info("Medium Blog contact validated: " + contacts.get(4).getAttribute("text"));

		// Chat with Us
		assertEquals(contacts.get(5).getAttribute("text"), "Chat with us");
		logger.info("Chat contact validated: " + contacts.get(5).getAttribute("text"));

	}

}
