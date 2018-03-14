package functionalTests;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoanStatus extends PhoneLoginParameterized {
	LoanStatusPageObject loanStatusPageObject = new LoanStatusPageObject();
	AppMenuPageObject appMenuPageObject = new AppMenuPageObject();
	private static String HomeDir = System.getProperty("user.dir");

	// (dependsOnMethods = { "login()" })
	@Parameters({ "TestMode", "app-version" })
	@Test(dependsOnGroups = { "PhoneLoginParameterized.phoneLoginParameterized" }, groups = { "LoanStatus.loanStatus" })
	public void CheckLoanStatus(String TestMode, String AppVersion) throws InterruptedException {
		// TODO Auto-generated method stub

		// Configure Logger
		Logger logger = Logger.getLogger("LoanStatus");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		Thread.sleep(100L);

		if (AppVersion.equals("Version 3.2.0")) {

			// Click Menu Button
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
				logger.error("Unable to click loan option");
			}
		}

		// Verify Loan Status Page
		CustomWaitForElement(loanStatusPageObject.getPageTitleId(), 5);
		assertEquals(GetTextId(loanStatusPageObject.getPageTitleId()), "Your loan");
		logger.info("Verifying loan status...");

		// VERIFY LOAN STATUS FIELDS

		// Pending loan
		if (TestMode.equals("Pending")) {
			CustomWaitForElement(loanStatusPageObject.getLoanStatusTextId(), 30);

			// loan status
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusId()),
						loanStatusPageObject.getPendingStatus());
				logger.info("Loan Status Validated: " + GetTextId(loanStatusPageObject.getLoanStatusId()));

			} catch (Exception e) {
				logger.error("Loan status not found");
			}

			// Status Message
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusTextId()),
						loanStatusPageObject.getLoanStatusText());
				logger.info("Status Message Validated: " + GetTextId(loanStatusPageObject.getLoanStatusTextId()));

			} catch (Exception e) {
				logger.error("Status message not found");
			}

			// Loan Amount
			try {
				assertEquals(
						GetTextId(loanStatusPageObject.getCurrencyId())
								+ GetTextId(loanStatusPageObject.getLoanAmountId()),
						loanStatusPageObject.getNaira() + "7,500");
				logger.info("Loan Amount Validated: " + GetTextId(loanStatusPageObject.getCurrencyId())
						+ GetTextId(loanStatusPageObject.getLoanAmountId()));

			} catch (Exception e) {
				logger.error("Loan amount not found");
			}

			// Application Date
			try {
				logger.info("Application Date: " + GetTextId(loanStatusPageObject.getApplicationDateId()));

			} catch (Exception e) {
				logger.error("Application date not found");
			}

			// Processing Button
			try {
				List<AndroidElement> buttons = ElementsClass(loanStatusPageObject.getProcessingBtnClass());
				assertEquals(buttons.get(0).getAttribute("text"), loanStatusPageObject.getProcessingBtn());
				logger.info("Processing button validated: " + (buttons.get(0).getAttribute("text")));
			} catch (Exception e) {
				logger.error("Processing button not found");
			}

			ScrollDown(0.1);

			// Loan History
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getLoanHistoryBtnId());
				assertEquals(buttons.get(0).getAttribute("text"), loanStatusPageObject.getLoanHistoryBtn());
				logger.info("Loan History button validated: " + (buttons.get(0).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Loan History button not found");
			}

			// Help
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getHelpBtnId());
				assertEquals(buttons.get(1).getAttribute("text"), loanStatusPageObject.getHelpBtn());
				logger.info("Help button validated: " + (buttons.get(1).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Help button not found");
			}
		}

		// Declined loan
		if (TestMode.equals("Declined")) {
			CustomWaitForElement(loanStatusPageObject.getLoanStatusTextId(), 30);

			// loan status
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusId()),
						loanStatusPageObject.getDeclinedStatus());
				logger.info("Loan Status validated: " + GetTextId(loanStatusPageObject.getLoanStatusId()));

			} catch (Exception e) {
				logger.error("Loan status not found");
			}

			// Status Message
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusTextId()),
						loanStatusPageObject.getDeclinedStatusText());
				logger.info("Status Message validated: " + GetTextId(loanStatusPageObject.getLoanStatusTextId()));

			} catch (Exception e) {
				logger.error("Status message not found");
			}

			// Loan Amount
			try {
				assertEquals(
						GetTextId(loanStatusPageObject.getCurrencyId())
								+ GetTextId(loanStatusPageObject.getLoanAmountId()),
						loanStatusPageObject.getNaira() + "7,000");
				logger.info("Loan Amount validated: " + GetTextId(loanStatusPageObject.getCurrencyId())
						+ GetTextId(loanStatusPageObject.getLoanAmountId()));

			} catch (Exception e) {
				logger.error("Loan amount not found");
			}

			// Application Date
			try {
				logger.info("Application Date: " + GetTextId(loanStatusPageObject.getDeclinedDateId()));

			} catch (Exception e) {
				logger.error("Application date not found");
			}

			// Retry Button
			try {
				assertEquals(GetTextId(loanStatusPageObject.getRetryBtnId()), loanStatusPageObject.getRetryBtn());
				logger.info("Retry button validated: " + GetTextId(loanStatusPageObject.getRetryBtnId()));
			} catch (Exception e) {
				logger.error("Retry button not found");
			}

			ScrollDown(0.1);

			// Help
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getLoanHistoryBtnId());
				assertEquals(buttons.get(0).getAttribute("text"), loanStatusPageObject.getHelpBtn());
				logger.info("Help button validated: " + (buttons.get(0).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Help button not found");
			}

			// Loan History
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getHelpBtnId());
				assertEquals(buttons.get(1).getAttribute("text"), loanStatusPageObject.getLoanHistoryBtn());
