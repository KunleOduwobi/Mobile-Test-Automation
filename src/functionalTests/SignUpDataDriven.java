package functionalTests;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpDataDriven extends Helper {

	Elements elements = new Elements();
	SignUpPageObject signUpPageObject = new SignUpPageObject();
	private String HomeDir = System.getProperty("user.dir");
	private String LoggerText = "";
	private String DateOfBirth = "";
	private String ExpectedDoB = "";
	private Boolean LoggedIn = false;
	private Boolean valid = false;
	private String Phonenumbers;
	private String PINs;

	// @Parameters({ "app-session", "android-version" })
	@Test(groups = { "SignUp.signUp" }, dataProvider = "SignUp", dataProviderClass = DataProviders.class)
	public void signup(String Test, String Firstname, String Surname,
			String Month, String Day, String Year, String Phonenumber,
			String Email, String PIN, String EditPhone, String EditOTP,
			String appSession, String androidVersion)
			throws InterruptedException {

		// Store current cycle
		Phonenumbers = Phonenumber;
		PINs = PIN;

		// Configure Logger
		Logger logger = Logger.getLogger("SignUp.signUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		logger.info("Test mode: " + Test);
		// Fresh app start
		if (!Boolean.valueOf(appSession)) {

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
		try {
			SendKeysId(signUpPageObject.getFirstnameId(), Firstname);
			logger.info("Firstname entered: " + Firstname);
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
			logger.info("Surname entered: " + Surname);
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

		// Dismiss suggestion banner
		try {
			ClickId(signUpPageObject.getSurnameId());
			logger.info("Suggestion window dismissed");
			try {
				getDriver().hideKeyboard();
				logger.info("Keyboard closed");
			} catch (Exception e) {
				logger.info("Keyboard already hidden");
			}
		} catch (Exception e) {
			logger.error("Unable to dismiss suggestion window");
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
			logger.info("Email entered: " + Email);
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
			List<AndroidElement> date = ElementsClass(signUpPageObject
					.getDobClass());

			date.get(0).click();
			// logger.info("Month listed");
			// ScrollAndClick(signUpPageObject.getDobMonth());
			// logger.info("Birth month entered: "
			// + signUpPageObject.getDobMonth());
			// ExpectedDoB = signUpPageObject.getDobMonth() + "/";
			// DateOfBirth = date.get(0).getAttribute("text") + "/";
			//
			// date.get(1).click();
			// logger.info("Day listed");
			// date.get(1).sendKeys(signUpPageObject.getDobDay());
			// date.get(1).sendKeys(signUpPageObject.getDobDay());
			// logger.info("Birth day entered: " +
			// signUpPageObject.getDobDay());
			// ExpectedDoB = signUpPageObject.getDobDay() + "/" + ExpectedDoB;
			// DateOfBirth = date.get(1).getAttribute("text") + "/" +
			// DateOfBirth;
			//
			// date.get(2).sendKeys(signUpPageObject.getDobYear());
			// date.get(2).sendKeys(signUpPageObject.getDobYear());
			// logger.info("Birth  year entered: " +
			// signUpPageObject.getDobYear());
			// ExpectedDoB += signUpPageObject.getDobYear();
			// DateOfBirth += date.get(2).getAttribute("text");
			//
			// logger.info("Date of Birth selected: " + DateOfBirth);
			// logger.info("Expected Date of Birth: " + ExpectedDoB);
		} catch (Exception f) {
			logger.error("Unable to select Date of Birth");
		}

		// Submit Calendar
		try {
			ClickId(signUpPageObject.getCalenderSubmitBtnId());
			logger.info("Calendar submitted");
		} catch (Exception f) {
			logger.error("Unable to submit calendar");
		}
		// Compare Dates

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
			SendKeysId(signUpPageObject.getPhonenumberId(), Phonenumber);
			logger.info("Phone number entered: " + Phonenumber);

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

		valid = false; // reset phone validity status

		// Validate phone number
		while (valid == false) {
			valid = isPhoneCorrect();
			if (!valid) {
				logger.warn("Phone number incorrect");
				// Enter Phone
				try {
					ClearText(signUpPageObject.getPhonenumberId());
					SendKeysId(signUpPageObject.getPhonenumberId(), Phonenumber);
					logger.info("Phone number re-entered: " + Phonenumber);

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

		assertEquals(GetTextId(signUpPageObject.getPhonenumberDescId()),
				signUpPageObject.getPhonenumberDesc());

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
		assertEquals(GetTextId(signUpPageObject.getTnCTitleId()),
				signUpPageObject.getTnCTitle());
		try {
			LoggerText = GetTextId(signUpPageObject.getTnCAgreeId());
			ClickId(signUpPageObject.getTnCAgreeId());
			logger.info("Terms & Conditions selected button: " + LoggerText);
		} catch (Exception e) {
			logger.error("Unable to agree terms & conditions");
		}

		LoggedIn = false; // reset login status

		// Check if Phone number exists
		try {
			CustomWaitForElement(signUpPageObject.getAccountExistsTitleId(), 10);
			logger.warn("Sign up halted!");
			if (GetTextId(signUpPageObject.getAccountExistsTitleId()).equals(
					signUpPageObject.getAccountExistsTitle())) {
				logger.warn(GetTextId(signUpPageObject
						.getAccountExistsTitleId()));
				// login with existing phone number
				LoginExistinguser();

			}
		} catch (Exception e) {
			logger.info("Proceeding to create PIN...");

		}

		// Create PIN
		if (!LoggedIn) {
			try {
				CustomWaitForElement(signUpPageObject.getCreatePinTitleId(), 5);
				SendKeysId(signUpPageObject.getCreatePinId(), PIN);
				logger.info("PIN entered: " + PIN);
			} catch (Exception e) {
				logger.error("Unable to enter PIN");
			}

			// Confirm PIN
			try {
				CustomWaitForElement(signUpPageObject.getConfirmPINTextId(), 5);
				SendKeysId(signUpPageObject.getCreatePinId(), PIN);
				logger.info("PIN re-entered: " + signUpPageObject.getPIN());
			} catch (Exception e) {
				logger.error("Unable to confirm PIN");
			}

			// Verify PIN Success
			try {
				CustomWaitForElement(signUpPageObject.getPINSuccessTitleId(),
						10);
				assertEquals(
						GetTextId(signUpPageObject.getPINSuccessTitleId()),
						signUpPageObject.getPINSuccessText());
				logger.info("PIN created successfully");
			} catch (Exception e) {
				logger.error("PIN not created");
			}
		}

		// Check if Device is linked to another user
		try {
			CustomWaitForElement(signUpPageObject.getUnlinkTitleId(), 5);
			if (GetTextId(signUpPageObject.getUnlinkTextId()).equals(
					signUpPageObject.getUnlinkText())) {
				logger.warn(GetTextId(signUpPageObject.getUnlinkTextId()));
				// Unlink device
				UnlinkDeviceNewUser();

			}
		} catch (Exception e) {
			logger.info("Unlinking of device not required. Checking if phone verification is required...");
		}

		// Check if Profile already exists
		try {
			CustomWaitForElement(signUpPageObject.getProfileExistsId(), 10);
			assertEquals(GetTextId(signUpPageObject.getProfileExistsId()),
					signUpPageObject.getProfileExists());
			logger.warn("Profile already exists. Reset your PIN to continue");
		} catch (Exception e) {
			logger.info("No existing profile found");
		}

		if (!LoggedIn) {
			// Wait for Phone number verification
			try {
				CustomWaitForElement(signUpPageObject.getVerifyTextId(), 15);
				assertElement(signUpPageObject.getVerifyTextId(),
						"Verification message");

				// Enter invalid verification code
				if (Boolean.valueOf(EditOTP)) {
					try {
						List<AndroidElement> Codes = ElementsClass(signUpPageObject
								.getVerifyInputClass());
						Codes.get(1).sendKeys("000000");
						logger.info("Invalid verification code entered");
					} catch (Exception e) {
						logger.error("Unable to enter verification code");
					}
					// Wait for Error Dialog
					CustomWaitForElement(
							signUpPageObject.getInvalidCodeDialogId(), 10);
					logger.warn("Verification process halted!");
					if (GetTextId(signUpPageObject.getInvalidCodeTitleId())
							.equals(signUpPageObject.getInvalidCodeText())) {
						logger.error(GetTextId(signUpPageObject
								.getInvalidCodeTitleId()));
						// login with existing phone number

					}

				}

				// Click Change Phone number button
				if (Boolean.valueOf(EditPhone)) {
					try {
						ClickId(signUpPageObject.getVerifyTextId());
						logger.info("Change Phone Number button clicked");
					} catch (Exception e) {
						logger.error("Unable to click Change Phone number button");
					}

					// Edit Phone Number
					try {
						CustomWaitForElement(
								signUpPageObject.getChangeNumberId(), 5);
						SendKeysId(signUpPageObject.getChangeNumberId(),
								signUpPageObject.getPhonenumber());
						logger.info("Phone number entered: "
								+ signUpPageObject.getPhonenumber());
					} catch (Exception e) {
						logger.error("Unable to enter Phone number");
					}

					valid = false; // reset phone validity status

					// Validate phone number
					while (valid == false) {
						valid = isChangedPhoneCorrect();
						if (!valid) {
							logger.warn("Phone number incorrect");
							// Enter Phone
							try {
								ClearText(signUpPageObject.getChangeNumberId());
								SendKeysId(
										signUpPageObject.getChangeNumberId(),
										signUpPageObject.getPhonenumber());
								logger.info("Phone number re-entered: "
										+ Phonenumber);

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

					// Click Resend Button after 61 seconds
					logger.info("Waiting for 60 seconds before sending SMS...");

					Thread.sleep(61000);
					try {

						ClickId(signUpPageObject.getResendSMSID());
						logger.info("Resend button clicked");
					} catch (Exception e) {
						logger.error("Unable to click Resend button");
					}
				}
				logger.info("Awaiting OTP..");
			} catch (Exception e) {
				logger.error("Unable to receive OTP");
			}

			// Check if Phone was verified
			try {
				CustomWaitForElement(
						signUpPageObject.getVerifySuccessTitleId(), 60);
				assertEquals(
						GetTextId(signUpPageObject.getVerifySuccessTitleId()),
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
			logger.error("New user not logged in automatically");
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
			// // Click sign in button again
			// try {
			// CustomWaitForElement(elements.getSignInBtnId(), 15);
			// ClickId(elements.getSignInBtnId());
			// logger.info("Sign in button clicked");
			// } catch (Exception e) {
			// logger.error("Unable to click Sign In button - Device unlinking might have failed");
			// }

		} catch (Exception e) {
			logger.info("Unlinking device skipped");
		}

//		// Click Submit button again
//		try {
//			LoggerText = GetTextId(signUpPageObject.getNextBtnId());
//			ClickId(signUpPageObject.getNextBtnId());
//			logger.info(LoggerText + " button clicked");
//		} catch (Exception e) {
//			logger.error("Unable to click FINISH button, device unlinking might have failed");
//
//		}
//
//		// Accept Terms & Conditions
//		CustomWaitForElement(signUpPageObject.getTnCTitleId(), 5);
//		assertEquals(GetTextId(signUpPageObject.getTnCTitleId()),
//				signUpPageObject.getTnCTitle());
//		try {
//			LoggerText = GetTextId(signUpPageObject.getTnCAgreeId());
//			ClickId(signUpPageObject.getTnCAgreeId());
//			logger.info("Terms & Conditions selected button: " + LoggerText);
//		} catch (Exception e) {
//			logger.error("Unable to agree terms & conditions");
//		}
//
//		// Create PIN
//		if (!LoggedIn) {
//			try {
//				CustomWaitForElement(signUpPageObject.getCreatePinTitleId(), 5);
//				SendKeysId(signUpPageObject.getCreatePinId(),
//						signUpPageObject.getPIN());
//				logger.info("PIN entered: " + signUpPageObject.getPIN());
//			} catch (Exception e) {
//				logger.error("Unable to enter PIN");
//			}
//
//			// Confirm PIN
//			try {
//				CustomWaitForElement(signUpPageObject.getConfirmPINTextId(), 5);
//				SendKeysId(signUpPageObject.getCreatePinId(),
//						signUpPageObject.getPIN());
//				logger.info("PIN re-entered: " + signUpPageObject.getPIN());
//			} catch (Exception e) {
//				logger.error("Unable to confirm PIN");
//			}
//		}

	}

	public void LoginExistinguser() {

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
		assertEquals(
				GetTextId(elements.getPhoneNumberLoginId()).replaceAll("\\s",
						""), // remove whitespaces
				Phonenumbers);
		logger.info("Login Phonenumber confirmed: "
				+ GetTextId(elements.getPhoneNumberLoginId()));

		// Enter PIN
		try {

			SendKeysId(elements.getPINLoginId(), PINs + "\n");
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

		// Check if Device is linked to another user
		try {
			CustomWaitForElement(signUpPageObject.getUnlinkTitleId(), 10);
			// if (GetTextId(signUpPageObject.getUnlinkTextId()).equals(
			// signUpPageObject.getUnlinkText())) {
			logger.warn(GetTextId(signUpPageObject.getUnlinkTextId()));
			// Unlink device
			try {
				// CustomWaitForElement(elements.getUnlinkTitleId(),
				// 5);
				ClickId(elements.getUnlinkDeviceBtnId());
				logger.info("Attempting to Unlink device");
				// Click sign in button again
//				try {
//					CustomWaitForElement(elements.getSignInBtnId(), 15);
//					ClickId(elements.getSignInBtnId());
//					logger.info("Sign in button clicked");
//				} catch (Exception e) {
//					logger.error("Unable to click Sign In button - Device unlinking might have failed");
//				}

			} catch (Exception e) {
				logger.info("Unlinking device skipped");
			}
			// }
		} catch (Exception e) {
			logger.info("Checking if phone verification is required...");
		}
	}

	private boolean isPhoneCorrect() {
		return GetTextId(signUpPageObject.getPhonenumberId()).replaceAll("\\s",
				"").equals(Phonenumbers);
	}

	private boolean isChangedPhoneCorrect() {
		return GetTextId(signUpPageObject.getChangeNumberId()).replaceAll(
				"\\s", "").equals(signUpPageObject.getPhonenumber());
	}

}
