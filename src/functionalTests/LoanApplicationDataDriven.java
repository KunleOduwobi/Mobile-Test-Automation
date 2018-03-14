package functionalTests;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.webdriven.commands.GetAttribute;

public class LoanApplicationDataDriven extends Helper {
	LoanApplicationPageObject loanApplicationPageObject = new LoanApplicationPageObject();
	Elements elements = new Elements();

	public static String HomeDir = System.getProperty("user.dir");
	private String SelectedReasons = "";
	private Boolean Selfie = false;
	private Boolean Pension = false;
	private Boolean GovtId = false;
	private String DateOfBirth = "";
	private Boolean Married = false;
	private Boolean Employed = false;
	private String DateOfEmployment = "";
	private Boolean Rented = false;
	private Boolean StateSaved = false;
	static String OutputFilePath = HomeDir + "/files/Output_Data.xlsx";
	static String LoanApplicationRequestedAmountsColName = "Requested Amounts";
	static String LoanApplicationOutPutSheetName = "LoanApplication";
	static String LoanApplicationOutPutColName = "Offer Message";
	static String LoanApplicationOutPutColName2 = "Selected Amount";
	static String LoanApplicationOutPutColName3 = "Offer Requirement";
	private String OfferRequirements = "";
	private int RowNum = 2;

