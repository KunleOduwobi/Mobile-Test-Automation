package functionalTests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ValidateTutorialSlides extends Helper {

	Elements elements = new Elements();

	private String HomeDir = System.getProperty("user.dir");

	@Parameters({ "app-session", "android-version", "TestMode" })
	@Test(groups = { "ValidateTutorialSlides.validateTutorialSlides" })
	public void validateTutorialSlides(Boolean appSession, String androidVersion, String TestMode)
			throws InterruptedException {

		// Configure Logger
		Logger logger = Logger
				.getLogger("ValidateTutorialSlides.validateTutorialSlides");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		logger.info("Test Mode: " + TestMode);


		// Validate Splash screen is displayed
		CustomWaitForElement(elements.getSplashScreenId(), 5);
		assertElement(elements.getSplashScreenId(), "Splash screen");
		logger.info("Splash screen validated");

		// Validate Tutorial Slides
		// 1st Slide
		CustomWaitForElement(elements.getSlideTitleId(), 10);
		assertEquals(GetTextId(elements.getSlideTitleId()),
				elements.getSlide1Title());
		logger.info("1st Slide Title validated: "
				+ GetTextId(elements.getSlideTitleId()));
		assertEquals(GetTextId(elements.getSlideMsgId()),
				elements.getSlide1Msg());
		logger.info("1st Slide message validated: "
				+ GetTextId(elements.getSlideMsgId()));

		// Click Next
		ClickId(elements.getNextBtnId());
		logger.info("Next button clicked");

		// 2nd Slide
		CustomWaitForElement(elements.getSlideTitleId(), 10);
		assertEquals(GetTextId(elements.getSlideTitleId()),
				elements.getSlide2Title());
		logger.info("2nd Slide Title validated: "
				+ GetTextId(elements.getSlideTitleId()));
		assertEquals(GetTextId(elements.getSlideMsgId()),
				elements.getSlide2Msg());
		logger.info("2nd Slide message validated: "
				+ GetTextId(elements.getSlideMsgId()));

		// Click Next
		ClickId(elements.getNextBtnId());
		logger.info("Next button clicked");

		// 3rd Slide
		CustomWaitForElement(elements.getSlideTitleId(), 10);
		assertEquals(GetTextId(elements.getSlideTitleId()),
				elements.getSlide3Title());
		logger.info("3rd Slide Title validated: "
				+ GetTextId(elements.getSlideTitleId()));
		assertEquals(GetTextId(elements.getSlideMsgId()),
				elements.getSlide3Msg());
		logger.info("3rd Slide message validated: "
				+ GetTextId(elements.getSlideMsgId()));

		// Validate Finish Button
		assertEquals(GetTextId(elements.getFinishBtnId()),
				elements.getFinishBtn());
		logger.info(GetTextId(elements.getFinishBtnId()) + " button found");

		// Click Finish
		ClickId(elements.getFinishBtnId());
		logger.info("Get Started button clicked");

	}
}