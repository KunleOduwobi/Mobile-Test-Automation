package functionalTests;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PhoneLoginParameterized extends Helper {

	Elements elements = new Elements();
	private Boolean valid = false;

	static String HomeDir = System.getProperty("user.dir");

	// Helper helper = new Helper();

	@Parameters({ "app-version", "app-session", "android-version", "returning-user", "TestMode", "PhoneNumber", "PIN" })
	@Test(groups = { "PhoneLoginParameterized.phoneLoginParameterized" })
	public void login(String AppVersion, Boolean appSession, String androidVersion, Boolean returningUser, String Test,
			String PhoneNumber, String PIN) throws InterruptedException {

		// Configure Logger
		Logger logger = Logger.getLogger("PhoneLoginParameterized.phoneLoginParameterized");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		// Log Data row
		try {
			logger.info(
					"Test Mode: " + Test + " Phone: " + PhoneNumber + " PIN: " + PIN + "App Session: " + appSession);
		} catch (Exception e) {
			logger.error("Unable to fetch parameter details");
		}

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

			// Select Login button
			waitForElement(elements.getLandingSignInBtnId());
			try {
				ClickId(elements.getLandingSignInBtnId());
				logger.info("Sign in button clicked");
			} catch (Exception e) {
				logger.error("Unable to click log in button");
			}

			// Find Phone Number input field
			CustomWaitForElement(elements.getPhoneNumberLoginId(), 15);
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
				SendKeysId(elements.getPhoneNumberLoginId(), PhoneNumber + "\n");
				logger.info("Phone number " + GetTextId(elements.getPhoneNumberLoginId()) + " entered");

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
						SendKeysId(elements.getPhoneNumberLoginId(), PhoneNumber);
						logger.info("Phone number re-entered: " + PhoneNumber);

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
				logger.info("Keyboard already hidden");
			}

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

			if (Test.contains("invalid credentials")) {
				if (AppVersion.equals("Version 3.2.1")) {
					CustomWaitForElement(elements.getSignInFailedAlertId2(), 15);
					assertEquals(GetTextId(elements.getSignInFailedAlertMsgId()), "Incorrect Phone Number or PIN.");
				} else {
					CustomWaitForElement(elements.getSignInFailedAlertId(), 15);
					assertEquals(GetTextId(elements.getSignInFailedAlertMsgId()),
							"Phone Number/PIN combination is not valid");
				}
				logger.error(GetTextId(elements.getSignInFailedAlertMsgId()));
				return;

			}

			// Check if PIN is incorrect
			try {
				if (AppVersion.equals("Version 3.2.1")) {
					CustomWaitForElement(elements.getSignInFailedAlertId2(), 5);
					if (isElementPresent(elements.getSignInFailedAlertId2())) {
						logger.error("Sign in failed!: Invalid phone number or PIN");
					}
				} else {
					CustomWaitForElement(elements.getSignInFailedAlertId(), 5);
					if (isElementPresent(elements.getSignInFailedAlertId())) {
						logger.error("Sign in failed!: Invalid phone number or PIN");
					}
				}
			} catch (Exception e) {
				logger.info("User credentials verified");
			}

			// Check if Device needs to be unlinked
			if (!AppVersion.equals("Version 3.0.2")) {
				try {
					CustomWaitForElement(elements.getUnlinkTitleId(), 5);
					ClickId(elements.getUnlinkDeviceBtnId());
					logger.info("Attempting to Unlink device");

				} catch (Exception e) {
					logger.info("Unlinking device skipped");
				}
			} else {
				try {
					CustomWaitForElement(elements.getUnlinkTitleId(), 5);
					ClickId(elements.getUnlinkDeviceBtnId());
					logger.info("Attempting to Unlink device");
					// Click sign in button again
					try {
						CustomWaitForElement(elements.getSignInBtnId(), 15);
						ClickId(elements.getSignInBtnId());
						logger.info("Sign in button clicked");
					} catch (Exception e) {
						logger.error("Unable to click Sign In button - Device unlinking might have failed");
					}

				} catch (Exception e) {
					logger.info("Unlinking device skipped");
				}

			}

			// Manage permissions for Android version >= 6
			if (Float.parseFloat(androidVersion) >= 6) {

				// Verify Permissions
				CustomWaitForElement(elements.getContinuePermissionsId(), 10);
				List<AndroidElement> PermissionPageElements = ElementsClass(elements.getGrantAccessClass());
				AssertJUnit.assertEquals(PermissionPageElements.get(0).getAttribute("text"), elements.getGrantAccess());

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
			}

			// Check if user is new with Welcome popup
			try {
				CustomWaitForElement(elements.getWelcomeBeginBtnId(), 10);
				ClickId(elements.getWelcomeBeginBtnId());
				logger.info("Begin button clicked. Verifying login status...");
			} catch (Exception e) {
				logger.info("Verifying login status...");
			}
			// Verify App Menu Button is found
			Thread.sleep(5000);
			assertElement(elements.getMenuButtonId(), "Menu Button");
			logger.info("User login successful!");

			// Saved session app start
		} else {

			if (AppVersion.contains("Version 3.2.")) {
				waitForElement(elements.getPINLoginId2());
			} else {
				waitForElement(elements.getPINLoginId());
			}

			// Returning User
			if (returningUser) {

				// Sign In as different user
				// Hide Keyboard
				try {
					getDriver().hideKeyboard();
					logger.info("Keyboard closed");
				} catch (Exception e) {
					logger.info("Keyboard already hidden");
				}
				try {
					ClickId(elements.getLoginAnotherUserId());
					logger.info("Login another user button clicked");
				} catch (Exception e) {
					logger.error("Unable to click Login another user button");
				}

				// Select Login button
				waitForElement(elements.getLandingSignInBtnId());
				try {
					ClickId(elements.getLandingSignInBtnId());
					logger.info("Sign in button clicked");
				} catch (Exception e) {
					logger.error("Unable to click log in button");
				}

				// Find Phone Number input field
				CustomWaitForElement(elements.getPhoneNumberLoginId(), 5);
				try {
					String text = GetTextId(elements.getPhoneNumberLoginId());
					logger.info(text + "Phone number field found");
				}

				catch (Exception e) {
					logger.error("Phone number input field not found");
				}

				// Enter Phone Number
				try {
					SendKeysId(elements.getPhoneNumberLoginId(), PhoneNumber + "\n");
					logger.info("Phone number " + GetTextId(elements.getPhoneNumberLoginId()) + " entered");

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
							SendKeysId(elements.getPhoneNumberLoginId(), PhoneNumber);
							logger.info("Phone number re-entered: " + PhoneNumber);

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
					logger.info("Keyboard already hidden");
				}

			}
			// Same User
			// Enter PIN

			if (AppVersion.contains("Version 3.2.")) {
				try {
					if (Test.equals("Login_with_another_user_test")) {
						SendKeysId(elements.getPINLoginId(), PIN + "\n");
					} else {
						List<AndroidElement> PINBoxes = ElementsClass(elements.getPINLoginClass());
						PINBoxes.get(1).sendKeys(PIN);
						// ClickId(elements.getPINLoginId2());
						// SendKeysId((elements.getPINLoginId2()), PIN);
					}
					logger.info("PIN entered");
				} catch (Exception e) {
					logger.error("Unable to enter PIN");
				}

			} else {
				try {
					SendKeysId((elements.getPINLoginId()), PIN);
					logger.info("PIN entered");
				} catch (Exception e) {
					logger.error("Unable to enter PIN");
				}
			}

			// Hide Keyboard
			try {
				getDriver().hideKeyboard();
				logger.info("Keyboard closed");
			} catch (Exception e) {
				logger.info("Keyboard already hidden");
			}

			// Click Sign In Button
			if (!AppVersion.equals("Version 3.2.1")
					|| (AppVersion.equals("Version 3.2.1") && Test.equals("Login_with_another_user_test"))) {
				try {
					CustomWaitForElement(elements.getSignInBtnId(), 5);
					ClickId(elements.getSignInBtnId());
					logger.info("Sign In button clicked");
				} catch (Exception e) {
					logger.error("Unable to click Sign in button");
				}
			}

			if (Test.contains("invalid credentials")) {
				CustomWaitForElement(elements.getSignInFailedAlertId2(), 15);
				assertEquals(GetTextId(elements.getSignInFailedAlertId2()), "Sign In Failed");
				logger.error(GetTextId(elements.getSignInFailedAlertId2()));
				return;

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
				// try {
				// CustomWaitForElement(elements.getSignInBtnId(), 15);
				// ClickId(elements.getSignInBtnId());
				// logger.info("Sign in button clicked");
				// } catch (Exception e) {
				// logger.error("Unable to click Sign In button - Device unlinking might have
				// failed");
				// }

			} catch (Exception e) {
				logger.info("Unlinking device skipped");
			}

			// Check if user is new with Welcome popup
			try {
				CustomWaitForElement(elements.getWelcomeBeginBtnId(), 8);
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

	private boolean isPhoneCorrect(String PhoneNumber) {
		return GetTextId(elements.getPhoneNumberLoginId()).replaceAll("\\s", "").equals(PhoneNumber);
	}

}
