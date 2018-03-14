package functionalTests;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUp extends Helper {

	Elements elements = new Elements();
	SignUpPageObject signUpPageObject = new SignUpPageObject();
	ForgotPinPageObject forgotPinPageObject = new ForgotPinPageObject();

	private String HomeDir = System.getProperty("user.dir");
	private String LoggerText = "";
	private String ExpectedDoB = "";
	private Boolean LoggedIn = false;
	private Boolean valid = false;
	private String DateOfBirth = "";
	private String DateOfBirth2 = "";

	@Parameters({ "app-session", "deviceId", "TestMode", "android-version", "First-Name", "Surname", "Email", "DOB-Day",
			"DOB-Month", "DOB-Year", "PIN", "Phone-Number", "app-version" })
	@Test(groups = { "SignUp.signUp" })
	public void signup(Boolean appSession, String DeviceId, String TestMode, String androidVersion, String FirstName,
			String Surname, String Email, String DOBDay, String DOBMonth, String DOBYear, String PIN,
			String PhoneNumber, String AppVersion) throws InterruptedException {

		// Configure Logger
		Logger logger = Logger.getLogger("SignUp.signUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		logger.info("Test Mode: " + TestMode);
		// Fresh app start
		if (!appSession) {

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
		} else {
			// Hide Keyboard
			try {
				getDriver().hideKeyboard();
				logger.info("Keyboard closed");
			} catch (Exception e) {
				logger.info("Keyboard already hidden");
			}
			// Switch User
			waitForElement(elements.getSwitchUserId());
			try {
				LoggerText = GetTextId((elements.getSwitchUserId()));
				ClickId(elements.getSwitchUserId());
				logger.info(LoggerText + " button clicked");
			} catch (Exception e) {
				logger.error("Unable to click Switch User button");
			}
		}

		// Select Register button
		waitForElement(elements.getLandingSignInBtnId());
		try {
			LoggerText = GetTextId((elements.getLangingRegisterBtnId()));
			ClickId(elements.getLangingRegisterBtnId());
			logger.info(LoggerText + " button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Register button");
		}

		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard already hidden");
		}

		// Verify firstname field
		assertEquals(GetTextId(signUpPageObject.getFirstnameId()), "FIRST NAME");

		// Enter firstname
		// if (AppVersion.equals("Version 3.2.0")) {
		// ClickId(signUpPageObject.getFirstnameId());
		// }
		try {
			SendKeysId(signUpPageObject.getEnterFirstnameId(), FirstName);
			logger.info("Firstname entered: " + GetTextId(signUpPageObject.getEnterFirstnameId()));
		} catch (Exception e) {
			logger.error("Unable to enter firstname");
		}
		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard already hidden");
		}

		// Enter surname
		try {
			SendKeysId(signUpPageObject.getSurnameId(), Surname);
			logger.info("Surname entered: " + GetTextId(signUpPageObject.getSurnameId()));
		} catch (Exception e) {
			logger.error("Unable to enter surname");
		}
		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard already hidden");
		}

		// Dismiss Suggestion on Tecno L8
		if (DeviceId.equals("01H805X680102293")) {
			// Click firstname field
			try {
				ClickId(signUpPageObject.getFirstnameId());
				logger.info("Firstname field clicked");
			} catch (Exception e) {
				logger.error("Unable to click firstname field");
			}
			// Hide Keyboard
			try {
				getDriver().hideKeyboard();
				logger.info("Keyboard closed");
			} catch (Exception e) {
				logger.info("Keyboard already hidden");
			}
		}

		// Click Submit button
		try {
			LoggerText = GetTextId(signUpPageObject.getNextBtnId());
			ClickId(signUpPageObject.getNextBtnId());
			logger.info(LoggerText + " button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Next button");
		}

		// Enter email
		CustomWaitForElement(signUpPageObject.getEmailId(), 5);
		try {
			SendKeysId(signUpPageObject.getEmailId(), Email);
			logger.info("Email entered: " + GetTextId(signUpPageObject.getEmailId()));
		} catch (Exception e) {
			logger.error("Unable to enter email");
		}
		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard already hidden");
		}

		// Click Submit button
		try {
			LoggerText = GetTextId(signUpPageObject.getNextBtnId());
			ClickId(signUpPageObject.getNextBtnId());
			logger.info(LoggerText + " button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Next button");
		}

		// Display Calendar
		try {
			ClickId(signUpPageObject.getDoBId());
			logger.info("Calendar displayed");
		} catch (Exception f) {
			logger.error("Unable to display calendar");
		}

		// Select Date of Birth
		try {
			logger.info(selectDate(signUpPageObject.getDobClass(), DOBDay, DOBMonth, DOBYear));
		} catch (Exception e) {
			logger.error("Unable to select Date of Birth");
		}

		// Submit Calendar
		try {
			ClickId(signUpPageObject.getCalenderSubmitBtnId());
			logger.info("Calendar submitted");
		} catch (Exception f) {
			logger.error("Unable to submit calendar");
		}

		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard already hidden");
		}

		Thread.sleep(5000);

		// Click Submit button
		try {
			LoggerText = GetTextId(signUpPageObject.getNextBtnId());
			ClickId(signUpPageObject.getNextBtnId());
			logger.info(LoggerText + " button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Next button");
		}
		Thread.sleep(5000);

		// Enter Phone
		try {
			CustomWaitForElement(signUpPageObject.getPhonenumberId(), 5);
			SendKeysId(signUpPageObject.getPhonenumberId(), PhoneNumber);
			logger.info("Phone number entered: " + GetTextId(signUpPageObject.getPhonenumberId()));

		} catch (Exception e) {
			logger.error("Unable to enter phonenumber");
		}
		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard already hidden");
		}

		// Validate phone number
		try {
			logger.info(validatePhonenumber(PhoneNumber, signUpPageObject.getPhonenumberId()));
		} catch (Exception e) {
			logger.error("Unable to validate phone number");
		}

		// Click Submit button
		try {
			LoggerText = GetTextId(signUpPageObject.getNextBtnId());
			ClickId(signUpPageObject.getNextBtnId());
			logger.info(LoggerText + " button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Next button");

		}

		// Accept Terms & Conditions
		CustomWaitForElement(signUpPageObject.getTnCTitleId(), 5);
		assertEquals(GetTextId(signUpPageObject.getTnCTitleId()), signUpPageObject.getTnCTitle());
		try {
			LoggerText = GetTextId(signUpPageObject.getTnCAgreeId());
			ClickId(signUpPageObject.getTnCAgreeId());
			logger.info("Terms & Conditions selected button: " + LoggerText);
		} catch (Exception e) {
			logger.error("Unable to agree terms & conditions");
		}

		// Check if Phone number exists
		if (TestMode.contains("Existing Phone Number")) {
			CustomWaitForElement(signUpPageObject.getAccountExistsTitleId(), 10);
			logger.warn("Sign up halted!");
			if (GetTextId(signUpPageObject.getAccountExistsTitleId())
					.equals(signUpPageObject.getAccountExistsTitle())) {
				logger.warn(GetTextId(signUpPageObject.getAccountExistsTitleId()));

				// login with existing phone number
				LoginExistinguser(PhoneNumber, PIN);

			}

		}

		// Create PIN
		if (!LoggedIn) {
			try {
				if (AppVersion.equals("Version 3.2.0")) {
					CustomWaitForElement(signUpPageObject.getCreatePinTitleId2(), 5);
					SendKeysId(signUpPageObject.getCreatePinId(), PIN);
					logger.info("PIN entered: " + PIN);

					// List<AndroidElement> PINBoxes = ElementsClass(elements.getPINLoginClass());
					// PINBoxes.get(1).sendKeys(PIN);
				} else {
					CustomWaitForElement(signUpPageObject.getCreatePinTitleId(), 5);
					SendKeysId(signUpPageObject.getCreatePinId(), PIN);
					logger.info("PIN entered: " + PIN);

				}
			} catch (Exception e) {
				logger.error("Unable to enter PIN");
			}

			// Confirm PIN
			try {
				if (AppVersion.equals("Version 3.2.0")) {
					Thread.sleep(3000);
					CustomWaitForElement(signUpPageObject.getCreatePinTitleId2(), 5);
					SendKeysId(signUpPageObject.getCreatedPinId2(), PIN);

					// List<AndroidElement> PINBoxes = ElementsClass(elements.getPINLoginClass());
					// PINBoxes.get(1).sendKeys(PIN);
				} else {
					CustomWaitForElement(signUpPageObject.getConfirmPINTextId(), 5);
					SendKeysId(signUpPageObject.getCreatePinId(), PIN);
				}
				logger.info("PIN re-entered: " + PIN);
			} catch (Exception e) {
				logger.error("Unable to confirm PIN");
			}

			// Verify PIN Success
			try {
				CustomWaitForElement(signUpPageObject.getPINSuccessTitleId(), 10);
				assertEquals(GetTextId(signUpPageObject.getPINSuccessTitleId()), signUpPageObject.getPINSuccessText());
				logger.info("PIN created successfully");
			} catch (Exception e) {
				logger.error("PIN not created");
			}
		}

		// Check if Email exists
		if (TestMode.contains("Existing Email")) {
			CustomWaitForElement(signUpPageObject.getAccountExistsTitleId(), 10);
			logger.warn("Sign up halted!");
			if (GetTextId(signUpPageObject.getAccountExistsMsgId()).equals(signUpPageObject.getAccountExistsMsg())) {
				logger.warn(GetTextId(signUpPageObject.getAccountExistsMsgId()));

				return;

			}

		}

		// Check if Device is linked to another user
		try {
			CustomWaitForElement(signUpPageObject.getUnlinkTitleId(), 5);
			if (GetTextId(signUpPageObject.getUnlinkTextId()).equals(signUpPageObject.getUnlinkText())
					|| GetTextId(signUpPageObject.getUnlinkTextId()).equals(signUpPageObject.getUnlinkText2())) {
				logger.warn(GetTextId(signUpPageObject.getUnlinkTextId()));
				// Unlink device
				if (!AppVersion.equals("Version 3.0.2")) {
					UnlinkDeviceNewUser();
				} else {
					UnlinkDeviceNewUserV302();
				}
			}
		} catch (Exception e) {
			logger.info("Unlink device not required");
		}

		// Check if Profile already exists
		if (TestMode.contains("Existing Profile")) {

			CustomWaitForElement(signUpPageObject.getProfileExistsId(), 10);
			assertEquals(GetTextId(signUpPageObject.getProfileExistsId()), signUpPageObject.getProfileExists());
			assertEquals(GetTextId("android:id/message"),
					"It appears you already have an account with One Finance using 0899****025. Please reset your PIN to continue.");
			logger.warn(GetTextId("android:id/message"));

			// Click Reset PIN Button
			try {
				ClickId("android:id/button3");
				logger.info("Reset PIN button clicked");
			} catch (Exception e) {
				logger.error("Unable to click Reset PIN button");
			}

			// Verify Forgot PIN Page
			try {
				CustomWaitForElement(forgotPinPageObject.getPageTitleId(), 10);
				assertElement(forgotPinPageObject.getPageTitleId(), "Forgot PIN page title");
			} catch (Exception e) {
				logger.warn("Forgot PIN page not verified");
			}
			return;

		}
		if (!LoggedIn) {
			// Wait for Phone number verification
			try {
				CustomWaitForElement(signUpPageObject.getVerifyTextId(), 15);
				assertEquals(GetTextId(signUpPageObject.getVerifyTextId()),
						"Enter 6 digit verification code sent to " + PhoneNumber + ". Change number?");
				logger.info("Awaiting OTP..");
			} catch (Exception e) {
				logger.error("Unable to receive OTP");
			}

			// Check if Phone was verified
			try {
				CustomWaitForElement(signUpPageObject.getVerifySuccessTitleId(), 60);
				assertEquals(GetTextId(signUpPageObject.getVerifySuccessTitleId()),
						signUpPageObject.getVerifySuccessText());
				logger.info("Phone number verified");
			} catch (Exception e) {
				logger.error("Phone number not verified");
			}
		}

		// Verify User Login
		try {
			CustomWaitForElement(elements.getWelcomeBeginBtnId(), 5);
			ClickId(elements.getWelcomeBeginBtnId());
			logger.info("Begin button clicked. Verifying login status...");
		} catch (Exception e) {
			// Android versions >= 6.0
			try {
				CustomWaitForElement(elements.getContinuePermissionsId(), 5);
				logger.info("Permissions page found. Login successful");
				return;
			} catch (Exception f) {
				logger.warn("New user not logged in automatically");
			}
		}
		// Verify App Menu Button is found
		assertElement(elements.getMenuButtonId(), "Menu Button");
		logger.info("User login successful!");
	}

	public void UnlinkDeviceNewUser() {
		// Configure Logger
		Logger logger = Logger.getLogger("SignUp.signUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		try {
			// CustomWaitForElement(elements.getUnlinkTitleId(), 5);
			ClickId(elements.getUnlinkDeviceBtnId());
			logger.info("Attempting to Unlink device");

		} catch (Exception e) {
			logger.info("Unlinking device skipped");
		}

	}

	public void UnlinkDeviceNewUserV302() {
		// Configure Logger
		Logger logger = Logger.getLogger("SignUp.signUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		try {
			// CustomWaitForElement(elements.getUnlinkTitleId(), 5);
			ClickId(elements.getUnlinkDeviceBtnId());
			logger.info("Attempting to Unlink device");

		} catch (Exception e) {
			logger.info("Unlinking device skipped");
		}

		// Click Submit button again
		try {
			LoggerText = GetTextId(signUpPageObject.getNextBtnId());
			ClickId(signUpPageObject.getNextBtnId());
			logger.info(LoggerText + " button clicked");
		} catch (Exception e) {
			logger.error("Unable to click FINISH button, device unlinking might have failed");

		}

		// Accept Terms & Conditions
		CustomWaitForElement(signUpPageObject.getTnCTitleId(), 5);
		assertEquals(GetTextId(signUpPageObject.getTnCTitleId()), signUpPageObject.getTnCTitle());
		try {
			LoggerText = GetTextId(signUpPageObject.getTnCAgreeId());
			ClickId(signUpPageObject.getTnCAgreeId());
			logger.info("Terms & Conditions selected button: " + LoggerText);
		} catch (Exception e) {
			logger.error("Unable to agree terms & conditions");
		}

		// Create PIN
		if (!LoggedIn) {
			try {
				CustomWaitForElement(signUpPageObject.getCreatePinTitleId(), 5);
				SendKeysId(signUpPageObject.getCreatePinId(), signUpPageObject.getPIN());
				logger.info("PIN entered: " + signUpPageObject.getPIN());
			} catch (Exception e) {
				logger.error("Unable to enter PIN");
			}

			// Confirm PIN
			try {
				CustomWaitForElement(signUpPageObject.getConfirmPINTextId(), 5);
				SendKeysId(signUpPageObject.getCreatePinId(), signUpPageObject.getPIN());
				logger.info("PIN re-entered: " + signUpPageObject.getPIN());
			} catch (Exception e) {
				logger.error("Unable to confirm PIN");
			}
		}

	}

	public void LoginExistinguser(String PhoneNumber, String PIN) {

		// Configure Logger
		Logger logger = Logger.getLogger("SignUp.signUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		// Click Login Button
		try {
			LoggerText = GetTextId(signUpPageObject.getAccountExistsSignInId());
			ClickId(signUpPageObject.getAccountExistsSignInId());
			logger.info(LoggerText + " button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Sign In button");
		}
		// Verify Login Phonenumber
		CustomWaitForElement(elements.getPhoneNumberLoginId(), 5);
		assertEquals(GetTextId(elements.getPhoneNumberLoginId()).replaceAll("\\s", ""), // remove whitespaces
				PhoneNumber);
		logger.info("Login Phonenumber confirmed: " + GetTextId(elements.getPhoneNumberLoginId()));

		// Enter PIN
		try {

			SendKeysId(elements.getPINLoginId(), PIN + "\n");
			logger.info("PIN entered");

		} catch (Exception e) {
			logger.error("No PIN found");
		}

		// Hide Keyboard
		try {
			getDriver().hideKeyboard();
			logger.info("Keyboard closed");
		} catch (Exception e) {
			logger.info("Keyboard already hidden");
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
			CustomWaitForElement(elements.getSignInFailedAlertId(), 3);
			if (isElementPresent(elements.getSignInFailedAlertId())) {
				logger.error("Sign in failed!: Invalid phone number or PIN");
			}
		} catch (Exception e) {
			logger.info("User credentials verified");
			LoggedIn = true;
		}

	}

}
