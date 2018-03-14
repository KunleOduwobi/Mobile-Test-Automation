package functionalTests;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class PhoneLoginDataDriven extends Helper {

	Elements elements = new Elements();
	private Boolean valid = false;

	static String HomeDir = System.getProperty("user.dir");

	// Helper helper = new Helper();

	// @Parameters("app-session")
	@Test(groups = { "PhoneLogin.phoneLogin" }, dataProvider = "LoginCredentials", dataProviderClass = DataProviders.class)
	public void login(String Test, String PhoneNumber, String PIN)
			throws InterruptedException {

		// Configure Logger
		Logger logger = Logger.getLogger("PhoneLoginDataDriven.phoneLoginDataDriven");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		

		// Log Data row
		try{
		logger.info("Test Mode: "+ Test + " Phone: " + PhoneNumber + " PIN: " + PIN);
		} catch(Exception e){
			logger.error("Unable to fetch data provider details");
		}
		

		// Dismiss slides
		waitForElement(elements.getSkipSlidesId());
		try {
			ClickId(elements.getSkipSlidesId());
			logger.info("On-boarding slides skipped");
		} catch (Exception e) {
			logger.error("Unable to skip on-boarding slides");
		}

		// Accept Call Permission
		CustomWaitForElement(elements.getCallDialogId(), 10);
		try {
			ClickId(elements.getCallPermissionAllowId());
			logger.info("Call permission allowed");
		} catch (Exception e) {
			logger.error("Unable to allow call permission");
		}
		Thread.sleep(5000);

		// Select Login button
		waitForElement(elements.getLandingSignInBtnId());
		try {
			ClickId(elements.getLandingSignInBtnId());
			logger.info("Sign in button clicked");
		} catch (Exception e) {
			logger.error("Unable to click log in button");
		}

		// Thread.sleep(2000L);

		// Find Phone Number input field
		waitForElement(elements.getPhoneNumberLoginId());
		try {
			// Thread.sleep(4000);
			String text = GetTextId(elements.getPhoneNumberLoginId());
			logger.info(text + "Phone number field found");
		}

		catch (Exception e) {
			logger.error("Phone number input field not found");
		}

		// Enter Phone Number
		try {
			// if (GetStringLengthId(elements.getPhoneNumberLoginId()) < 1)
			// {
			// ClearText(elements.getPhoneNumberLoginId());
			SendKeysId(elements.getPhoneNumberLoginId(), PhoneNumber + "\n");
			// getDriver().hideKeyboard();
			logger.info("Phone number " + PhoneNumber + " entered");
			// } else {
			// logger.info("Phone number is: "
			// + GetTextId(elements.getPhoneNumberLoginId()));
			// }
		} catch (Exception e) {
			logger.error("No phone number found");
		}
		
		valid = false; // reset phone validity status

		// Validate phone number
		while (valid == false) {
			valid = isPhoneCorrect(PhoneNumber);
			if (!valid) {
				logger.warn("Phone number incorrect");
				// Enter Phone
				try {
					ClearText(elements.getPhoneNumberLoginId());
					SendKeysId(elements.getPhoneNumberLoginId(),
							PhoneNumber);
					logger.info("Phone number re-entered: "
							+ PhoneNumber);

				} catch (Exception e) {
					logger.error("Unable to re-enter phonenumber");
				}
				// Hide Keyboard
				try {
					getDriver().hideKeyboard();
					logger.info("Keyboard closed");
				} catch (Exception e) {
					logger.info("Keyboard already hidden");
				}
			} else {
				logger.info("Phone number validated");
			}
		}


		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard aleady hidden");
		}

		// Enter PIN
		try {
			// if (GetStringLengthId(elements.getPINLoginId()) < 1) {
			// ClearText(elements.getPINLoginId());
			SendKeysId(elements.getPINLoginId(), PIN + "\n");
			// getDriver().hideKeyboard();
			logger.info("PIN entered");
			// } else {
			// logger.info("PIN is: "
			// + GetTextId(elements.getPhoneNumberLoginId()));
			// }
		} catch (Exception e) {
			logger.error("No PIN found");
		}

		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard aleady hidden");
		}

		// Click Sign In Button
		try {
			ClickId(elements.getSignInBtnId());
			logger.info("Sign In button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Sign in button");
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

		// Check if Device needs to be unlinked
		try {
			CustomWaitForElement(elements.getUnlinkTitleId(), 5);
			ClickId(elements.getUnlinkDeviceBtnId());
			logger.info("Attempting to Unlink device");
			// Click sign in button again
//			try {
//				CustomWaitForElement(elements.getSignInBtnId(), 15);
//				ClickId(elements.getSignInBtnId());
//				logger.info("Sign in button clicked");
//			} catch (Exception e) {
//				logger.error("Unable to click Sign In button");
//			}

		} catch (Exception e) {
			logger.info("Unlinking device skipped");
		}

		// Verify Permissions
		CustomWaitForElement(elements.getContinuePermissionsId(), 10);
		List<AndroidElement> PermissionPageElements = ElementsClass(elements
				.getGrantAccessClass());
		assertEquals(PermissionPageElements.get(0).getAttribute("text"),
				elements.getGrantAccess());

		// Continue to Permissions
		try {
			ClickId(elements.getContinuePermissionsId());
			logger.info("Continue to Permissions button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Continue to Permissions button");
		}

		// Accept SMS Permission
		try {
			ClickId(elements.getPermissionsAllowId());
			logger.info("SMS permission allowed");
		} catch (Exception e) {
			logger.error("Unable to accept SMS permission");
		}

		// Accept Contact Permission
		try {
			ClickId(elements.getPermissionsAllowId());
			logger.info("Contacts permission allowed");
		} catch (Exception e) {
			logger.error("Unable to accept contacts permission");
		}

		// Accept Location Permission
		try {
			ClickId(elements.getPermissionsAllowId());
			logger.info("Location permission allowed");
		} catch (Exception e) {
			logger.error("Unable to accept location permission");
		}

		// Accept Calender Permission
		try {
			ClickId(elements.getPermissionsAllowId());
			logger.info("Calender permission allowed");
		} catch (Exception e) {
			logger.error("Unable to accept calender permission");
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
	
	private boolean isPhoneCorrect(String PhoneNumber) {
		return GetTextId(elements.getPhoneNumberLoginId()).replaceAll(
				"\\s", "").equals(PhoneNumber);
	}

}
