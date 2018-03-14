package functionalTests;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;

import android.util.Log;

import org.apache.commons.net.telnet.TelnetClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;

public class LoanApplicationParameterized extends PhoneLoginParameterized {
	LoanApplicationPageObject loanApplicationPageObject = new LoanApplicationPageObject();
	AppMenuPageObject appMenuPageObject = new AppMenuPageObject();
	public String HomeDir = System.getProperty("user.dir");
	private String SelectedReasons = "";
	private Boolean Selfie = false;
	private Boolean Pension = false;
	private Boolean GovtId = false;
	private String DateOfBirth = "";
	private String DateOfBirth2 = "";
	private Boolean Married = false;
	private Boolean Employed = false;
	private String DateOfEmployment = "";
	private String DateOfEmployment2 = "";
	private Boolean Rented = false;
	private Boolean StateSaved = false;
	private Boolean valid = false;

	// (dependsOnMethods = { "login()" })
	@Parameters({ "TestMode", "deviceId", "app-session", "app-version", "edit-details", "Overwrite", "PhoneNumber",
			"ApplyPIN", "First-Name", "Last-Name", "DOBDay", "DOBMonth", "DOBYear", "Gender", "Email", "Marital-Status",
			"Number-of-Children", "Name-of-Spouse", "Level-of-Education", "Employment-Status", "Employer",
			"EmploymentDay", "EmploymentMonth", "EmploymentYear", "EmploymentIncome", "Source-Of-Income",
			"Residence-Type", "Current-Address", "State", "LGA", "Town", "Landmark", "Rent-Amount",
			"AddressDurationYear", "AddressDurationMonth", "Bank", "Mobile-Money-Provider", "Bank-Account-Number",
			"BVN", "ID-Type", "ID-Number", "country", "RequestedAmount", "SelectAmountIndex", "Exp-Day", "Exp-Month",
			"Exp-Year" })
	@Test(dependsOnGroups = { "PhoneLoginParameterized.phoneLoginParameterized" }, groups = {
			"LoanApplicationParameterized.loanApplicationParameterized" })
	public void LoanApplication(String TestMode, String DeviceId, Boolean appSession, String AppVersion,
			Boolean editDetails, Boolean Overwrite, String PhoneNumber, String ApplyPIN, String FirstName,
			String Surname, String DOBDay, String DOBMonth, String DOBYear, String Gender, String Email,
			String MaritalStatus, String NumberofChildren, String NameofSpouse, String LevelofEducation,
			String EmploymentStatus, String Employer, String EmploymentDay, String EmploymentMonth,
			String EmploymentYear, String EmploymentIncome, String SourceOfIncome, String ResidenceType,
			String CurrentAddress, String State, String LGA, String Town, String Landmark, String RentAmount,
			String AddressDurationYear, String AddressDurationMonth, String Bank, String MobileMoneyProvider,
			String BankAccountNumber, String BVN, String IDType, String IDNumber, String Country,
			String RequestedAmount, int SelectAmountIndex, String ExpDay, String ExpMonth, String ExpYear)
			throws InterruptedException {
		// TODO Auto-generated method stub

		// Configure Logger
		Logger logger = Logger.getLogger("LoanApplication");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		logger.info("Loan Application Test");
		Thread.sleep(1000L);

		if (AppVersion.equals("Version 3.2.0")) {

			// Find Submit Button
			waitForElementClass(loanApplicationPageObject.getButtonsClass());
			try {
				List<AndroidElement> Buttons = ElementsClass(loanApplicationPageObject.getButtonsClass());
				String ButtonName = Buttons.get(0).getAttribute("text");

				// Apply from Loan Status
				if (TestMode.contains("From Loan Status")) {
					try {
						ClickId(appMenuPageObject.getMenuBtnId());
						logger.info("App menu button clicked");
					} catch (Exception e) {
						logger.error("Unable to click app menu button");
					}

					// Select Loan option
					try {
						ClickId(appMenuPageObject.getYourLoansId());
						logger.info("Loan option clicked");
					} catch (Exception e) {
						// Try again if Welcome message was dismissed
						try {
							ClickId(appMenuPageObject.getMenuBtnId());
							logger.info("App menu button clicked");
						} catch (Exception f) {
							logger.error("Unable to click app menu button");
						}

						try {
							ClickId(appMenuPageObject.getYourLoansId());
							logger.info("Loan option clicked");
						} catch (Exception f) {
							logger.error("Unable to click loan option");
						}
					}

					// Check Loan Status
					try {
						// Check Loan Status & Apply if loan status is declined
						Thread.sleep(4000);
						logger.info(checkLoanStatus());
					} catch (Exception e) {

						// Click Apply Button for user with empty loan status
						logger.info(applyUserNoStatus());

					}

				} else {
					// Apply from Home Page
					// Check button name
					if (ButtonName.equals("Take your first loan!") || ButtonName.equals("RETRY")) {
						Buttons.get(0).click();
						logger.info("Button Clicked: " + ButtonName);
					} else if (GetTextId(loanApplicationPageObject.getPersonalInformationTitleId())
							.equals("Personal information")) {
						logger.info("Personal Information page displayed");
					} else {

						logger.error("Loan Application halted! User may have an active loan");
						assertEquals(false, true);
						return;
					}
				}
			} catch (Exception e) {
				logger.error("Unable to find page button");
			}

		}

		// Other App Versions
		else {

			// Verify Loan Status Page
			assertElement(loanApplicationPageObject.getPageTitleId(), "Loan Status page title");

			logger.info("Test Mode: " + TestMode);

			Thread.sleep(3000);

			// Check Loan Status
			try {
				// Check Loan Status & Apply if loan status is declined
				logger.info(checkLoanStatus());
			} catch (Exception e) {

				// Click Apply Button for user with empty loan status
				logger.info(applyUserNoStatus());

			}
		}
		// Check if user has saved data
		try {
			CustomWaitForElement(loanApplicationPageObject.getEditDetailsTextId(), 5);
			logger.info("Saved user information found");
			// Edit saved user information
			if (editDetails) {
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
					ClickId(loanApplicationPageObject.getEditDetailsContinueId());
					editDetails = false;
					logger.info("Proceeding to requested loan amount...");

				} catch (Exception e) {
					logger.error("Unable to proceed to loan amount page");
				}
			}

		} catch (Exception e) {
			logger.info("User has no saved loan details. Filling application form...");
			editDetails = true;

			try {
				// Click Apply button for user with empty loan detail
				ClickId(loanApplicationPageObject.getApplyButtonId2());
				logger.info("Apply button clicked");

			} catch (Exception f) {
				logger.error("Unable to click pply button");
			}

		}
		if (editDetails) {
			// Fill Application Form here

			// Verify Personal Information page
			CustomWaitForElement(loanApplicationPageObject.getPersonalInformationTitleId(), 10);
			assertEquals(GetTextId(loanApplicationPageObject.getPersonalInformationTitleId()), "Personal information");

			// Scroll Page Up
			try {
				ScrollDown(0.99);
				logger.info("Page swiped");
			} catch (Exception f) {
				logger.error("Unable to swipe page");
			}

			// Enter First Name
			try {
				logger.info(enterFirstName(FirstName));

			} catch (Exception f) {
				logger.error("Unable to enter first name");
			}
			// Enter Last Name
			try {
				logger.info(enterSurname(Surname));
			} catch (Exception f) {
				logger.error("Unable to enter last name");
			}

			// Check if date of birth is already displayed
			if (GetStringLengthId(loanApplicationPageObject.getPersonalInformationDobId()) < 1) {
				// Display Calendar
				try {
					ClickId(loanApplicationPageObject.getPersonalInformationDobId());
					logger.info("Calendar displayed");
				} catch (Exception f) {
					logger.error("Unable to display calendar");
				}

				Thread.sleep(2000);

				// Select Date of Birth
				try {
					logger.info(enterDOB(DOBDay, DOBMonth, DOBYear));

				} catch (Exception e) {
					logger.error("Unable to select Date of Birth");
				}
				// Submit Calendar
				try {
					ClickId(loanApplicationPageObject.getPersonalInformationCalenderSubmitBtnId());
					logger.info("Calendar submitted");
				} catch (Exception f) {
					logger.error("Unable to submit calendar");
				}
			} else {
				// display saved date of birth
				try {
					logger.info("Save date of birth: "
							+ GetTextId(loanApplicationPageObject.getPersonalInformationDobId()));
				} catch (Exception f) {
					logger.error("Unable to display date of birth");
				}
			}

			// Select Gender
			try {
				logger.info(selectGender(Gender));
			} catch (Exception f) {
				logger.error("Unable to select a gender");
			}

			// Scroll
			try {
				ScrollDown(0.05);
				logger.info("Page swiped");
			} catch (Exception f) {
				logger.error("Unable to swipe page");
			}

			// Enter email address
			try {
				logger.info(enterEmailAddress(Email, Overwrite));
			} catch (Exception f) {
				logger.error("Unable to enter Email address");
			}

			// List marital status
			try {
				logger.info(selectMaritalStatus(MaritalStatus));
			} catch (Exception g) {
				logger.error("Unable to find marital status menu");
			}

			// Enter spouse name if married
			if (Married) {
				try {
					logger.info(enterSpouseName(NameofSpouse));
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
				logger.info(selectNumberofChildren(NumberofChildren));
			} catch (Exception g) {
				logger.error("Unable to find number of children menu");
			}

			// Click Submit Button
			try {
				ClickId(loanApplicationPageObject.getPersonalInformationNextBtnId());
				logger.info("Personal Information Next button clicked");
			} catch (Exception f) {
				logger.error("Unable to click Persnal Information Next button");
			}

			// Verify Education and Employment page
			CustomWaitForElement(loanApplicationPageObject.getEducationTitleId(), 10);
			assertEquals(GetTextId(loanApplicationPageObject.getEducationTitleId()), "Education and employment");

			// List Level of Education
			try {
				logger.info(selectLevelofEducation(LevelofEducation));
			} catch (Exception e) {
				logger.error("Unable to location level of Education menu");
			}

			// Select Employment Status
			try {
				logger.info(selectEmploymentStatus(EmploymentStatus));
			} catch (Exception e) {
				logger.error("Unable to list employment status menu");
			}

			// Enter Employment / Business name
			if (Employed) {
				logger.info("User is employed");

				try {
					logger.info(enterEmployer(Employer));
				} catch (Exception e) {
					logger.error("Unable to find Employer Name field");
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
				if (GetStringLengthId(loanApplicationPageObject.getEmploymentDateId()) < 1) {
					logger.info("No saved Employement date found");
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
						logger.info(selectDateofEmployment(EmploymentDay, EmploymentMonth, EmploymentYear));
					} catch (Exception f) {
						logger.error("Unable to select Date of Employment");
					}

					// Submit Calendar
					try {
						ClickId(loanApplicationPageObject.getEmploymentCalenderSubmitBtnId());
						logger.info("Calendar submitted");
					} catch (Exception f) {
						logger.error("Unable to submit calendar");
					}

					// Hide keyboard
					try {
						getDriver().hideKeyboard();
						logger.info("Keyboard hidden");
					} catch (Exception f) {
						logger.info("Keybaord already hidden");
					}

				} else {
					logger.info("Employment date found");
					// display saved date of employment
					try {
						logger.info("Save date of employment: "
								+ GetTextId(loanApplicationPageObject.getEmploymentDateId()));
					} catch (Exception f) {
						logger.error("Unable to display date of employment");
					}
				}

			} else {
				// Source of Income
				try {
					logger.info(enterSourceofIncome(SourceOfIncome));
				} catch (Exception e) {
					logger.error("Source of Income field not found");
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
			try {
				logger.info(enterMonthlyIncome(EmploymentIncome, Overwrite));
			} catch (Exception e) {
				logger.error("Monthly income field not found");
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

			// Check Page Error
			if (TestMode.equals("Loan Application - Income Too Low")) {

				try {
					assertEquals(GetTextId(loanApplicationPageObject.getMonthlyIncomeErrorId()),
							loanApplicationPageObject.getMonthlyIncomeError());
					logger.warn(GetTextId(loanApplicationPageObject.getMonthlyIncomeErrorId()));
					return;

				} catch (Exception e) {
					logger.error("Employment page error check failed");
					assertEquals(GetTextId(loanApplicationPageObject.getMonthlyIncomeErrorId()),
							loanApplicationPageObject.getMonthlyIncomeError());
				}
			}

			// Verify Address Details page
			CustomWaitForElement(loanApplicationPageObject.getAddressTitleId(), 10);
			assertEquals(GetTextId(loanApplicationPageObject.getAddressTitleId()), "Address details");

			// Select Residence Type
			try {
				logger.info(selectResidenceType(ResidenceType));
			} catch (Exception e) {
				logger.error("Residence Type menu not found");
			}

			// Current Address
			try {
				logger.info(enterCurrentAddress(CurrentAddress));
			} catch (Exception e) {
				logger.error("Current Address field not found");
			}
			// Hide keyboard
			try {
				getDriver().hideKeyboard();
				logger.info("Keyboard hidden");
			} catch (Exception f) {
				logger.info("Keybaord already hidden");
			}

			// State
			try {
				logger.info(selectState(State));
				Thread.sleep(7000L);
			} catch (Exception e) {
				logger.error("Unable to list State/Region menu");
			}
			// LGA
			try {
				logger.info(selectLGA(LGA));
			} catch (Exception e) {
				logger.error("Unable to find LGA/City menu");
			}

			// Scroll
			try {
				ScrollDown(0.05);
				logger.info("Page swiped");
			} catch (Exception f) {
				logger.error("Unable to swipe page");
			}

			if (Country.equals("Ghana")) {
				// Enter Town
				try {
					logger.info(enterTown(Town));
				} catch (Exception e) {
					logger.error("Town field not found");
				}
				// Hide keyboard
				try {
					getDriver().hideKeyboard();
					logger.info("Keyboard hidden");
				} catch (Exception f) {
					logger.info("Keybaord already hidden");
				}

				// Enter Landmark
				try {
					logger.info(enterLandmark(Landmark));
				} catch (Exception e) {
					logger.error("Landmark field not found");
				}
				// Hide keyboard
				try {
					getDriver().hideKeyboard();
					logger.info("Keyboard hidden");
				} catch (Exception f) {
					logger.info("Keybaord already hidden");
				}
			}

			if (Rented) {
				try {
					logger.info(enterRentAmount(RentAmount));
				} catch (Exception e) {
					logger.error("Unable to find rent field");
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
			try {
				logger.info(selectAddressDurationYear(AddressDurationYear, Country));
			} catch (Exception e) {
				logger.error("Unble to find Address Duration year field");
			}

			// Month
			try {
				logger.info(selectAddressDurationMonth(AddressDurationMonth, Country));
			} catch (Exception e) {
				logger.error("Unable to find Address Duration month field");
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
		assertElement(loanApplicationPageObject.getLoanDetailsTitleId(), "Loan Details page title");
		assertEquals(GetTextId(loanApplicationPageObject.getLoanDetailsTitleId()), "Loan details");

		// Enter requested amount
		try {
			CustomWaitForElement(loanApplicationPageObject.getLoanReasonId(), 10);
			SendKeysId(loanApplicationPageObject.getRequestedAmountId(), RequestedAmount);
			logger.info(GetTextId(loanApplicationPageObject.getRequestedAmountId()) + " entered");
		} catch (Exception e) {
			logger.error("Requested loan amount not entered");
		}

		// Validate requested amount
		try {
			logger.info(validateRequestedAmount(RequestedAmount));
		} catch (Exception e) {
			logger.error("Unable to validate requested amount");
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
			List<AndroidElement> reasons = ElementsClass(loanApplicationPageObject.getLoanReasonItemClass());
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
		// Nigeria
		if (Country.equals("Nigeria")) {
			assertElement(loanApplicationPageObject.getBankDetailsPageTitileId(), "Bank Details page title");

			// List banks
			// Check if bank is already selected
			try {
				logger.info(selectBank(Bank));
			} catch (Exception e) {
				logger.error("Unable to find banks");
			}
			Thread.sleep(2000L);

			// Enter Account Number
			try {
				logger.info(enterBankAccountNumber(BankAccountNumber));
			} catch (Exception e) {
				logger.error("Unable to enter account number");
			}

			// Enter BVN
			try {
				logger.info(enterBVN(BVN));
			} catch (Exception e) {
				logger.error("Unable to enter BVN");
			}

			// Click submit button
			try {
				ClickId(loanApplicationPageObject.getBankDetailsSubmitId());
				logger.info("Bank details page submitted");
			} catch (Exception e) {
				logger.error("Unable to submit bank details page");
			}

		} else if (Country.equals("Ghana")) {
			try {
				logger.info(selectMobileMoneyProvider(MobileMoneyProvider));
			} catch (Exception e) {
				logger.error("Unable to find Mobile money provider");
			}
			Thread.sleep(2000L);

			// Verify Mobile Money Account Number
			try {
				if (GetStringLengthId(loanApplicationPageObject.getMobileMoneyAccountId()) < 1) {
					logger.error("Mobile money account not found");
					assertEquals(true, false);
				} else {
					assertEquals(GetTextId(loanApplicationPageObject.getMobileMoneyAccountId()), PhoneNumber);
					logger.info("Saved Mobile Money account number is: "
							+ GetTextId(loanApplicationPageObject.getMobileMoneyAccountId()));

				}
			} catch (Exception e) {
				logger.error("Unable to enter Mobile Money account number");
			}

			// Click submit button
			try {
				ClickId(loanApplicationPageObject.getMobileMoneyDetailsSubmitId());
				logger.info("Mobile Money details page submitted");
			} catch (Exception e) {
				logger.error("Unable to submit Mobile Money details page");
			}
		}

		// CHECK PAGE ERRORS
		// Email
		if (TestMode.equals("Loan Application - Email Already Exists")) {
			try {
				CustomWaitForElement(loanApplicationPageObject.getBankErrorMsgId(), 20);
				assertEquals(GetTextId(loanApplicationPageObject.getBankErrorMsgId()),
						loanApplicationPageObject.getEmailError());
				logger.warn(GetTextId(loanApplicationPageObject.getBankErrorMsgId()));
				return;

			} catch (Exception e) {
				logger.error("Unique Email error check failed");
				assertEquals(GetTextId(loanApplicationPageObject.getBankErrorMsgId()),
						loanApplicationPageObject.getEmailError());
			}
		}

		// BVN
		if (TestMode.equals("Loan Application - BVN Already Exists")) {
			try {
				CustomWaitForElement(loanApplicationPageObject.getBankErrorMsgId(), 20);
				assertEquals(GetTextId(loanApplicationPageObject.getBankErrorMsgId()),
						loanApplicationPageObject.getBVNError());
				logger.warn(GetTextId(loanApplicationPageObject.getBankErrorMsgId()));
				return;

			} catch (Exception e) {
				logger.error("Unique Email error check failed");
				assertEquals(GetTextId(loanApplicationPageObject.getBankErrorMsgId()),
						loanApplicationPageObject.getBVNError());
			}
		}

		// Check Loan Offer Status
		CustomWaitForElement(loanApplicationPageObject.getLoanOfferStatusTitleId(), 20);
		try {
			logger.info("Loan Offer Status: " + GetTextId(loanApplicationPageObject.getLoanOfferStatusTitleId()));
		} catch (Exception e) {
			logger.error("Unable to get loan offer status");
		}
		CustomWaitForElement(loanApplicationPageObject.getLoanOfferReadyTitleId(), 600);
		try {
			logger.info("Loan Offer Ready: " + GetTextId(loanApplicationPageObject.getLoanOfferReadyMessageId()));
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
		assertElement(loanApplicationPageObject.getAvailableOfferAmountId(), "Available offer message");

		// Display Available Offer message
		try {
			logger.info("Offer Message: " + GetTextId(loanApplicationPageObject.getAvailableOfferAmountId()));
		} catch (Exception e) {
			logger.error("Unable to display available offer message");
		}

		// Select Another Offered Amount
		if (TestMode.contains("Select Another Amount")) {
			// List Offered Amount
			try {
				ClickId(loanApplicationPageObject.getSelectedAmountId());
				logger.info("Offered Amounts listed");
			} catch (Exception e) {
				logger.error("Unable to list offered amounts");
			}

			// Select required amount
			try {
				List<AndroidElement> Amounts = ElementsId(loanApplicationPageObject.getSelectedAmountId());
				logger.info("Clicked Amount: " + Amounts.get(SelectAmountIndex).getAttribute("text"));
				Amounts.get(SelectAmountIndex).click();
			} catch (Exception e) {
				logger.error("Unable to click an amount");
			}
		}
		// Display selected loan amount
		try {
			logger.info("Selected loan amount: " + GetTextId(loanApplicationPageObject.getSelectedAmountId()));
		} catch (Exception e) {
			logger.error("Unable to display selected loan amount");
		}
		// Select Loan Tenure
		try {
			List<AndroidElement> Tenures = ElementsClass(loanApplicationPageObject.getAvailableOfferTenureClass());
			Tenures.get(0).click();
			logger.info("Selected loan tenure: " + Tenures.get(0).getAttribute("text"));
		} catch (Exception e) {
			logger.error("Unabble to select a loan tenure");
		}

		// Display Loan Information
		try {
			logger.info("Interest Rate: " + GetTextId(loanApplicationPageObject.getInterestRateId()));
			logger.info("Total Interest: " + GetTextId(loanApplicationPageObject.getInterestAmountId()));
			logger.info("Repayment Amount: " + GetTextId(loanApplicationPageObject.getRepaymentAmountId()));
		} catch (Exception e) {
			logger.error("Unable to display loan information");
		}

		// Submit Loan Detail
		try {
			ClickId(loanApplicationPageObject.getSelectLoanDetailsApplyButtonId());
			logger.info("Application submit button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Application Submit button");
		}

		// Check needed requirement

		try {
			CustomWaitForElement(loanApplicationPageObject.getRequiredInfoAcceptId(), 10);
			List<AndroidElement> ReqInfo = ElementsClass(loanApplicationPageObject.getRequiredInfoTitleClass());
			logger.info(ReqInfo.get(0).getAttribute("text"));

			// Check Selfie requirement
			try {
				logger.info(GetTextId(loanApplicationPageObject.getRequiredInfoSelfieId()) + " is required");
				Selfie = true;
			} catch (Exception e) {
				logger.info("No selfie required");
			}
			// Check Govt ID requirement
			try {
				logger.info(GetTextId(loanApplicationPageObject.getRequiredInfoGovtId()) + " is required");
				GovtId = true;
			} catch (Exception e) {
				logger.info("No government ID required");
			}
			// Accept Requirements
			try {
				ClickId(loanApplicationPageObject.getRequiredInfoAcceptId());
				logger.info("Requirements Information accepted");
			} catch (Exception e) {
				logger.error("Unable to accept requirements information");
			}
			CustomWaitForElement(loanApplicationPageObject.getValidIdTitleId(), 20);
			// Check if ID was required
			if (GovtId) {
				// list ID Types
				try {
					List<AndroidElement> Ids = ElementsClass(loanApplicationPageObject.getValidIdMenuClass());
					Ids.get(0).click();
					logger.info("Governemnt ID menu listed");
				} catch (Exception e) {
					logger.error("Unable to list government ID menu");
				}
				// Select ID
				try {
					ScrollAndClick(IDType);
					logger.info(IDType + " selected");
				} catch (Exception e) {
					logger.error("Unble to select ID type");
				}
				// Enter ID Number
				try {
					SendKeysId(loanApplicationPageObject.getValidIdNumberId(), IDNumber);
					logger.info("ID Number entered: " + GetTextId(loanApplicationPageObject.getValidIdNumberId()));
				} catch (Exception e) {
					logger.error("Unable to enter ID number");
				}

				// Enter Expiry Date for Driver's License
				if (TestMode.contains("Driver's License") && GovtId) {
					// Hide Keyboard
					try {
						getDriver().hideKeyboard();
						logger.info("Keyboard closed");
					} catch (Exception e) {
						logger.info("No keyboard to dismiss");
					}

					// Click to display Calendar
					try {
						ClickId(loanApplicationPageObject.getValidCardExpiryDateId());
						logger.info("Calendar displayed");
					} catch (Exception f) {
						logger.error("Unable to display calendar");
					}

					// Select Card Expiry Date
					try {
						logger.info(selectDate(loanApplicationPageObject.getExpiryClass(), ExpDay, ExpMonth, ExpYear));
					} catch (Exception e) {
						logger.error("Unable to select Card Expiry Date");
					}

					// Submit Calendar
					try {
						ClickId(loanApplicationPageObject.getCalenderSubmitBtnId());
						logger.info("Calendar submitted");
					} catch (Exception f) {
						logger.error("Unable to submit calendar");
					}

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
						ClickId(loanApplicationPageObject.getValidCardSubmitId());
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
		CustomWaitForElement(loanApplicationPageObject.getLoanSummaryAmountId(), 15);
		assertElement(loanApplicationPageObject.getLoanSummaryAmountId(), "Loan Amount");
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
			logger.info("Discount: " + GetTextId(loanApplicationPageObject.getLoanSummaryDiscountId()));
			// logger.info("Total repayment: "
			// + LoanSummaryTexts.get(12).getAttribute("Text"));

			logger.info("Repayment Period: " + GetTextId(loanApplicationPageObject.getLoanSummaryTenureId()));
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
			logger.info("Loan confirmaton accepted");
		} catch (Exception e) {
			logger.error("Unable to accept loan confirmation");
		}

		// PIN Confirmation
		CustomWaitForElement(loanApplicationPageObject.getPINConfirmTextId(), 10);
		assertElement(loanApplicationPageObject.getPINConfirmTextId(), "PIN Confirmation Message");
		try {
			SendKeysId(loanApplicationPageObject.getPINConfirmInputId(), ApplyPIN);
			logger.info("PIN confirmation entered");
		} catch (Exception e) {
			logger.error("Unable to enter PIN cpnfirmation");
		}

		// Click PIN button for V3.2.0
		if (AppVersion.equals("Version 3.2.0")) {
			try {
				ClickId(loanApplicationPageObject.getPINDoneId());
				logger.info("PIN submitted");
			} catch (Exception e) {
				logger.error("Unable to submit PIN");
			}
		}

		// Send Location for Emulator
		if (DeviceId.contains("emulator") && !TestMode.contains("GPS Disabled")) {
			Thread.sleep(4000);
			try {
				logger.info(sendLocation());
			} catch (Exception e) {
				logger.error("Unable to send location");
			}
		}

		// Check Application Error
		if (TestMode.equals("Loan Application - Incorrect PIN")) {
			try {
				CustomWaitForElement(loanApplicationPageObject.getApplicationErrorId(), 5);
				assertEquals(GetTextId(loanApplicationPageObject.getApplicationErrorId()),
						loanApplicationPageObject.getPINError());
				logger.warn(GetTextId(loanApplicationPageObject.getApplicationErrorId()));
				return;

			} catch (Exception e) {
				logger.error("PIN error check failed");
				assertEquals(GetTextId(loanApplicationPageObject.getApplicationErrorId()),
						loanApplicationPageObject.getPINError());
			}
		}

		if (TestMode.contains("GPS Disabled")) {
			// Check Location not found messages
			try {
				CustomWaitForElement(loanApplicationPageObject.getLocationErrorId(), 5);
				assertEquals(GetTextId(loanApplicationPageObject.getLocationErrorId()),
						loanApplicationPageObject.getLocationError());
				logger.warn(GetTextId(loanApplicationPageObject.getLocationErrorId()));
				return;
			} catch (Exception e) {

				try {
					CustomWaitForElement(loanApplicationPageObject.getLocationInfoId(), 90);
					assertEquals(GetTextId(loanApplicationPageObject.getLocationInfoId()), "Click here");
					logger.info("Location help found: " + GetTextId(loanApplicationPageObject.getLocationInfoId()));
				} catch (Exception f) {
					logger.error("GPS Error check failed");
					assertEquals(true, false);
				}
				// Display Location Help
				try {
					ClickId(loanApplicationPageObject.getLocationInfoId());
					CustomWaitForElement(loanApplicationPageObject.getLocationInfoTitleId(), 10);
					assertEquals(GetTextId(loanApplicationPageObject.getLocationInfoTitleId()), "Paylater");
					logger.info("Location Help Window displayed");
					return;
				} catch (Exception f) {
					logger.error("Unable to display location help");
				}

			}
		}

		// Application Submitted
		try {
			CustomWaitForElement(loanApplicationPageObject.getTellAFriendBtnId(), 60);
			logger.info("Loan application submitted successfully");
		} catch (Exception e) {
			logger.error("Unable to submit loan application");
		}
		assertEquals(GetTextId(loanApplicationPageObject.getApplicationSubmittedTitleId()), "Application submitted!");

	}

	private boolean isAmountCorrect(String RequestedAmount) {
		return GetTextId(loanApplicationPageObject.getRequestedAmountId()).replaceAll(",", "").equals(RequestedAmount);
	}

	// Check Loan Status
	public String checkLoanStatus() {
		String Logs = "";
		if (GetTextId(loanApplicationPageObject.getLoanStatusId()).equals("Loan Declined")) {
			try {
				Logs += "\nLoan Status: " + GetTextId(loanApplicationPageObject.getLoanStatusId());
			} catch (Exception e) {
				Logs += "\nUnable to display loan status";
			}
			// Click Retry button
			try {
				ClickId(loanApplicationPageObject.getRetryBtnId());
				Logs += "\nRetry button clicked";
			} catch (Exception e) {
				Logs += "\nUnable to click Retry button";
			}
			// Pending
		} else if (GetTextId(loanApplicationPageObject.getLoanStatusId()).equals("Loan Pending")) {
			Logs += "\nUser has a pending loan";
			// Approved
		} else if (GetTextId(loanApplicationPageObject.getLoanStatusId()).equals("Loan Approved")) {
			Logs += "\nUser has an approved loan";
			// Disbursed
		} else if (GetTextId(loanApplicationPageObject.getLoanStatusId()).equals("Loan Disbursed")) {
			Logs += "\nUser has a disbursed loan";

		}
		return Logs;
	}

	public String applyUserNoStatus() {
		String Logs = "";
		// Click Apply Button for user with empty loan status
		try {
			ClickId(loanApplicationPageObject.getApplyButtonId());
			Logs += "\nApply button clicked";
		} catch (Exception f) {
			// proceed for user with no loan status
			try {
				if (GetTextId(loanApplicationPageObject.getPersonalInformationTitleId())
						.equals("Personal information")) {
					Logs += "\nFilling Personal Information";
				}
			} catch (Exception g) {
				Logs += "\nPersonal Information page not found";
			}
			// logger.error("Unable to click Apply button");
		}
		return Logs;
	}

	// Enter First Name
	public String enterFirstName(String FirstName) {
		String Logs = "";

		if (GetStringLengthId(loanApplicationPageObject.getPersonalInformationFirstNameId()) < 1) {
			SendKeysId(loanApplicationPageObject.getPersonalInformationFirstNameId(), FirstName + "\n");
			Logs += "\nFirst name entered: " + GetTextId(loanApplicationPageObject.getPersonalInformationFirstNameId());
			getDriver().hideKeyboard();
		} else {
			Logs += "\nSaved first name is: "
					+ GetTextId(loanApplicationPageObject.getPersonalInformationFirstNameId());

		}
		return Logs;
	}

	// Enter Surname
	public String enterSurname(String Surname) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getPersonalInformationLastNameId()) < 1) {
			SendKeysId(loanApplicationPageObject.getPersonalInformationLastNameId(), Surname + "\n");
			Logs += "\nLast name entered: " + GetTextId(loanApplicationPageObject.getPersonalInformationLastNameId());
			getDriver().hideKeyboard();
		} else {
			Logs += "\nSaved last name is: " + GetTextId(loanApplicationPageObject.getPersonalInformationLastNameId());

		}
		return Logs;
	}

	// Enter DOB
	public String enterDOB(String DOBDay, String DOBMonth, String DOBYear) {
		String Logs = "";
		List<AndroidElement> date = ElementsClass(loanApplicationPageObject.getPersonalInformationDobClass());

		PickDate(Integer.valueOf(date.get(1).getAttribute("text")), Integer.valueOf(DOBDay),
				Integer.valueOf(date.get(2).getAttribute("text")), Integer.valueOf(DOBYear),
				date.get(0).getAttribute("text"), DOBMonth);

		DateOfBirth = date.get(0).getAttribute("text") + "-";
		DateOfBirth += date.get(1).getAttribute("text") + "-";
		DateOfBirth += date.get(2).getAttribute("text");
		Logs += "\nDate of Birth selected: " + DateOfBirth;
		DateOfBirth2 = DOBMonth + "-";
		DateOfBirth2 += DOBDay + "-";
		DateOfBirth2 += DOBYear;
		Logs += "\nDate of Birth expected: " + DateOfBirth2;
		assertEquals(DateOfBirth, DateOfBirth2);
		return Logs;
	}

	// Select Gender
	public String selectGender(String Gender) {
		String Logs = "";
		if (Gender.equals("Male")) {
			ClickId(loanApplicationPageObject.getPersonalInformationMaleGenderId());
			Logs += "\nMale gender selected";
		} else {
			ClickId(loanApplicationPageObject.getPersonalInformationFemaleGenderId());
			Logs += "\nFemale gender selected";
		}
		return Logs;
	}

	// Enter Email Address
	public String enterEmailAddress(String Email, Boolean Overwrite) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getPersonalInformationEmailId()) < 1) {
			SendKeysId(loanApplicationPageObject.getPersonalInformationEmailId(), Email + "\n");
			Logs += "\nEmail address entered: " + GetTextId(loanApplicationPageObject.getPersonalInformationEmailId());
			getDriver().hideKeyboard();
		} else {
			Logs += "\nSaved email address is: " + GetTextId(loanApplicationPageObject.getPersonalInformationEmailId());
			if (Overwrite == true && Email.length() > 0) {
				ClearText(loanApplicationPageObject.getPersonalInformationEmailId());
				SendKeysId(loanApplicationPageObject.getPersonalInformationEmailId(), Email);
				Logs += "\nEmail entered: " + GetTextId(loanApplicationPageObject.getPersonalInformationEmailId());
				getDriver().hideKeyboard();

			}

		}
		return Logs;
	}

	// Select Marital Status
	public String selectMaritalStatus(String MaritalStatus) {
		String Logs = "";
		List<AndroidElement> MaritalStatuses = ElementsClass(
				loanApplicationPageObject.getPersonalInformationMariatalStatusClass());

		if (MaritalStatuses.get(2).getAttribute("text").equals("Please select one")) {
			MaritalStatuses.get(2).click();
			Logs += "\nMarital statuses listed";

			// Select a marital status
			try {
				ScrollAndClick(MaritalStatus);
				Logs += "\n" + MaritalStatuses.get(2).getAttribute("text") + " marital status selected";
				if (MaritalStatuses.get(2).getAttribute("text").equals("Married"))
					Married = true;
			} catch (Exception f) {
				Logs += "\nUnable to select a marital status";
			}
			// Thread.sleep(1000L);

		} else {
			Logs += "\nSaved marital status is: " + MaritalStatuses.get(2).getAttribute("text");
			// Set married status
			if (MaritalStatuses.get(2).getAttribute("text").equals("Married"))
				Married = true;

		}
		return Logs;
	}

	// Enter Spouse Name
	public String enterSpouseName(String NameofSpouse) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getPersonalInformationSpouseId()) < 1) {
			try {
				SendKeysId(loanApplicationPageObject.getPersonalInformationSpouseId(), NameofSpouse);
				Logs += "\nSpouse name entered: "
						+ GetTextId(loanApplicationPageObject.getPersonalInformationSpouseId());
			} catch (Exception f) {
				Logs += "\nUnable to enter spouse name";
			}
		} else {
			try {
				Logs += "\nSaved spouse name: " + GetTextId(loanApplicationPageObject.getPersonalInformationSpouseId());
			} catch (Exception f) {
				Logs += "\nUnable to display spouse name";
			}
		}
		return Logs;
	}

	// Select Number of Children
	public String selectNumberofChildren(String NumberofChildren) {
		String Logs = "";
		List<AndroidElement> Children = ElementsClass(loanApplicationPageObject.getPersonalInformationChildrenClass());

		if (Children.get(3).getAttribute("text").equals("Please select one")) {
			Children.get(3).click();
			Logs += "\nChildren listed";

			// Select number of children
			try {
				ScrollAndClick(NumberofChildren);
				Logs += "\nNumber of Children selected: " + Children.get(3).getAttribute("text");
			} catch (Exception f) {
				Logs += "\nUnable to select number of children";
			}

		} else {
			Logs += "\nSaved number of children is: " + Children.get(3).getAttribute("text");

		}
		return Logs;
	}

	// Select Level of Education
	public String selectLevelofEducation(String LevelofEducation) {
		String Logs = "";
		List<AndroidElement> EducationLevels = ElementsClass(loanApplicationPageObject.getEducationLevelClass());

		if (EducationLevels.get(1).getAttribute("text").equals("Please select one")) {
			EducationLevels.get(1).click();
			Logs += "\nEducation levels listed";

			// Select an education level
			try {
				ScrollAndClick(LevelofEducation);
				Logs += "\n" + EducationLevels.get(1).getAttribute("text") + " education level selected";
			} catch (Exception f) {
				Logs += "\nUnable to select a level of education";
			}
		} else {
			try {
				Logs += "\nSaved level of education is: " + EducationLevels.get(1).getAttribute("text");

			}

			catch (Exception g) {
				Logs += "\nUnable to find education level menu";
			}
		}
		return Logs;
	}

	// Select Employment Status
	public String selectEmploymentStatus(String EmploymentStatus) {
		String Logs = "";
		// List Employment Statuses
		List<AndroidElement> Employments = ElementsClass(loanApplicationPageObject.getEmployemtStatusClass());

		if (Employments.get(2).getAttribute("text").equals("Please select one")) {
			Employments.get(2).click();
			Logs += "\nEmployment statuses listed";

			// Select an employment status
			try {
				ScrollAndClick(EmploymentStatus);
				Logs += "\n" + Employments.get(2).getAttribute("text") + " employment status selected";
				if (Employments.get(2).getAttribute("text").equals("Employed")
						|| Employments.get(2).getAttribute("text").equals("Self-Employed"))
					Employed = true;
			} catch (Exception f) {
				Logs += "\nUnable to select an employment status";
			}
		} else {
			try {
				Logs += "\nSaved Employment Status is: " + Employments.get(2).getAttribute("text");

			}

			catch (Exception g) {
				Logs += "\nUnable to find employment status menu";
			}
			// Set Employed State
			if (Employments.get(2).getAttribute("text").equals("Employed")
					|| Employments.get(2).getAttribute("text").equals("Self-Employed"))
				Employed = true;
		}

		return Logs;
	}

	// Enter Employer Name
	public String enterEmployer(String Employer) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getEmployerId()) < 1) {
			Logs += "\nNo saved Employer name found";
			try {
				SendKeysId(loanApplicationPageObject.getEmployerId(), Employer);
				Logs += "\nEmployer name entered: " + GetTextId(loanApplicationPageObject.getEmployerId());
			} catch (Exception f) {
				Logs += "\nUnable to enter employer name";
			}
		} else {
			Logs += "\nEmployer name found";
			try {
				Logs += "\nSaved Employer name: " + GetTextId(loanApplicationPageObject.getEmployerId());
			} catch (Exception f) {
				Logs += "\nUnable to find employmer name";
			}
		}
		return Logs;
	}

	// Select Date of Employment
	public String selectDateofEmployment(String EmploymentDay, String EmploymentMonth, String EmploymentYear) {
		String Logs = "";
		List<AndroidElement> date = ElementsClass(loanApplicationPageObject.getEmploymentDateCalendarClass());

		PickDate(Integer.valueOf(date.get(1).getAttribute("text")), Integer.valueOf(EmploymentDay),
				Integer.valueOf(date.get(2).getAttribute("text")), Integer.valueOf(EmploymentYear),
				date.get(0).getAttribute("text"), EmploymentMonth);

		DateOfEmployment = date.get(0).getAttribute("text") + "-";
		DateOfEmployment += date.get(1).getAttribute("text") + "-";
		DateOfEmployment += date.get(2).getAttribute("text");
		Logs += "\nDate of Employment selected: " + DateOfEmployment;
		DateOfEmployment2 = EmploymentMonth + "-";
		DateOfEmployment2 += EmploymentDay + "-";
		DateOfEmployment2 += EmploymentYear;
		Logs += "\nDate of Employment expected: " + DateOfEmployment2;

		// Check if selected Date was correct
		if (!DateOfEmployment.equals(DateOfEmployment2)) {
			date = ElementsClass(loanApplicationPageObject.getEmploymentDateCalendarClass());
			PickDate(Integer.valueOf(date.get(1).getAttribute("text")), Integer.valueOf(EmploymentDay),
					Integer.valueOf(date.get(2).getAttribute("text")), Integer.valueOf(EmploymentYear),
					date.get(0).getAttribute("text"), EmploymentMonth);

			DateOfEmployment = date.get(0).getAttribute("text") + "-";
			DateOfEmployment += date.get(1).getAttribute("text") + "-";
			DateOfEmployment += date.get(2).getAttribute("text");
			Logs += "\nDate of Employment selected: " + DateOfEmployment;
			DateOfEmployment2 = EmploymentMonth + "-";
			DateOfEmployment2 += EmploymentDay + "-";
			DateOfEmployment2 += EmploymentYear;
			Logs += "\nDate of Employment expected: " + DateOfEmployment2;
		}

		return Logs;
	}

	// Enter Source of Income
	public String enterSourceofIncome(String SourceOfIncome) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getSourceOfIncomeId()) < 1) {
			try {
				SendKeysId(loanApplicationPageObject.getSourceOfIncomeId(), SourceOfIncome);
				Logs += "\nSource of income entered: " + GetTextId(loanApplicationPageObject.getSourceOfIncomeId());
			} catch (Exception f) {
				Logs += "\nUnable to enter source of income";
			}
		} else {
			try {
				Logs += "\nSaved source of income: " + GetTextId(loanApplicationPageObject.getSourceOfIncomeId());
			} catch (Exception f) {
				Logs += "\nUnable to find source of income";
			}
		}
		return Logs;
	}

	// Enter Monthly Income
	public String enterMonthlyIncome(String EmploymentIncome, Boolean Overwrite) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getEmploymentIncomeId()) < 1) {
			try {
				SendKeysId(loanApplicationPageObject.getEmploymentIncomeId(), EmploymentIncome);
				Logs += "\nMonthly income entered: " + GetTextId(loanApplicationPageObject.getEmploymentIncomeId());
			} catch (Exception f) {
				Logs += "\nUnable to enter monthly income";
			}
		} else {
			try {
				Logs += "\nSaved Monthly income: " + GetTextId(loanApplicationPageObject.getEmploymentIncomeId());

				if (Overwrite == true && EmploymentIncome.length() > 0) {
					ClearText(loanApplicationPageObject.getEmploymentIncomeId());
					SendKeysId(loanApplicationPageObject.getEmploymentIncomeId(), EmploymentIncome);
					Logs += "\nMonthly income entered: " + GetTextId(loanApplicationPageObject.getEmploymentIncomeId());

				}
			} catch (Exception f) {
				Logs += "\nUnable to find monthly income";
			}
		}
		return Logs;
	}

	// Select Residence type
	public String selectResidenceType(String ResidenceType) {
		String Logs = "";
		// List Residence Types
		List<AndroidElement> Residents = ElementsClass(loanApplicationPageObject.getResidenceTypeClass());

		if (Residents.get(1).getAttribute("text").equals("Please select one")) {
			Residents.get(1).click();
			Logs += "\nResident types listed";

			// Select a resident type
			try {
				ScrollAndClick(ResidenceType);
				Logs += "\n" + Residents.get(1).getAttribute("text") + " resident type selected";
				if (Residents.get(1).getAttribute("text").equals("Rented"))
					Rented = true;
			} catch (Exception f) {
				Logs += "\nUnable to select a resident type";
			}
		} else {
			try {
				Logs += "\nSaved Resident Type is: " + Residents.get(1).getAttribute("text");
				// Set Rent state
				if (Residents.get(1).getAttribute("text").equals("Rented"))
					Rented = true;

			}

			catch (Exception g) {
				Logs += "\nUnable to find resident type menu";
			}
		}
		return Logs;
	}

	// Enter Current Address
	public String enterCurrentAddress(String CurrentAddress) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getCurrentAddressId()) < 1) {
			try {
				SendKeysId(loanApplicationPageObject.getCurrentAddressId(), CurrentAddress);
				Logs += "\nCurrent address entered: " + GetTextId(loanApplicationPageObject.getCurrentAddressId());
			} catch (Exception f) {
				Logs += "\nUnable to enter current address";
			}
		} else {
			try {
				Logs += "\nSaved Current address: " + GetTextId(loanApplicationPageObject.getCurrentAddressId());
			} catch (Exception f) {
				Logs += "\nUnable to find current address";
			}
		}
		return Logs;
	}

	// Select State/Region
	public String selectState(String State) {
		String Logs = "";
		List<AndroidElement> States = ElementsClass(loanApplicationPageObject.getStateClass());

		if (States.get(2).getAttribute("text").equals("Please select one")) {
			States.get(2).click();
			Logs += "\nStates/regions listed";

			// Select a state or region
			try {
				ScrollAndClick(State);
				StateSaved = true;
				Logs += "\n" + States.get(2).getAttribute("text") + " state/region selected";
			} catch (Exception f) {
				Logs += "\nnable to select a state/region";
			}
		} else {
			try {
				Logs += "\nSaved State/region is: " + States.get(2).getAttribute("text");
				StateSaved = false;

			}

			catch (Exception g) {
				Logs += "\nUnable to find state/region menu";
			}
		}
		return Logs;
	}

	// Select LGA/City
	public String selectLGA(String LGA) {
		String Logs = "";
		List<AndroidElement> LGAs = ElementsClass(loanApplicationPageObject.getLgaClass());

		if (StateSaved) {
			LGAs.get(3).click();
			Logs += "\nLGAs/Cities listed";

			// Select an LGA
			try {
				ScrollAndClick(LGA);
				Logs += "\n" + LGAs.get(3).getAttribute("text") + " LGA selected";
			} catch (Exception f) {
				Logs += "\nUnable to select an LGA/City";
			}
		} else {
			try {
				Logs += "\nSaved LGA/City is: " + LGAs.get(3).getAttribute("text");

			}

			catch (Exception g) {
				Logs += "\nUnable to find LGA/City menu";
			}
		}
		return Logs;
	}

	// Enter Town
	public String enterTown(String Town) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getTownId()) < 1) {
			try {
				SendKeysId(loanApplicationPageObject.getTownId(), Town);
				Logs += "\nTown entered: " + GetTextId(loanApplicationPageObject.getTownId());
			} catch (Exception f) {
				Logs += "\nUnable to enter Town";
			}
		} else {
			try {
				Logs += "\nSaved Town: " + GetTextId(loanApplicationPageObject.getTownId());
			} catch (Exception f) {
				Logs += "\nUnable to find town";
			}
		}
		return Logs;
	}

	// Enter Landmark
	public String enterLandmark(String Landmark) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getLandmarkId()) < 1) {
			try {
				SendKeysId(loanApplicationPageObject.getLandmarkId(), Landmark);
				Logs += "\nLandmark entered: " + GetTextId(loanApplicationPageObject.getLandmarkId());
			} catch (Exception f) {
				Logs += "\nUnable to enter Landmark";
			}
		} else {
			try {
				Logs += "\nSaved Landmark: " + GetTextId(loanApplicationPageObject.getLandmarkId());
			} catch (Exception f) {
				Logs += "\nUnable to find landmark";
			}
		}
		return Logs;
	}

	// Enter Rent Amount
	public String enterRentAmount(String RentAmount) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getRentId()) < 1) {
			try {
				SendKeysId(loanApplicationPageObject.getRentId(), RentAmount);
				Logs += "\nRent amount entered: " + GetTextId(loanApplicationPageObject.getRentId());
			} catch (Exception f) {
				Logs += "\nUnable to enter rent amount";
			}
		} else {
			try {
				Logs += "\nSaved Rent amount: " + GetTextId(loanApplicationPageObject.getRentId());
			} catch (Exception f) {
				Logs += "\nUnable to find rent amount";
			}
		}
		return Logs;
	}

	// Select Residence Year
	public String selectAddressDurationYear(String AddressDurationYear, String Country) {
		String Logs = "";
		int YearIndex;
		if (Rented) {
			YearIndex = 4;
		} else {
			YearIndex = 5;
		}
		List<AndroidElement> Years = ElementsClass(loanApplicationPageObject.getAddressDurationYearClass());

		if (Years.get(YearIndex).getAttribute("text")
				.equals(loanApplicationPageObject.getAddressDurationYearDefault())) {
			Years.get(YearIndex).click();
			Logs += "\nYears listed";

			// Select a Year
			try {
				ScrollAndClick(AddressDurationYear);
				Logs += "\n" + Years.get(YearIndex).getAttribute("text") + " Resident Year(s) selected";
			} catch (Exception f) {
				Logs += "\nUnable to select a year";
			}
		} else {
			try {
				Logs += "\nSaved Resident year is: " + Years.get(YearIndex).getAttribute("text");

			}

			catch (Exception g) {
				Logs += "\nUnable to find Resident Year menu";
			}
		}
		return Logs;
	}

	// Select Address Duration Month
	public String selectAddressDurationMonth(String AddressDurationMonth, String Country) {
		String Logs = "";
		int MonthIndex;
		List<AndroidElement> Months = ElementsClass(loanApplicationPageObject.getAddressDurationMonthClass());
		if (Rented) {
			MonthIndex = 5;
		} else {
			MonthIndex = 6;
		}

		if (Months.get(MonthIndex).getAttribute("text")
				.equals(loanApplicationPageObject.getAddressDurationMonthDefault())) {
			Months.get(MonthIndex).click();
			Logs += "\nMonths listed";
			// Select a Month
			try {
				ScrollAndClick(AddressDurationMonth);
				Logs += "\n" + Months.get(MonthIndex).getAttribute("text") + " Resident Months(s) selected";
			} catch (Exception f) {
				Logs += "\nUnable to select a month";
			}
		} else {
			try {
				Logs += "\nSaved Resident month is: " + Months.get(MonthIndex).getAttribute("text");

			}

			catch (Exception g) {
				Logs += "\nUnable to find Resident Month menu";
			}
		}
		return Logs;
	}

	// Validate requested Amount
	public String validateRequestedAmount(String RequestedAmount) {
		String Logs = "";
		valid = false; // reset amount validity status
		while (valid == false) {
			valid = isAmountCorrect(RequestedAmount);
			if (!valid) {
				Logs += "\nRequested amount incorrect";

				// Enter Amount
				try {
					ClearText(loanApplicationPageObject.getRequestedAmountId());
					SendKeysId(loanApplicationPageObject.getRequestedAmountId(), RequestedAmount);
					Logs += "\nRequested amountre-entered: "
							+ GetTextId(loanApplicationPageObject.getRequestedAmountId());

				} catch (Exception e) {
					Logs += "\nUnable to re-enter requested amount";
				}
				// Hide Keyboard
				try {
					getDriver().hideKeyboard();
					Logs += "\nKeyboard closed";
				} catch (Exception e) {
					Logs += "\nKeyboard already hidden";
				}
			} else {
				Logs += "\nRequested amount validated";
			}
		}
		return Logs;
	}

	// Select bank
	public String selectBank(String Bank) {
		String Logs = "";
		List<AndroidElement> BankDetails = ElementsClass(loanApplicationPageObject.getBankNameMenuClass());
		if (BankDetails.get(1).getAttribute("text").equals("Please select one")) {
			Logs += "\nBank not yet selected, found: " + BankDetails.get(1).getAttribute("text");
			// list banks
			try {
				BankDetails.get(1).click();
				Logs += "\nBanks listed";

			} catch (Exception e) {
				Logs += "\nBanks not listed";
			}

			// Select a bank
			try {
				// ClickXpath(elements.getBankXpath());
				ScrollAndClick(Bank);
				Logs += "\n" + BankDetails.get(1).getAttribute("text") + " selected";
			} catch (Exception e) {
				Logs += "\nUnable to select bank";
			}
			// Thread.sleep(1000L);

		} else {
			Logs += "\nSaved bank is: " + BankDetails.get(1).getAttribute("text");

		}
		return Logs;
	}

	// Enter Bank Account Number
	public String enterBankAccountNumber(String BankAccountNumber) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getAccountNumberId()) < 1) {
			SendKeysId(loanApplicationPageObject.getAccountNumberId(), BankAccountNumber + "\n");
			Logs += "\nAccount number entered: " + GetTextId(loanApplicationPageObject.getAccountNumberId());
			getDriver().hideKeyboard();
		} else {
			Logs += "\nSaved account number is: " + GetTextId(loanApplicationPageObject.getAccountNumberId());

		}
		return Logs;
	}

	// Enter BVN
	public String enterBVN(String BVN) {
		String Logs = "";
		if (GetStringLengthId(loanApplicationPageObject.getBVNId()) < 1) {
			SendKeysId(loanApplicationPageObject.getBVNId(), BVN + "\n");
			Logs += "\nBVN entered: " + GetTextId(loanApplicationPageObject.getBVNId());
			try {
				getDriver().hideKeyboard();
				Logs += "\nKeyboard closed";
			} catch (Exception e) {
				Logs += "\nKeyboard already hidden";
			}
		} else {
			Logs += "\nSaved BVN is: " + GetTextId(loanApplicationPageObject.getBVNId());

		}
		return Logs;
	}

	// Select Mobile Money Provider
	public String selectMobileMoneyProvider(String MobileMoneyProvider) {
		String Logs = "";
		if (GetTextId(loanApplicationPageObject.getMobileMoneyProviderid()).equals("Select mobile money provider")) {
			Logs += "\nMobile money provider not yet selected, found: "
					+ GetTextId(loanApplicationPageObject.getMobileMoneyProviderid());
			// list Mobile money providers
			try {
				ClickId(loanApplicationPageObject.getMobileMoneyProviderid());
				Logs += "\nMobile money providers listed";

			} catch (Exception e) {
				Logs += "\nMobile money providers not listed";
			}

			// Select a Mobile money provider
			try {
				ScrollAndClick(MobileMoneyProvider);
				Logs += "\n" + GetTextId(loanApplicationPageObject.getMobileMoneyProviderid()) + " selected";
			} catch (Exception e) {
				Logs += "\nUnable to select Mobile money provider";
			}
			// Thread.sleep(1000L);

		} else {
			Logs += "\nSaved Mobile money provider is: "
					+ GetTextId(loanApplicationPageObject.getMobileMoneyProviderid());

		}
		return Logs;
	}

	public String sendLocation() throws SocketException, IOException {
		TelnetClient tc = null;

		InputStream inptStream;
		PrintStream outptStream;
		String prompt = "OK";

		// Instantiate the telnet client -- we use this to send geo fix commands to the
		// emulator
		tc = new TelnetClient();

		// Connect, this will generate the auth_token if it does not already exist in
		// file system
		System.out.println("Trying to connect to AVD...");
		tc.connect("localhost", 5554);

		// Check to see if we are connected
		Boolean areWeConn = tc.isConnected();
		System.out.println("Connected?" + areWeConn);

		// Get input and output stream references
		System.out.println("Getting input and output streams...");
		inptStream = tc.getInputStream();
		outptStream = new PrintStream(tc.getOutputStream());

		// wait for OK prompt
		System.out.println("Waiting for the OK prompt...");
		// Not including readUntil() code because it's just reading terminal output
		// readUntil(prompt);

		// Send the auth token number
		System.out.println("Sending auth token...");
		outptStream.println("auth " + "FnkhOQPKjzowVP8u");
		outptStream.flush();

		// wait for OK prompt
		// System.out.println("Waiting for the OK prompt...");
		// readUntil(prompt);

		// Send current location for our Starting Point
		System.out.println("Sending Current Location - Starting Point");
		outptStream.println("geo fix 3.416449 6.423749");
		outptStream.flush();

		// Now disconnect from Telnet
		System.out.println("Disconnecting from AVD...");
		tc.disconnect();

		// Check to see if we are still connected
		Boolean stillConn = tc.isConnected();
		System.out.println("Still connected? " + stillConn);
		return "Location Sent";
	}
}