	// (dependsOnMethods = { "login()" })
	// @Parameters({ "app-session", "edit-details" })
	@Test(dataProvider = "LoanApplication", dataProviderClass = DataProviders.class)
	public void CheckLoanStatus(String AppSession, String editDetails,
			String RequestedAmount) throws Exception {
		// TODO Auto-generated method stub

		// Configure Logger
		Logger logger = Logger.getLogger("LoanApplication");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		DataWriter dataWriter = new DataWriter(OutputFilePath);
		logger.info("App Session:" + AppSession);

		// Fresh app start
		if (!Boolean.valueOf(AppSession)) {

			// Dismiss slides
			CustomWaitForElement(elements.getSkipSlidesId(), 15);
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
				SendKeysId(elements.getPhoneNumberLoginId(),
						elements.getPhoneLogin() + "\n");
				// getDriver().hideKeyboard();
				logger.info("Phone number "
						+ GetTextId(elements.getPhoneNumberLoginId())
						+ " entered");
				// } else {
				// logger.info("Phone number is: "
				// + GetTextId(elements.getPhoneNumberLoginId()));
				// }
			} catch (Exception e) {
				logger.error("No phone number found");
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
				SendKeysId(elements.getPINLoginId(), elements.getPINLogin()
						+ "\n");
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
				try {
					CustomWaitForElement(elements.getSignInBtnId(), 15);
					ClickId(elements.getSignInBtnId());
					logger.info("Sign in button clicked");
				} catch (Exception e) {
					logger.error("Unable to click Sign In button");
				}

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

			// Saved session app start
		} else {
			waitForElement(elements.getPINLoginId());
			try {
				SendKeysId((elements.getPINLoginId()), elements.getPINLogin());
				logger.info("PIN entered");
			} catch (Exception e) {
				logger.error("Unable to enter PIN");
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

		Thread.sleep(1000L);

		logger.info("Testing with Requested Amount: " + RequestedAmount);

		// Verify Loan Status Page
		assertElement(loanApplicationPageObject.getPageTitleId(),
				"Loan Status page title");

		logger.info("Test Mode: Edit Details - " + editDetails);

		Thread.sleep(3000);

		// Check Loan Status
		try {
			// Declined
			if (GetTextId(loanApplicationPageObject.getLoanStatusId()).equals(
					"Loan Declined")) {
				try {
					logger.info("Loan Status: "
							+ GetTextId(loanApplicationPageObject
									.getLoanStatusId()));
				} catch (Exception e) {
					logger.error("Unable to display loan status");
				}
				// Click Retry button
				try {
					ClickId(loanApplicationPageObject.getRetryBtnId());
					logger.info("Retry button clicked");
				} catch (Exception e) {
					logger.error("Unable to click Retry button");
				}
				// Pending
			} else if (GetTextId(loanApplicationPageObject.getLoanStatusId())
					.equals("Loan Pending")) {
				logger.error("User has a pending loan");
				// Approved
			} else if (GetTextId(loanApplicationPageObject.getLoanStatusId())
					.equals("Loan Approved")) {
				logger.error("User has an approved loan");
				// Disbursed
			} else if (GetTextId(loanApplicationPageObject.getLoanStatusId())
					.equals("Loan Disbursed")) {
				logger.error("User has a disbursed loan");

			}
		} catch (Exception e) {

			// Click Apply Button for user with empty loan status
			try {
				ClickId(loanApplicationPageObject.getApplyButtonId());
				logger.info("Apply button clicked");
			} catch (Exception f) {
				// proceed for user with no loan status
				try {
					if (GetTextId(
							loanApplicationPageObject
									.getPersonalInformationTitleId()).equals(
							"Personal information")) {
						logger.info("Filling Personal Information");
					}
				} catch (Exception g) {
					logger.error("Personal Information page not found");
				}
				// logger.error("Unable to click Apply button");
			}

		}

		// Check if user has saved data
		try {
			CustomWaitForElement(
					loanApplicationPageObject.getEditDetailsTextId(), 5);
			logger.info("Saved user information found");
			// Edit saved user information
			if (Boolean.valueOf(editDetails)) {
				try {
					// Click Edit button
					ClickId(loanApplicationPageObject.getEditDetailsButtonId());
					logger.info("Edit Details button clicked.");

				} catch (Exception e) {
					logger.warn("Unable to click Edit Details button");
				}
			}
			// Continue with saved user information
			else {
				try {
					// Click continue button
					ClickId(loanApplicationPageObject
							.getEditDetailsContinueId());
					editDetails = "false";
					logger.info("Proceeding to requested loan amount...");

				} catch (Exception e) {
					logger.error("Unable to proceed to loan amount page");
				}
			}

		} catch (Exception e) {
			logger.info("User has no saved loan details. Filling application form...");

		}
		if (Boolean.valueOf(editDetails)) {
			// Fill Application Form here

			// Verify Personal Information page
			CustomWaitForElement(
					loanApplicationPageObject
							.getPersonalInformationFirstNameId(),
					10);
			assertEquals(
					GetTextId(loanApplicationPageObject
							.getPersonalInformationTitleId()),
					"Personal information");
			// First Name
			try {
				if (GetStringLengthId(loanApplicationPageObject
						.getPersonalInformationFirstNameId()) < 1) {
					SendKeysId(
							loanApplicationPageObject
									.getPersonalInformationFirstNameId(),
							loanApplicationPageObject
									.getPersonalInformationFirstName() + "\n");
					logger.info("First name entered: "
							+ GetTextId(loanApplicationPageObject
									.getPersonalInformationFirstNameId()));
					getDriver().hideKeyboard();
				} else {
					logger.info("Saved first name is: "
							+ GetTextId(loanApplicationPageObject
									.getPersonalInformationFirstNameId()));

				}
			} catch (Exception f) {
				logger.error("Unable to enter first name");
			}
			// Last Name
			try {
				if (GetStringLengthId(loanApplicationPageObject
						.getPersonalInformationLastNameId()) < 1) {
					SendKeysId(
							loanApplicationPageObject
									.getPersonalInformationLastNameId(),
							loanApplicationPageObject
									.getPersonalInformationLastName() + "\n");
					logger.info("Last name entered: "
							+ GetTextId(loanApplicationPageObject
									.getPersonalInformationLastNameId()));
					getDriver().hideKeyboard();
				} else {
					logger.info("Saved last name is: "
							+ GetTextId(loanApplicationPageObject
									.getPersonalInformationLastNameId()));

				}
			} catch (Exception f) {
				logger.error("Unable to enter last name");
			}

			// Check if date of birth is already displayed
			if (GetStringLengthId(loanApplicationPageObject
					.getPersonalInformationDobId()) < 1) {
				// Display Calendar
				try {
					ClickId(loanApplicationPageObject
							.getPersonalInformationDobId());
					logger.info("Calendar displayed");
				} catch (Exception f) {
					logger.error("Unable to display calendar");
				}

				Thread.sleep(2000);

				// Select Date of Birth
				try {
					List<AndroidElement> date = ElementsClass(loanApplicationPageObject
							.getPersonalInformationDobClass());
					date.get(0).clear();
					// date.get(0).clear();
					date.get(0).sendKeys(
							loanApplicationPageObject
									.getPersonalInformationDobMonth());
					date.get(0).sendKeys(
							loanApplicationPageObject
									.getPersonalInformationDobMonth());
					logger.info("Birth month entered: "
							+ loanApplicationPageObject
									.getPersonalInformationDobMonth());
					DateOfBirth = date.get(0).getAttribute("text") + "-";
					date.get(1).clear();
					date.get(1).sendKeys(
							loanApplicationPageObject
									.getPersonalInformationDobDay());
					logger.info("Birth day entered: "
							+ loanApplicationPageObject
									.getPersonalInformationDobDay());
					DateOfBirth += date.get(1).getAttribute("text") + "-";
					date.get(2).clear();
					date.get(2).sendKeys(
							loanApplicationPageObject
									.getPersonalInformationDobYear());
					logger.info("Birth  year entered: "
							+ loanApplicationPageObject
									.getPersonalInformationDobYear());
					DateOfBirth += date.get(2).getAttribute("text");

					logger.info("Date of Birth selected: " + DateOfBirth);
				} catch (Exception f) {
					logger.error("Unable to select Date of Birth");
				}

				// Submit Calendar
				try {
					ClickId(loanApplicationPageObject
							.getPersonalInformationCalenderSubmitBtnId());
					logger.info("Calendar submitted");
				} catch (Exception f) {
					logger.error("Unable to submit calendar");
				}
			} else {
				// display saved date of birth
				try {
					logger.info("Save date of birth: "
							+ GetTextId(loanApplicationPageObject
									.getPersonalInformationDobId()));
				} catch (Exception f) {
					logger.error("Unable to display date of birth");
				}
			}

			// Select Gender
			try {
				ClickId(loanApplicationPageObject
						.getPersonalInformationMaleGenderId());
				logger.info("Male gender selected");
			} catch (Exception f) {
				logger.error("Unable to select a gender");
			}

			// Enter email address
			try {
				if (GetStringLengthId(loanApplicationPageObject
						.getPersonalInformationEmailId()) < 1) {
					SendKeysId(
							loanApplicationPageObject
									.getPersonalInformationEmailId(),
							loanApplicationPageObject
									.getPersonalInformationLastName() + "\n");
					logger.info("Email address entered: "
							+ GetTextId(loanApplicationPageObject
									.getPersonalInformationEmailId()));
					getDriver().hideKeyboard();
				} else {
					logger.info("Saved email address is: "
							+ GetTextId(loanApplicationPageObject
									.getPersonalInformationEmailId()));

				}
			} catch (Exception f) {
				logger.error("Unable to enter Email address");
			}

			// Scroll
			try {
				ScrollDown(0.05);
				logger.info("Page swiped");
			} catch (Exception f) {
				logger.error("Unable to swipe page");
			}

			// List marital status
			try {
				List<AndroidElement> MaritalStatuses = ElementsClass(loanApplicationPageObject
						.getPersonalInformationMariatalStatusClass());

				if (MaritalStatuses.get(2).getAttribute("text")
						.equals("Please select one")) {
					MaritalStatuses.get(2).click();
					logger.info("Marital statuses listed");
					// Select a marital status
					try {
						ScrollAndClick(loanApplicationPageObject
								.getPersonalInformationMariatalStatus());
						logger.info(MaritalStatuses.get(2).getAttribute("text")
								+ " marital status selected");
						if (MaritalStatuses.get(2).getAttribute("text")
								.equals("Married"))
							Married = true;
					} catch (Exception f) {
						logger.error("Unable to select a marital status");
					}
					// Thread.sleep(1000L);

				} else {
					logger.info("Saved marital status is: "
							+ MaritalStatuses.get(2).getAttribute("text"));
					// Set married status
					if (MaritalStatuses.get(2).getAttribute("text")
							.equals("Married"))
						Married = true;

				}
			} catch (Exception g) {
				logger.error("Unable to find marital status menu");
			}

			// Enter spouse name if married
			if (Married) {
				try {
					if (GetStringLengthId(loanApplicationPageObject
							.getPersonalInformationSpouseId()) < 1) {
						try {
							SendKeysId(
									loanApplicationPageObject
											.getPersonalInformationSpouseId(),
									loanApplicationPageObject
											.getPersonalInformationSpouse());
							logger.info("Spouse name entered: "
									+ GetTextId(loanApplicationPageObject
											.getPersonalInformationSpouseId()));
						} catch (Exception f) {
							logger.error("Unable to enter spouse name");
						}
					} else {
						try {
							logger.info("Saved spouse name: "
									+ GetTextId(loanApplicationPageObject
											.getPersonalInformationSpouseId()));
						} catch (Exception f) {
							logger.error("Unable to display spouse name");
						}
					}
				} catch (Exception f) {
					logger.error("Unable to find spouse name");
				}
				// Hide keyboard
				try {
					getDriver().hideKeyboard();
					logger.info("Keyboard hidden");
				} catch (Exception f) {
					logger.info("Keybaord already hidden");
				}
			}

			// List Number of children
			try {
				List<AndroidElement> Children = ElementsClass(loanApplicationPageObject
						.getPersonalInformationChildrenClass());

				if (Children.get(3).getAttribute("text")
						.equals("Please select one")) {
					Children.get(3).click();
					logger.info("Children listed");
					// Select number of children
					try {
						ScrollAndClick(loanApplicationPageObject
								.getPersonalInformationChildren());
						logger.info("Number of Children selected: "
								+ Children.get(3).getAttribute("text"));
					} catch (Exception f) {
						logger.error("Unable to select number of children");
					}
					// Thread.sleep(1000L);

				} else {
					logger.info("Saved number of children is: "
							+ Children.get(3).getAttribute("text"));

				}
			} catch (Exception g) {
				logger.error("Unable to find number of children menu");
			}

			// Click Submit Button
			try {
				ClickId(loanApplicationPageObject
						.getPersonalInformationNextBtnId());
				logger.info("Personal Information Next button clicked");
			} catch (Exception f) {
				logger.error("Unable to click Persnal Information Next button");
			}

			// Verify Education and Employment page
			CustomWaitForElement(
					loanApplicationPageObject.getEducationTitleId(), 10);
			assertEquals(
					GetTextId(loanApplicationPageObject.getEducationTitleId()),
					"Education and employment");

			// List Level of Education

			List<AndroidElement> EducationLevels = ElementsClass(loanApplicationPageObject
					.getEducationLevelClass());

			if (EducationLevels.get(1).getAttribute("text")
					.equals("Please select one")) {
				EducationLevels.get(1).click();
				logger.info("Education levels listed");
				// Select an education level
				try {
					ScrollAndClick(loanApplicationPageObject
							.getEducationLevel());
					logger.info(EducationLevels.get(1).getAttribute("text")
							+ " education level selected");
				} catch (Exception f) {
					logger.error("Unable to select a level of education");
				}
			} else {
				try {
					logger.info("Saved level of education is: "
							+ EducationLevels.get(1).getAttribute("text"));

				}

				catch (Exception g) {
					logger.error("Unable to find education level menu");
				}
			}

			// List Employment Statuses
			List<AndroidElement> Employments = ElementsClass(loanApplicationPageObject
					.getEmployemtStatusClass());

			if (Employments.get(2).getAttribute("text")
					.equals("Please select one")) {
				Employments.get(2).click();
				logger.info("Employment statuses listed");
				// Select an employment status
				try {
					ScrollAndClick(loanApplicationPageObject
							.getEmploymentStatus());
					logger.info(Employments.get(2).getAttribute("text")
							+ " employment status selected");
					if (Employments.get(2).getAttribute("text")
							.equals("Employed")
							|| Employments.get(2).getAttribute("text")
									.equals("Self-Employed"))
						Employed = true;
				} catch (Exception f) {
					logger.error("Unable to select an semployment status");
				}
			} else {
				try {
					logger.info("Saved Employment Status is: "
							+ Employments.get(2).getAttribute("text"));

				}

				catch (Exception g) {
					logger.error("Unable to find employment status menu");
				}
				// Set Employed State
				if (Employments.get(2).getAttribute("text").equals("Employed")
						|| Employments.get(2).getAttribute("text")
								.equals("Self-Employed"))
					Employed = true;
			}
			// Enter Employment / Business name
			if (Employed) {
				logger.info("User is employed");
				if (GetStringLengthId(loanApplicationPageObject.getEmployerId()) < 1) {
					logger.info("Employer name not found");
					try {
						SendKeysId(loanApplicationPageObject.getEmployerId(),
								loanApplicationPageObject.getEmployer());
						logger.info("Employer name entered: "
								+ GetTextId(loanApplicationPageObject
										.getEmployerId()));
					} catch (Exception f) {
						logger.error("Unable to enter employer name");
					}
				} else {
					logger.info("Employer name found");
					try {
						logger.info("Saved Employer name: "
								+ GetTextId(loanApplicationPageObject
										.getEmployerId()));
					} catch (Exception f) {
						logger.error("Unable to find employmer name");
					}
				}
				// Hide keyboard
				try {
					getDriver().hideKeyboard();
					logger.info("Keyboard hidden");
				} catch (Exception f) {
					logger.info("Keybaord already hidden");
				}

				// Employment Duration

				// Check if date of employment is already displayed
				if (GetStringLengthId(loanApplicationPageObject
						.getEmploymentDateId()) < 1) {
					logger.info("Employement date not found");
					// Display Calendar
					try {
						ClickId(loanApplicationPageObject.getEmploymentDateId());
						logger.info("Calendar displayed");
					} catch (Exception f) {
						logger.error("Unable to display calendar");
					}

					Thread.sleep(2000);

					// Select Date of Employment
					try {
						List<AndroidElement> date = ElementsClass(loanApplicationPageObject
								.getEmploymentDateCalendarClass());
						date.get(0).clear();
						// date.get(0).clear();
						date.get(0).sendKeys(
								loanApplicationPageObject.getEmploymentMonth());
						date.get(0).sendKeys(
								loanApplicationPageObject.getEmploymentMonth());
						logger.info("Employment month entered: "
								+ loanApplicationPageObject
										.getEmploymentMonth());
						DateOfEmployment = date.get(0).getAttribute("text")
								+ "-";
						date.get(1).clear();
						date.get(1).sendKeys(
								loanApplicationPageObject.getEmploymentDay());
						logger.info("Employment day entered: "
								+ loanApplicationPageObject.getEmploymentDay());
						DateOfEmployment += date.get(1).getAttribute("text")
								+ "-";
						date.get(2).clear();
						date.get(2).sendKeys(
								loanApplicationPageObject.getEmploymentYear());
						logger.info("Employment  year entered: "
								+ loanApplicationPageObject.getEmploymentYear());
						DateOfEmployment += date.get(2).getAttribute("text");

						logger.info("Date of Employment selected: "
								+ DateOfEmployment);
					} catch (Exception f) {
						logger.error("Unable to select Date of Employment");
					}

					// Submit Calendar
					try {
						ClickId(loanApplicationPageObject
								.getEmploymentCalenderSubmitBtnId());
						logger.info("Calendar submitted");
					} catch (Exception f) {
						logger.error("Unable to submit calendar");
					}
				} else {
					logger.info("Employment date found");
					// display saved date of employment
					try {
						logger.info("Save date of employment: "
								+ GetTextId(loanApplicationPageObject
										.getEmploymentDateId()));
					} catch (Exception f) {
						logger.error("Unable to display date of employment");
					}
				}

			} else {
				// Source of Income
				if (GetStringLengthId(loanApplicationPageObject
						.getSourceOfIncomeId()) < 1) {
					try {
						SendKeysId(
								loanApplicationPageObject.getSourceOfIncomeId(),
								loanApplicationPageObject.getSourceOfIncome());
						logger.info("Source of income entered: "
								+ GetTextId(loanApplicationPageObject
										.getSourceOfIncomeId()));
					} catch (Exception f) {
						logger.error("Unable to enter source of income");
					}
				} else {
					try {
						logger.info("Saved source of income: "
								+ GetTextId(loanApplicationPageObject
										.getSourceOfIncomeId()));
					} catch (Exception f) {
						logger.error("Unable to find source of income");
					}
				}
				// Hide keyboard
				try {
					getDriver().hideKeyboard();
					logger.info("Keyboard hidden");
				} catch (Exception f) {
					logger.info("Keybaord already hidden");
				}

			}

			// Monthly Income
			if (GetStringLengthId(loanApplicationPageObject
					.getEmploymentIncomeId()) < 1) {
				try {
					SendKeysId(
							loanApplicationPageObject.getEmploymentIncomeId(),
							loanApplicationPageObject.getEmploymentIncome());
					logger.info("Monthly income entered: "
							+ GetTextId(loanApplicationPageObject
									.getEmploymentIncomeId()));
				} catch (Exception f) {
					logger.error("Unable to enter monthly income");
				}
			} else {
				try {
					logger.info("Saved Monthly income: "
							+ GetTextId(loanApplicationPageObject
									.getEmploymentIncomeId()));
				} catch (Exception f) {
					logger.error("Unable to find monthly income");
				}
			}
			// Hide keyboard
			try {
				getDriver().hideKeyboard();
				logger.info("Keyboard hidden");
			} catch (Exception f) {
				logger.info("Keybaord already hidden");
			}

			// Click Submit Button
			try {
				ClickId(loanApplicationPageObject.getEducationNextBtnId());
				logger.info("Education & Employment Next button clicked");
			} catch (Exception f) {
				logger.error("Unable to click ducation & Employment Next button");
			}

			// Verify Address Details page
			CustomWaitForElement(loanApplicationPageObject.getAddressTitleId(),
					10);
			assertEquals(
					GetTextId(loanApplicationPageObject.getAddressTitleId()),
					"Address details");

			// List Residence Types
			List<AndroidElement> Residents = ElementsClass(loanApplicationPageObject
					.getResidenceTypeClass());

			if (Residents.get(1).getAttribute("text")
					.equals("Please select one")) {
				Residents.get(1).click();
				logger.info("Resident types listed");
				// Select a resident type
				try {
					ScrollAndClick(loanApplicationPageObject.getResidenceType());
					logger.info(Residents.get(1).getAttribute("text")
							+ " resident type selected");
					if (Residents.get(1).getAttribute("text").equals("Rented"))
						Rented = true;
				} catch (Exception f) {
					logger.error("Unable to select a resident type");
				}
			} else {
				try {
					logger.info("Saved Resident Type is: "
							+ Residents.get(1).getAttribute("text"));
					// Set Rent state
					if (Residents.get(1).getAttribute("text").equals("Rented"))
						Rented = true;

				}

				catch (Exception g) {
					logger.error("Unable to find resident type menu");
				}
			}

			// Current Address
			if (GetStringLengthId(loanApplicationPageObject
					.getCurrentAddressId()) < 1) {
				try {
					SendKeysId(loanApplicationPageObject.getCurrentAddressId(),
							loanApplicationPageObject.getCurrentAddress());
					logger.info("Current address entered: "
							+ GetTextId(loanApplicationPageObject
									.getCurrentAddressId()));
				} catch (Exception f) {
					logger.error("Unable to enter current address");
				}
			} else {
				try {
					logger.info("Saved Current address: "
							+ GetTextId(loanApplicationPageObject
									.getCurrentAddressId()));
				} catch (Exception f) {
					logger.error("Unable to find current address");
				}
			}
			// Hide keyboard
			try {
				getDriver().hideKeyboard();
				logger.info("Keyboard hidden");
			} catch (Exception f) {
				logger.info("Keybaord already hidden");
			}

			// State
			List<AndroidElement> States = ElementsClass(loanApplicationPageObject
					.getStateClass());

			if (States.get(2).getAttribute("text").equals("Please select one")) {
				States.get(2).click();
				logger.info("States listed");
				// Select a state
				try {
					ScrollAndClick(loanApplicationPageObject.getState());
					StateSaved = true;
					logger.info(States.get(2).getAttribute("text")
							+ " state selected");
				} catch (Exception f) {
					logger.error("Unable to select a state");
				}
			} else {
				try {
					logger.info("Saved State is: "
							+ States.get(2).getAttribute("text"));
					StateSaved = false;

				}

				catch (Exception g) {
					logger.error("Unable to find state menu");
				}
			}
			// LGA
			Thread.sleep(4000L);
			List<AndroidElement> LGAs = ElementsClass(loanApplicationPageObject
					.getLgaClass());

			if (StateSaved) {
				LGAs.get(3).click();
				logger.info("LGAs listed");
				// Select an LGA
				try {
					ScrollAndClick(loanApplicationPageObject.getLga());
					logger.info(LGAs.get(3).getAttribute("text")
							+ " LGA selected");
				} catch (Exception f) {
					logger.error("Unable to select an LGA");
				}
			} else {
				try {
					logger.info("Saved LGA is: "
							+ LGAs.get(3).getAttribute("text"));

				}

				catch (Exception g) {
					logger.error("Unable to find LGA menu");
				}
			}

			if (Rented) {
				if (GetStringLengthId(loanApplicationPageObject.getRentId()) < 1) {
					try {
						SendKeysId(loanApplicationPageObject.getRentId(),
								loanApplicationPageObject.getRent());
						logger.info("Rent amount entered: "
								+ GetTextId(loanApplicationPageObject
										.getRentId()));
					} catch (Exception f) {
						logger.error("Unable to enter rent amount");
					}
				} else {
					try {
						logger.info("Saved Rent amount: "
								+ GetTextId(loanApplicationPageObject
										.getRentId()));
					} catch (Exception f) {
						logger.error("Unable to find rent amount");
					}
				}
				// Hide keyboard
				try {
					getDriver().hideKeyboard();
					logger.info("Keyboard hidden");
				} catch (Exception f) {
					logger.info("Keybaord already hidden");
				}
			}

			// Resident duration
			// Year
			List<AndroidElement> Years = ElementsClass(loanApplicationPageObject
					.getAddressDurationYearClass());

			if (Years
					.get(5)
					.getAttribute("text")
					.equals(loanApplicationPageObject
							.getAddressDurationYearDefault())) {
				Years.get(5).click();
				logger.info("Years listed");
				// Select a Year
				try {
					ScrollAndClick(loanApplicationPageObject
							.getAddressDurationYear());
					logger.info(Years.get(5).getAttribute("text")
							+ " Resident Year(s) selected");
				} catch (Exception f) {
					logger.error("Unable to select a year");
				}
			} else {
				try {
					logger.info("Saved Resident year is: "
							+ Years.get(5).getAttribute("text"));

				}

				catch (Exception g) {
					logger.error("Unable to find Resident Year menu");
				}
			}

			// Month
			List<AndroidElement> Months = ElementsClass(loanApplicationPageObject
					.getAddressDurationMonthClass());

			if (Months
					.get(6)
					.getAttribute("text")
					.equals(loanApplicationPageObject
							.getAddressDurationMonthDefault())) {
				Months.get(6).click();
				logger.info("Months listed");
				// Select a Month
				try {
					ScrollAndClick(loanApplicationPageObject
							.getAddressDurationMonth());
					logger.info(Months.get(6).getAttribute("text")
							+ " Resident Months(s) selected");
				} catch (Exception f) {
					logger.error("Unable to select a month");
				}
			} else {
				try {
					logger.info("Saved Resident month is: "
							+ Months.get(6).getAttribute("text"));

				}

				catch (Exception g) {
					logger.error("Unable to find Resident Month menu");
				}
			}
			// Click Next button
			try {
				ClickId(loanApplicationPageObject.getAddressDetailsNextBtnId());
				logger.info("Next button clicked");
			} catch (Exception e) {
				logger.error("Unable to click Next button");
			}

		}

		// Verify Loan Detail Page
		assertElement(loanApplicationPageObject.getLoanDetailsTitleId(),
				"Loan Details page title");
		assertEquals(
				GetTextId(loanApplicationPageObject.getLoanDetailsTitleId()),
				"Loan details");

		// Enter requested amount
		try {
			CustomWaitForElement(loanApplicationPageObject.getLoanReasonId(),
					10);
			SendKeysId(loanApplicationPageObject.getRequestedAmountId(),
					RequestedAmount);
			logger.info(GetTextId(loanApplicationPageObject
					.getRequestedAmountId()) + " entered");
		} catch (Exception e) {
			logger.error("Loan amount not entered");
		}

		// Display Loan Reason list
		try {
			ClickId(loanApplicationPageObject.getLoanReasonId());
			logger.info("Loan reason listed");
		} catch (Exception e) {
			logger.error("Loan reason not listed");
		}

		// Select loan reason(s)
		try {
			List<AndroidElement> reasons = ElementsClass(loanApplicationPageObject
					.getLoanReasonItemClass());
			reasons.get(0).click();
			logger.info(reasons.get(0).getAttribute("text") + " Selected");
			SelectedReasons = reasons.get(0).getAttribute("text") + ", ";
			reasons.get(3).click();
			logger.info(reasons.get(3).getAttribute("text") + " Selected");
			SelectedReasons += reasons.get(3).getAttribute("text");
		}

		catch (Exception e) {

		}

		// Submit reason
		try {
			ClickId(loanApplicationPageObject.getLoanReasonOkButton());
			logger.info("Submitted loan reasons: " + SelectedReasons);
		} catch (Exception e) {
			logger.error("Loan reason not submitted");
		}

		// Submit Loan Detail Page
		try {
			ClickId(loanApplicationPageObject.getLoanDetailsSubmitButtonId());
			logger.info("Loan details page submitted");
		} catch (Exception e) {
			logger.error("Loan details page not submitted");
		}

		// Verify Loan Detail Page
		assertElement(loanApplicationPageObject.getBankDetailsPageTitileId(),
				"Bank Details page title");

		// List banks
		// Check if bank is already selected
		try {
			List<AndroidElement> BankDetails = ElementsClass(loanApplicationPageObject
					.getBankNameMenuClass());
			if (BankDetails.get(1).getAttribute("text").equals("Please select one")) {
				logger.info("Bank not yet selected, found: "
						+ BankDetails.get(1).getAttribute("text"));
				// list banks
				try {
					BankDetails.get(1).click();
					logger.info("Banks listed");

				} catch (Exception e) {
					logger.error("Banks not listed");
				}

				// Select a bank
				try {
					// ClickXpath(elements.getBankXpath());
					ScrollAndClick(loanApplicationPageObject.getBank());
					logger.info(BankDetails.get(1).getAttribute("text")
							+ " selected");
				} catch (Exception e) {
					logger.error("Unable to select bank");
				}
				// Thread.sleep(1000L);

			} else {
				logger.info("Saved bank is: "
						+ BankDetails.get(1).getAttribute("text"));

			}
		} catch (Exception e) {
			logger.error("Unable to find banks");
		}
		Thread.sleep(2000L);

		// Enter Account Number
		try {
			if (GetStringLengthId(loanApplicationPageObject
					.getAccountNumberId()) < 1) {
				SendKeysId(loanApplicationPageObject.getAccountNumberId(),
						loanApplicationPageObject.getAccountNumber() + "\n");
				logger.info("Account number entered: "
						+ GetTextId(loanApplicationPageObject
								.getAccountNumberId()));
				getDriver().hideKeyboard();
			} else {
				logger.info("Saved account number is: "
						+ GetTextId(loanApplicationPageObject
								.getAccountNumberId()));

			}
		} catch (Exception e) {
			logger.error("Unable to enter account number");
		}

		// Enter BVN
		try {
			if (GetStringLengthId(loanApplicationPageObject.getBVNId()) < 1) {
				SendKeysId(loanApplicationPageObject.getBVNId(),
						loanApplicationPageObject.getBVN() + "\n");
				logger.info("BVN entered: "
						+ GetTextId(loanApplicationPageObject.getBVNId()));
				getDriver().hideKeyboard();
			} else {
				logger.info("Saved BVN is: "
						+ GetTextId(loanApplicationPageObject.getBVNId()));

			}
		} catch (Exception e) {
			logger.error("Unable to enter BVN");
		}

		// Click submit button
		try {
			ClickId(loanApplicationPageObject.getBankDetailsSubmitId());
			logger.info("Bank details page submitted");
		} catch (Exception e) {
			logger.error("Unable to enter a BVN");
		}

		// Check Loan Offer Status
		CustomWaitForElement(
				loanApplicationPageObject.getLoanOfferStatusTitleId(), 10);
		try {
			logger.info("Loan Offer Status: "
					+ GetTextId(loanApplicationPageObject
							.getLoanOfferStatusTitleId()));
		} catch (Exception e) {
			logger.error("Unable to get loan offer status");
		}
		CustomWaitForElement(
				loanApplicationPageObject.getLoanOfferReadyTitleId(), 600);
		try {
			logger.info("Loan Offer Ready: "
					+ GetTextId(loanApplicationPageObject
							.getLoanOfferReadyMessageId()));
		} catch (Exception e) {
			logger.error("No offer available");
		}
		// See Loan Offer
		try {
			ClickId(loanApplicationPageObject.getLoanOfferReadySubmitId());
			logger.info("Loan Offer button clicked");
		} catch (Exception e) {
			logger.error("Unable to view Loan Offer");
		}

		// Verify Offer Page
		assertElement(loanApplicationPageObject.getAvailableOfferAmountId(),
				"Available offer message");

		// Display Available Offer message
		try {
			logger.info("Offer Message: "
					+ GetTextId(loanApplicationPageObject
							.getAvailableOfferAmountId()));
		} catch (Exception e) {
			logger.error("Unable to display available offer message");
		}
		
		// Record Requested Amount to Output file
				try {
					dataWriter.setCellData(LoanApplicationOutPutSheetName,
							LoanApplicationRequestedAmountsColName, RowNum,
							RequestedAmount);
					logger.info("Requested amount recorded");
				} catch (Exception e) {
					logger.error("Unable to record requested amount");
				}

		// Record Offer Amount to Output file
		try {
			dataWriter.setCellData(LoanApplicationOutPutSheetName,
					LoanApplicationOutPutColName, RowNum,
					GetTextId(loanApplicationPageObject
							.getAvailableOfferAmountId()));
			logger.info("Offer amount recorded");
		} catch (Exception e) {
			logger.error("Unable to record offer amount");
		}
		// Display selected loan amount
		try {
			logger.info("Selected loan amount: "
					+ GetTextId(loanApplicationPageObject.getSelectedAmountId()));
		} catch (Exception e) {
			logger.error("Unable to display selected loan amount");
		}

		// Record Selected Amount to Output file
		try {
			dataWriter.setCellData(LoanApplicationOutPutSheetName,
					LoanApplicationOutPutColName2, RowNum,
					GetTextId(loanApplicationPageObject.getSelectedAmountId()));
			logger.info("Selected amount recorded");
		} catch (Exception e) {
			logger.error("Unable to record selected amount");
		}

		// Select Loan Tenure
		try {
			List<AndroidElement> Tenures = ElementsClass(loanApplicationPageObject
					.getAvailableOfferTenureClass());
			Tenures.get(0).click();
			logger.info("Selected loan tenure: "
					+ Tenures.get(0).getAttribute("text"));
		} catch (Exception e) {
			logger.error("Unabble to select a loan tenure");
		}

		// Display Loan Information
		try {
			logger.info("Interest Rate: "
					+ GetTextId(loanApplicationPageObject.getInterestRateId()));
			logger.info("Total Interest: "
					+ GetTextId(loanApplicationPageObject.getInterestAmountId()));
			logger.info("Repayment Amount: "
					+ GetTextId(loanApplicationPageObject
							.getRepaymentAmountId()));
		} catch (Exception e) {
			logger.error("Unable to display loan information");
		}

		// Submit Loan Detail
		try {
			ClickId(loanApplicationPageObject
					.getSelectLoanDetailsApplyButtonId());
			logger.info("Application submit button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Application Submit button");
		}

		// Check needed requirement

		try {
			CustomWaitForElement(
					loanApplicationPageObject.getRequiredInfoAcceptId(), 10);
			List<AndroidElement> ReqInfo = ElementsClass(loanApplicationPageObject
					.getRequiredInfoTitleClass());
			logger.info(ReqInfo.get(0).getAttribute("text"));

			// Check Selfie requirement
			try {
				logger.info(GetTextId(loanApplicationPageObject
						.getRequiredInfoSelfieId()) + " is required");
				Selfie = true;
				OfferRequirements += GetTextId(loanApplicationPageObject
						.getRequiredInfoSelfieId()) + ", ";
			} catch (Exception e) {
				logger.info("No selfie required");
			}
			// Check Govt ID requirement
			try {
				logger.info(GetTextId(loanApplicationPageObject
						.getRequiredInfoGovtId()) + " is required");
				GovtId = true;
				OfferRequirements += GetTextId(loanApplicationPageObject
						.getRequiredInfoGovtId()) + ", ";
			} catch (Exception e) {
				logger.info("No government ID required");
			}

			// Record Offer Requirements to Output file
			try {
				dataWriter.setCellData(LoanApplicationOutPutSheetName,
						LoanApplicationOutPutColName3, RowNum,
						OfferRequirements);
				OfferRequirements = "";
				logger.info("Selected amount recorded");
			} catch (Exception e) {
				logger.error("Unable to record selected amount");
			}
			// Accept Requirements
			try {
				ClickId(loanApplicationPageObject.getRequiredInfoAcceptId());
				logger.info("Requirements Information accepted");
			} catch (Exception e) {
				logger.error("Unable to accept requirements information");
			}
			CustomWaitForElement(loanApplicationPageObject.getValidIdTitleId(),
					20);
			// Check if ID was required
			if (GovtId) {
				// list ID Types
				try {
					List<AndroidElement> Ids = ElementsClass(loanApplicationPageObject
							.getValidIdMenuClass());
					Ids.get(0).click();
					logger.info("Governemnt ID menu listed");
				} catch (Exception e) {
					logger.error("Unable to list government ID menu");
				}
				// Select ID
				try {
					ScrollAndClick(loanApplicationPageObject.getIdType1());
					logger.info(loanApplicationPageObject.getIdType1()
							+ " selected");
				} catch (Exception e) {
					logger.error("Unble to select ID type");
				}
				// Enter ID Number
				try {
					SendKeysId(loanApplicationPageObject.getValidIdNumberId(),
							loanApplicationPageObject.getVotersCardNumber());
					logger.info("ID Number entered: "
							+ GetTextId(loanApplicationPageObject
									.getValidIdNumberId()));
				} catch (Exception e) {
					logger.error("Unable to enter ID number");
				}
				// Submit Valid ID Page
				if (GovtId) {
					try {
						getDriver().hideKeyboard();
						logger.info("Keyboard closed");
					} catch (Exception e) {
						logger.info("No keyboard to dismiss");
					}
					try {
						ClickId(loanApplicationPageObject
								.getValidCardSubmitId());
						logger.info("Valid Identification page submitted");
					} catch (Exception e) {
						logger.error("Unable to submit Idenfication");
					}

				}

			}
		} catch (Exception e) {
			logger.info("No further information required. Proceeding to Loan Application Summary...");
		}
		// Loan Summary
		CustomWaitForElement(
				loanApplicationPageObject.getLoanSummaryAmountId(), 15);
		assertElement(loanApplicationPageObject.getLoanSummaryAmountId(),
				"Loan Amount");
		// Display Loan Information
		try {
			logger.info("Fetching Loan Summary Information...");
			// List<AndroidElement> LoanSummaryTexts =
			// ElementsClass(loanApplicationPageObject
			// .getLoanSummaryTextClass());
			// logger.info("Loan Amount: "
			// + LoanSummaryTexts.get(2).getAttribute("Text"));
			// logger.info("Loan Interest: "
			// + LoanSummaryTexts.get(7).getAttribute("Text"));
			logger.info("Discount: "
					+ GetTextId(loanApplicationPageObject
							.getLoanSummaryDiscountId()));
			// logger.info("Total repayment: "
			// + LoanSummaryTexts.get(12).getAttribute("Text"));

			logger.info("Repayment Period: "
					+ GetTextId(loanApplicationPageObject
							.getLoanSummaryTenureId()));
		} catch (Exception e) {
			logger.error("Unable to display Loan Summary Information");
		}

		// Click Apply Button
		try {
			ClickId(loanApplicationPageObject.getLoanSummaryApplyBtnId());
			logger.info("Loan Summary page submitted");
		} catch (Exception e) {
			logger.error("Unable to submit loan summary page");
		}

		Thread.sleep(2000);
		// Get number of instalments
		// try {
		// List<AndroidElement> instalments =
		// ElementsClass(loanApplicationPageObject
		// .getConfirmationPaymentsClass());
		// logger.info("Number of instalments: "
		// + String.valueOf((instalments.size() - 2) / 3));
		// } catch (Exception e) {
		// logger.error("Unable to get number of instalments");
		// }

		// Accept Confirmation
		try {
			ClickId(loanApplicationPageObject.getConfirmationSubmitId());
			RowNum++;
			logger.info("Loan confirmaton accepted");
		} catch (Exception e) {
			logger.error("Unable to accept loan confirmation");
		}

		// PIN Confirmation
		CustomWaitForElement(loanApplicationPageObject.getPINConfirmTextId(),
				10);
		assertElement(loanApplicationPageObject.getPINConfirmTextId(),
				"PIN Confirmation Message");
		try {
			SendKeysId(loanApplicationPageObject.getPINConfirmInputId(),
					elements.getPINLogin());
			logger.info("PIN confirmation entered");
		} catch (Exception e) {
			logger.error("Unable to enter PIN cpnfirmation");
		}

		// Application Submitted
		// try {
		// CustomWaitForElement(
		// loanApplicationPageObject.getTellAFriendBtnId(), 60);
		// logger.info("Loan application submitted successfully");
		// } catch (Exception e) {
		// logger.error("Unable to submit loan application");
		// }
		// assertEquals(
		// GetTextId(loanApplicationPageObject
		// .getApplicationSubmittedTitleId()),
		// "Application submitted!");

	}
}