//				buttons.get(1).getCssValue("background-color")
				logger.info("Loan History button validated: " + (buttons.get(1).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Loan History button not found");
			}
		}

		// Approved loan
		if (TestMode.equals("Approved")) {
			CustomWaitForElement(loanStatusPageObject.getLoanStatusTextId(), 30);

			// loan status
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusId()),
						loanStatusPageObject.getApprovedStatus());
				logger.info("Loan Status: " + GetTextId(loanStatusPageObject.getLoanStatusId()));

			} catch (Exception e) {
				logger.error("Loan status not found");
			}

			// Status Message
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusTextId()),
						loanStatusPageObject.getApprovedStatusText());
				logger.info("Status Message: " + GetTextId(loanStatusPageObject.getLoanStatusTextId()));

			} catch (Exception e) {
				logger.error("Status message not found");
			}

			// Loan Amount
			try {
				assertEquals(
						GetTextId(loanStatusPageObject.getCurrencyId())
								+ GetTextId(loanStatusPageObject.getLoanAmountId()),
						loanStatusPageObject.getNaira() + "7,000");
				logger.info("Loan Amount: " + GetTextId(loanStatusPageObject.getCurrencyId())
						+ GetTextId(loanStatusPageObject.getLoanAmountId()));

			} catch (Exception e) {
				logger.error("Loan amount not found");
			}

			// Application Date
			try {
				logger.info("Application Date: " + GetTextId(loanStatusPageObject.getApprovedDateId()));

			} catch (Exception e) {
				logger.error("Application date not found");
			}

			// Setup Card Button
			if (AppVersion.equals("Version 3.2.0")) {
				try {
					assertEquals(GetTextId(loanStatusPageObject.getSetupCardBtnId()),
							loanStatusPageObject.getSetupCardBtn2());
					logger.info("Setup card button found: " + GetTextId(loanStatusPageObject.getSetupCardBtnId()));
				} catch (Exception e) {
					logger.error("Setup card button n ot found");
				}

			} else {
				try {
					assertEquals(GetTextId(loanStatusPageObject.getSetupCardBtnId()),
							loanStatusPageObject.getSetupCardBtn());
					logger.info("Setup card button found: " + GetTextId(loanStatusPageObject.getSetupCardBtnId()));
				} catch (Exception e) {
					logger.error("Setup card button n ot found");
				}
			}

			// Setup Fee
			try {
				List<AndroidElement> buttons = ElementsClass(loanStatusPageObject.getSetupFeeClass());
				assertEquals(buttons.get(8).getAttribute("text"), loanStatusPageObject.getSetupFee());
				logger.info("Setup card fee label found: " + (buttons.get(8).getAttribute("text")));
			} catch (Exception e) {
				logger.error("Setup card fee label not found");
			}

			ScrollDown(0.1);

			// How to Activate Card
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getLoanHistoryBtnId());
				assertEquals(buttons.get(0).getAttribute("text"), loanStatusPageObject.getHowToActivateCardBtn());
				logger.info("How to Activate Card button found: " + (buttons.get(0).getAttribute("text")));

			} catch (Exception e) {
				logger.error("How to Activate Card button not found");
			}

			// Know debit card
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getHelpBtnId());
				assertEquals(buttons.get(1).getAttribute("text"), loanStatusPageObject.getKnowDebitCardBtn());
				logger.info("Know debit card button found: " + (buttons.get(1).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Know debit card button not found");
			}

			// How Card Secure
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getHelpBtnId());
				assertEquals(buttons.get(2).getAttribute("text"), loanStatusPageObject.getHowSecureBtn());
				logger.info("How Card Secure button found: " + (buttons.get(2).getAttribute("text")));

			} catch (Exception e) {
				logger.error("How Card Secure button not found");
			}

			// Loan History
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getHelpBtnId());
				assertEquals(buttons.get(3).getAttribute("text"), loanStatusPageObject.getLoanHistoryBtn());
				logger.info("Loan history button found: " + (buttons.get(3).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Loan history button not found");
			}

		}

		// Disbursed Loan
		if (TestMode.equals("Disbursed")) {
			CustomWaitForElement(loanStatusPageObject.getLoanStatusTextId(), 30);

			// loan status
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusId()),
						loanStatusPageObject.getDisbursedStatus());
				logger.info("Loan Status: " + GetTextId(loanStatusPageObject.getLoanStatusId()));

			} catch (Exception e) {
				logger.error("Loan status not found");
			}

			// Status Message
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusTextId()),
						loanStatusPageObject.getDisbursedLoanText());
				logger.info("Status Message: " + GetTextId(loanStatusPageObject.getLoanStatusTextId()));

			} catch (Exception e) {
				logger.error("Status message not found");
			}

			// Loan Amount
			try {
				assertEquals(
						GetTextId(loanStatusPageObject.getCurrencyId())
								+ GetTextId(loanStatusPageObject.getLoanAmountId()),
						loanStatusPageObject.getNaira() + "12,500");
				logger.info("Loan Amount: " + GetTextId(loanStatusPageObject.getCurrencyId())
						+ GetTextId(loanStatusPageObject.getLoanAmountId()));

			} catch (Exception e) {
				logger.error("Loan amount not found");
			}

			// Application Date
			try {
				logger.info("Application Date: " + GetTextId(loanStatusPageObject.getAppliedDateId()));

			} catch (Exception e) {
				logger.error("Application date not found");
			}

			// Next Repayment Amount
			try {
				List<AndroidElement> amounts = ElementsId(loanStatusPageObject.getNextRepaymentAmountId());
				List<AndroidElement> currency = ElementsId(loanStatusPageObject.getCurrencyId());
				assertEquals(currency.get(1).getAttribute("text") + amounts.get(1).getAttribute("text"),
						loanStatusPageObject.getNaira() + "14,375");
				logger.info("Next Repayment Amount: " + currency.get(1).getAttribute("text")
						+ amounts.get(1).getAttribute("text"));
			} catch (Exception e) {

			}

			// Next Repayment Date
			try {
				logger.info("Next Repayment Date: " + GetTextId(loanStatusPageObject.getNextRepaymentDateId()));

			} catch (Exception e) {
				logger.error("Next Repayment date not found");
			}

			// Repayments Left
			try {
				logger.info("Repayments left: " + GetTextId(loanStatusPageObject.getRepaymentLeftId()));
			} catch (Exception e) {
				logger.error("Repayments left not found");
			}

			// Make Repayment Button
			try {
				assertEquals(GetTextId(loanStatusPageObject.getMakeRepaymentBtnId()),
						loanStatusPageObject.getMakeRepaymentBtn());
				logger.info(
						"Make a Repayment button found: " + GetTextId(loanStatusPageObject.getMakeRepaymentBtnId()));
			} catch (Exception e) {
				logger.error("Make a Repayment button not found");
			}

			// Share Referral Code Button
			try {
				assertEquals(GetTextId(loanStatusPageObject.getShareRefCodeBtnId()),
						loanStatusPageObject.getShareRefCodeBtn());
				logger.info(
						"Share Referral Code button found: " + GetTextId(loanStatusPageObject.getShareRefCodeBtnId()));
			} catch (Exception e) {
				logger.error("Share Referal Code button not found");
			}

			ScrollDown(0.1);

			// Repayment Benefits
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getLoanHistoryBtnId());
				assertEquals(buttons.get(0).getAttribute("text"), loanStatusPageObject.getRepaymentBenefitsBtn());
				logger.info("Repayment Benefits button found: " + (buttons.get(0).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Repaymet Benefits button not found");
			}

			// Loan History
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getHelpBtnId());
				assertEquals(buttons.get(1).getAttribute("text"), loanStatusPageObject.getLoanHistoryBtn());
				logger.info("Loan history button found: " + (buttons.get(1).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Loan history button not found");
			}

		}

		// Overdue
		if (TestMode.equals("Overdue") || TestMode.equals("LoanDetails")) {
			CustomWaitForElement(loanStatusPageObject.getLoanStatusTextId(), 30);

			// loan status
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusId()),
						loanStatusPageObject.getOverdueStatus());
				logger.info("Loan Status: " + GetTextId(loanStatusPageObject.getLoanStatusId()));

			} catch (Exception e) {
				logger.error("Loan status not found");
			}

			// Status Message
			try {
				assertEquals(GetTextId(loanStatusPageObject.getLoanStatusTextId()),
						loanStatusPageObject.getOverdueLoanText());
				logger.info("Status Message: " + GetTextId(loanStatusPageObject.getLoanStatusTextId()));

			} catch (Exception e) {
				logger.error("Status message not found");
			}

			// Loan Amount
			try {
				assertEquals(
						GetTextId(loanStatusPageObject.getCurrencyId())
								+ GetTextId(loanStatusPageObject.getLoanAmountId()),
						loanStatusPageObject.getNaira() + "7,500");
				logger.info("Loan Amount: " + GetTextId(loanStatusPageObject.getCurrencyId())
						+ GetTextId(loanStatusPageObject.getLoanAmountId()));

			} catch (Exception e) {
				logger.error("Loan amount not found");
			}

			// Application Date
			try {
				logger.info("Application Date: " + GetTextId(loanStatusPageObject.getAppliedDateId()));

			} catch (Exception e) {
				logger.error("Application date not found");
			}

			// Next Repayment Amount
			try {
				List<AndroidElement> amounts = ElementsId(loanStatusPageObject.getNextRepaymentAmountId());
				List<AndroidElement> currency = ElementsId(loanStatusPageObject.getCurrencyId());
				assertEquals(currency.get(1).getAttribute("text") + amounts.get(1).getAttribute("text"),
						loanStatusPageObject.getNaira() + "8,625");
				logger.info("Next Repayment Amount: " + currency.get(1).getAttribute("text")
						+ amounts.get(1).getAttribute("text"));
			} catch (Exception e) {

			}

			// Next Repayment Date
			try {
				logger.info("Next Repayment Date: " + GetTextId(loanStatusPageObject.getNextRepaymentDateId()));

			} catch (Exception e) {
				logger.error("Next Repayment date not found");
			}

			// Repayments Left
			try {
				logger.info("Repayments left: " + GetTextId(loanStatusPageObject.getRepaymentLeftId()));
			} catch (Exception e) {
				logger.error("Repayments left not found");
			}

			// Make Repayment Button
			try {
				assertEquals(GetTextId(loanStatusPageObject.getMakeRepaymentBtnId()),
						loanStatusPageObject.getMakeRepaymentBtn());
				logger.info(
						"Make a Repayment button found: " + GetTextId(loanStatusPageObject.getMakeRepaymentBtnId()));
			} catch (Exception e) {
				logger.error("Make a Repayment button not found");
			}

			ScrollDown(0.1);

			// Effects of Late Repayment
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getLoanHistoryBtnId());
				assertEquals(buttons.get(0).getAttribute("text"), loanStatusPageObject.getEffectOfLatePaymentBtn());
				logger.info("Effects of Late Repayment button found: " + (buttons.get(0).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Effects of Late Repayment button not found");
			}

			// Loan History
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getHelpBtnId());
				assertEquals(buttons.get(1).getAttribute("text"), loanStatusPageObject.getLoanHistoryBtn());
				logger.info("Loan history button found: " + (buttons.get(1).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Loan history button not found");
			}

		}

		// Paid loan
		if (TestMode.equals("Paid")) {
			CustomWaitForElement(loanStatusPageObject.getApplyBtnId(), 30);

			// Apply Button
			try {

				assertEquals(GetTextId(loanStatusPageObject.getApplyBtnId()), loanStatusPageObject.getApplyBtn());
				logger.info("Apply button found: " + GetTextId(loanStatusPageObject.getApplyBtnId()));

			} catch (Exception e) {
				logger.error("Apply button not found");
			}

			// Loan History
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getLoanHistoryBtnId());
				assertEquals(buttons.get(0).getAttribute("text"), loanStatusPageObject.getLoanHistoryBtn());
				logger.info("Loan History button found: " + (buttons.get(0).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Loan History button not found");
			}

			// Earn Points
			try {
				List<AndroidElement> buttons = ElementsId(loanStatusPageObject.getHelpBtnId());
				assertEquals(buttons.get(1).getAttribute("text"), loanStatusPageObject.getEarnPointsBtn());
				logger.info("Earn points & rewards button found: " + (buttons.get(1).getAttribute("text")));

			} catch (Exception e) {
				logger.error("Earn points & rewards button not found");
			}

		}

	}
}
