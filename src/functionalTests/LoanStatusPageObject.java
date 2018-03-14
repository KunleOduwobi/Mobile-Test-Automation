package functionalTests;

public class LoanStatusPageObject {

	public LoanStatusPageObject(){

	}

	
	private String PageTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String PageTitle = "Your loan";
	private String LoanStatusId = "com.lenddo.mobile.paylater:id/top_bar_title";
	private String PendingStatus = "Loan Pending";
	private String DeclinedStatus = "Loan Declined";
	private String ApprovedStatus = "Loan Approved";
	private String DisbursedStatus = "Loan Disbursed";
	private String OverdueStatus = "Repayment Overdue";
	private String NoLoanTextClass = "android.widget.Button"; //1
	private String NoLoanText = "You currently have no loan";
	private String WalletImageClass = "android.widget.ImageView"; //0
	private String LoanStatusTextId = "com.lenddo.mobile.paylater:id/bottom_bar_text";
	private String LoanStatusText = "Your application is currently being processed. You'll receive a loan decision shortly.";
	private String DeclinedStatusText = "Your application is unsuccessful at this time. However, we encourage you to keep the "
			+ "app installed and we'll notify once a loan offer becomes available.";
	private String ApprovedStatusText = "Congratulations! You're now just one step away from getting funds. "
			+ "Setup a personal debit/ATM card that will be used for your loan repayment.";
	private String DisbursedLoanText = "We hope this loan meets your needs. Please ensure you make repayments"
			+ " on time to maintain uninterrupted access to our service.";
	private String OverdueLoanText = "Your loan repayment is late. Please ensure you clear this as"
			+ " soon as possible. Make a full or partial repayment to maintain access to our service.";
	private String LoanAmountLabelClass = "android.widget.TextView";
	private String LoanAmountLabel = "Loan amount";
	private String CurrencyId = "com.lenddo.mobile.paylater:id/amount_view_currency";
	private String Naira = "₦";
	private String LoanAmountId = "com.lenddo.mobile.paylater:id/amount_view_amount";
	private String ApplicationDateLabelClass = "android.widget.TextView";
	private String ApplicationDateLabel = "Application date";
	private String ApplicationDateId = "com.lenddo.mobile.paylater:id/application_date";
	private String AppliedDateId = "com.lenddo.mobile.paylater:id/applied_date";
	private String DeclinedDateId = "com.lenddo.mobile.paylater:id/approved_date";
	private String ApprovedDateId = "com.lenddo.mobile.paylater:id/approved_date";
	private String NextRepaymentLabelClass = "android.widget.TextView";
	private String NextRepaymentLabel = "Next repayment";
	private String NextRepaymentAmountId = "com.lenddo.mobile.paylater:id/amount_view_amount"; //1
	private String NextRepaymentDateLabelId = "com.lenddo.mobile.paylater:id/next_apply_date_label";
	private String NextRepaymentDateLabel = "Next repayment date";
	private String RepaymentLeftId = "com.lenddo.mobile.paylater:id/repayments_text";
	private String ProcessingBtnClass = "android.widget.Button"; //0
	private String ProcessingBtn = "PROCESSING";
	private String ApplyBtnId = "com.lenddo.mobile.paylater:id/loans_header_action_button";
	private String ApplyBtn = "Apply for a loan";
	private String SetupCardBtnId = "com.lenddo.mobile.paylater:id/setup_card";
	private String SetupCardBtn = "SETUP DEBIT/ATM CARD";
	private String SetupCardBtn2 = "SETUP A DEBIT/ATM CARD";
	private String RetryBtnId = "com.lenddo.mobile.paylater:id/retry";
	private String RetryBtn = "RETRY";
	private String SetupFeeClass = "android.widget.TextView"; //7
	private String SetupFee = "Your card may be charged a one-time fee of N50.";
	private String NextRepaymentDateId = "com.lenddo.mobile.paylater:id/next_repayment_date";
	private String MakeRepaymentBtnId = "com.lenddo.mobile.paylater:id/make_repayment";
	private String MakeRepaymentBtn = "MAKE A REPAYMENT";
	private String ShareRefCodeBtnId = "com.lenddo.mobile.paylater:id/share_referral_code";
	private String ShareRefCodeBtn = "SHARE YOUR REFERRAL CODE";
	private String SubmitBtnId = "com.lenddo.mobile.paylater:id/loans_header_action_button";
	private String LoanHistoryBtnId = "com.lenddo.mobile.paylater:id/loan_list_status_title"; //0
	private String LoanHistoryBtn = "Loan history";
	private String HelpBtnId = "com.lenddo.mobile.paylater:id/loan_list_status_title"; //1 >Same as Earn Points button
	private String HelpBtn = "Help";
	private String EarnPointsBtn = "Earn points and rewards";
	private String HowToActivateCardBtn = "How do I activate my ATM card?";
	private String KnowDebitCardBtn = "Know your debit card";
	private String HowSecureBtn = "How secure are my card details?";
	private String RepaymentBenefitsBtn = "Repayment benefits";
	private String EffectOfLatePaymentBtn = "Effects of late repayment!";
	
	
	public String getPageTitle() {
		return PageTitle;
	}
	public String getPendingStatus() {
		return PendingStatus;
	}
	public String getLoanStatusTextId() {
		return LoanStatusTextId;
	}
	public String getLoanStatusText() {
		return LoanStatusText;
	}
	public String getLoanAmountLabelClass() {
		return LoanAmountLabelClass;
	}
	public String getLoanAmountLabel() {
		return LoanAmountLabel;
	}
	public String getCurrencyId() {
		return CurrencyId;
	}
	public String getNaira() {
		return Naira;
	}
	public String getApplicationDateLabelClass() {
		return ApplicationDateLabelClass;
	}
	public String getApplicationDateLabel() {
		return ApplicationDateLabel;
	}
	public String getProcessingBtnClass() {
		return ProcessingBtnClass;
	}
	public String getProcessingBtn() {
		return ProcessingBtn;
	}
	public String getLoanHistoryBtnId() {
		return LoanHistoryBtnId;
	}
	public String getLoanHistoryBtn() {
		return LoanHistoryBtn;
	}
	public String getHelpBtnId() {
		return HelpBtnId;
	}
	public String getHelpBtn() {
		return HelpBtn;
	}
	public String getPageTitleId() {
		return PageTitleId;
	}
	public void setPageTitleId(String pageTitleId) {
		PageTitleId = pageTitleId;
	}
	public String getLoanStatusId() {
		return LoanStatusId;
	}
	public void setLoanStatusId(String loanStatusId) {
		LoanStatusId = loanStatusId;
	}
	public String getLoanAmountId() {
		return LoanAmountId;
	}
	public void setLoanAmountId(String loanAmountId) {
		LoanAmountId = loanAmountId;
	}
	public String getApplicationDateId() {
		return ApplicationDateId;
	}
	public void setApplicationDateId(String applicationDateId) {
		ApplicationDateId = applicationDateId;
	}
	public String getNextRepaymentDateId() {
		return NextRepaymentDateId;
	}
	public void setNextRepaymentDateId(String nextRepaymentDateId) {
		NextRepaymentDateId = nextRepaymentDateId;
	}
	public String getSubmitBtnId() {
		return SubmitBtnId;
	}
	public void setSubmitBtnId(String submitBtnId) {
		SubmitBtnId = submitBtnId;
	}
	public String getNoLoanTextClass() {
		return NoLoanTextClass;
	}
	public String getNoLoanText() {
		return NoLoanText;
	}
	public String getWalletImageClass() {
		return WalletImageClass;
	}
	public String getApplyBtnId() {
		return ApplyBtnId;
	}
	public String getApplyBtn() {
		return ApplyBtn;
	}
	public String getEarnPointsBtn() {
		return EarnPointsBtn;
	}
	public String getDeclinedStatus() {
		return DeclinedStatus;
	}
	public String getDeclinedStatusText() {
		return DeclinedStatusText;
	}
	public String getDeclinedDateId() {
		return DeclinedDateId;
	}
	public String getRetryBtnId() {
		return RetryBtnId;
	}
	public String getRetryBtn() {
		return RetryBtn;
	}
	public String getApprovedStatus() {
		return ApprovedStatus;
	}
	public String getApprovedStatusText() {
		return ApprovedStatusText;
	}
	public String getApprovedDateId() {
		return ApprovedDateId;
	}
	public String getSetupCardBtnId() {
		return SetupCardBtnId;
	}
	public String getSetupCardBtn() {
		return SetupCardBtn;
	}
	public String getSetupFeeClass() {
		return SetupFeeClass;
	}
	public String getHowToActivateCardBtn() {
		return HowToActivateCardBtn;
	}
	public String getKnowDebitCardBtn() {
		return KnowDebitCardBtn;
	}
	public String getHowSecureBtn() {
		return HowSecureBtn;
	}
	public String getSetupFee() {
		return SetupFee;
	}
	public String getDisbursedStatus() {
		return DisbursedStatus;
	}
	public String getNextRepaymentLabelClass() {
		return NextRepaymentLabelClass;
	}
	public String getNextRepaymentLabel() {
		return NextRepaymentLabel;
	}
	public String getNextRepaymentAmountId() {
		return NextRepaymentAmountId;
	}
	public String getNextRepaymentDateLabelId() {
		return NextRepaymentDateLabelId;
	}
	public String getNextRepaymentDateLabel() {
		return NextRepaymentDateLabel;
	}
	public String getRepaymentLeftId() {
		return RepaymentLeftId;
	}
	public String getDisbursedLoanText() {
		return DisbursedLoanText;
	}
	public String getMakeRepaymentBtnId() {
		return MakeRepaymentBtnId;
	}
	public String getMakeRepaymentBtn() {
		return MakeRepaymentBtn;
	}
	public String getShareRefCodeBtnId() {
		return ShareRefCodeBtnId;
	}
	public String getShareRefCodeBtn() {
		return ShareRefCodeBtn;
	}
	public String getRepaymentBenefitsBtn() {
		return RepaymentBenefitsBtn;
	}
	public String getAppliedDateId() {
		return AppliedDateId;
	}
	public String getEffectOfLatePaymentBtn() {
		return EffectOfLatePaymentBtn;
	}
	public String getOverdueStatus() {
		return OverdueStatus;
	}
	public String getOverdueLoanText() {
		return OverdueLoanText;
	}
	public String getSetupCardBtn2() {
		return SetupCardBtn2;
	}

}
