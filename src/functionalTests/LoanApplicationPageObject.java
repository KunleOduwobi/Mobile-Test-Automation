package functionalTests;

import java.security.KeyStore.PrivateKeyEntry;

public class LoanApplicationPageObject {

	public LoanApplicationPageObject() {

	}

	// Loan Status
	private String PageTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String LoanStatusClass = "android.widget.TextView";
	private String LoanStatusId = "com.lenddo.mobile.paylater:id/top_bar_title";
	private String ApplyButtonId = "com.lenddo.mobile.paylater:id/loans_header_action_button";
	private String ApplyButtonId2 = "com.lenddo.mobile.paylater:id/apply_loans_button";
	private String RetryBtnId = "com.lenddo.mobile.paylater:id/retry";
	private String LoanHistoryButtonId = "com.lenddo.mobile.paylater:id/loan_list_status_title";
	private String LoanStatusListItems = "com.lenddo.mobile.paylater:id/recycler_view";
	private String ButtonsClass = "android.widget.Button";
	
	

	private String LoanHistoryButtonClass = "android.widget.RelativeLayout";
	private String EarnPointsButtonId = "com.lenddo.mobile.paylater:id/loan_list_status_title";
	private String LoanHistoryButtonIds = "com.lenddo.mobile.paylater:id/loan_list_status_title";

public String getLoanHistoryButtonIds() {
		return LoanHistoryButtonIds;
	}

	public void setLoanHistoryButtonIds(String loanHistoryButtonIds) {
		LoanHistoryButtonIds = loanHistoryButtonIds;
	}

	public void setLoanStatusListItems(String loanStatusListItems) {
		LoanStatusListItems = loanStatusListItems;
	}

	public void setLoanHistoryTitleId(String loanHistoryTitleId) {
		LoanHistoryTitleId = loanHistoryTitleId;
	}

	public void setLoanHistoryViewMore(String loanHistoryViewMore) {
		LoanHistoryViewMore = loanHistoryViewMore;
	}

	public void setLoanHistoryLoanItem(String loanHistoryLoanItem) {
		LoanHistoryLoanItem = loanHistoryLoanItem;
	}

	//	Personal Information
	private String PersonalInformationTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String PersonalInformationFirstNameId = "com.lenddo.mobile.paylater:id/user_info_personal_first_name";
	private String PersonalInformationFirstName = "Femi";
	private String PersonalInformationLastNameId = "com.lenddo.mobile.paylater:id/user_info_personal_last_name";
	private String PersonalInformationLastName = "Bankole";
	private String PersonalInformationDobId = "com.lenddo.mobile.paylater:id/user_info_personal_birthday";
	private String PersonalInformationDobClass = "android.widget.EditText";
	private String PersonalInformationDobDay = "04";
	private String PersonalInformationDobMonth = "Aug";
	private String PersonalInformationDobYear = "1989";
	private String PersonalInformationCalenderSubmitBtnId = "android:id/button1";
	private String PersonalInformationMaleGenderId = "com.lenddo.mobile.paylater:id/user_info_personal_gender_male";
	private String PersonalInformationFemaleGenderId = "com.lenddo.mobile.paylater:id/user_info_personal_gender_female";
	private String PersonalInformationEmailId = "com.lenddo.mobile.paylater:id/user_info_personal_email";
	private String PersonalInformationEmail = "femi@bankole.com.ng";
	private String PersonalInformationMariatalStatusClass = "android.widget.TextView";
	private String PersonalInformationMariatalStatus = "Married";
	private String PersonalInformationSpouseId = "com.lenddo.mobile.paylater:id/user_info_personal_name_of_spouse";
	private String PersonalInformationSpouse = "Chima";
	private String PersonalInformationChildrenClass = "android.widget.TextView";
	private String PersonalInformationChildren = "1";
	private String PersonalInformationNextBtnId = "com.lenddo.mobile.paylater:id/user_info_personal_next";

//	Education & Employment
	private String EducationTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String EducationLevelClass = "android.widget.TextView";
	private String EducationLevel = "Graduate";
	private String EmployemtStatusClass = "android.widget.TextView";
	private String EmploymentStatus = "Employed";
	private String EmployerId = "com.lenddo.mobile.paylater:id/user_info_education_business_name";
	private String Employer = "One Finance and Investments Ltd";
	private String EmploymentDateId = "com.lenddo.mobile.paylater:id/user_info_education_business_start";
	private String EmploymentDateCalendarClass = "android.widget.EditText";
	private String EmploymentDay = "04";
	private String EmploymentMonth = "Aug";
	private String EmploymentYear = "2009";
	private String EmploymentCalenderSubmitBtnId = "android:id/button1";
	private String EmploymentIncomeId = "com.lenddo.mobile.paylater:id/user_info_education_monthly_income";
	private String EmploymentIncome = "350000";
	private String SourceOfIncomeId = "com.lenddo.mobile.paylater:id/user_info_education_source_income";
	private String SourceOfIncome = "Landed property";
	private String EducationNextBtnId = "com.lenddo.mobile.paylater:id/user_info_education_next";
	private String MonthlyIncomeErrorId = "com.lenddo.mobile.paylater:id/textinput_error";
	private String MonthlyIncomeError = "You do not meet the minimum monthly income requirements to qualify for a Paylater loan";

//	Address Details
	private String AddressTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String ResidenceTypeClass = "android.widget.TextView";
	private String ResidenceType = "Rented";
	private String CurrentAddressId = "com.lenddo.mobile.paylater:id/user_info_address_address";
	private String CurrentAddress = "Plot 1224 Bishop Oluwole Street, Victoria Island";
	private String StateClass = "android.widget.TextView";
	private String State = "LAGOS";
	private String LgaClass = "android.widget.TextView";
	private String Lga = "LAGOS ISLAND";
	private String TownId = "com.lenddo.mobile.paylater:id/user_info_address_town";
	private String LandmarkId = "com.lenddo.mobile.paylater:id/user_info_address_landmark";
	private String RentId = "com.lenddo.mobile.paylater:id/user_info_address_residence_rent";
	private String Rent = "650000";
	private String AddressDurationYearClass = "android.widget.TextView";
	private String AddressDurationYearDefault = "Year";
	private String AddressDurationYear = "5";
	private String AddressDurationMonthClass = "android.widget.TextView";
	private String AddressDurationMonthDefault = "Month";
	private String AddressDurationMonth = "2";
	private String AddressDetailsNextBtnId = "com.lenddo.mobile.paylater:id/user_info_address_next";



	// Edit Details Dialog
	private String EditDetailsTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String EditDetailsTextId = "com.lenddo.mobile.paylater:id/edit_details_dialog_info_text";
	private String EditDetailsButtonId = "com.lenddo.mobile.paylater:id/edit_details_edit_button";
	private String EditDetailsContinueId = "com.lenddo.mobile.paylater:id/edit_details_continue_button";

	// Loan Details
	private String LoanDetailsTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String RequestedAmountId = "com.lenddo.mobile.paylater:id/more_amount";
	private String RequestedAmount = "500000";
	private String LoanReasonId = "com.lenddo.mobile.paylater:id/pop_up";
	private String LoanDetailsSubmitButtonId = "com.lenddo.mobile.paylater:id/continue_flow";
	private String LoanReasonItemClass = "android.widget.CheckBox";
	private String LoanReasonOkButton = "com.lenddo.mobile.paylater:id/accept";

	// Bank Details
	private String BankDetailsPageTitileId = "com.lenddo.mobile.paylater:id/title_text";
	private String BankNameMenuClass = "android.widget.TextView";
	private String MobileMoneyProviderid = "com.lenddo.mobile.paylater:id/placeholder";
	private String Bank = "Diamond Bank";
	private String AccountNumberId = "com.lenddo.mobile.paylater:id/user_info_bank_account_number";
	private String MobileMoneyAccountId = "com.lenddo.mobile.paylater:id/mobile_money_account";
	private String AccountNumber = "0074135562";
	private String BVNId = "com.lenddo.mobile.paylater:id/user_info_bank_verify_number";
	private String BVN = "20160514524";
	private String BankDetailsSubmitId = "com.lenddo.mobile.paylater:id/user_info_bank_next";
	private String MobileMoneyDetailsSubmitId = "com.lenddo.mobile.paylater:id/continue_flow";
	private String BankErrorTitleId = "android:id/alertTitle";
	private String BankErrorTitle = "Error";
	private String BankErrorMsgId = "android:id/message";
	private String EmailError = "The specified e-mail is registered to another user.";
	private String BVNError = "BVN belongs to another user.";
	private String BankErrorOkId = "android:id/button1";

	// Loan Offer
	private String LoanOfferStatusTitleId = "com.lenddo.mobile.paylater:id/textView";
	private String LoanOfferStatusMessageId = "com.lenddo.mobile.paylater:id/progress_status_text";
	private String LoanOfferReadyTitleId = "com.lenddo.mobile.paylater:id/title";
	private String LoanOfferReadyMessageId = "com.lenddo.mobile.paylater:id/message";
	private String LoanOfferReadySubmitId = "com.lenddo.mobile.paylater:id/got_it";

	// Select Loan Details
	private String SelectLoanDetailsPageTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String AvailableOfferAmountId = "com.lenddo.mobile.paylater:id/in_app_notification_message";
	private String SelectedAmountId = "com.lenddo.mobile.paylater:id/amountText";
	private String AvailableOfferTenureClass = "android.widget.RadioButton";
	private String AnotherAmount = "₦ 53,000";
	private String AmountListClass = "android.widget.RelativeLayout";
	private String InterestRateId = "com.lenddo.mobile.paylater:id/interestText";
	private String InterestAmountId = "com.lenddo.mobile.paylater:id/apply_loan_info_fee";
	private String RepaymentAmountId = "com.lenddo.mobile.paylater:id/amount_view_amount";
	private String SelectLoanDetailsApplyButtonId = "com.lenddo.mobile.paylater:id/apply_loan_info_next";

	// Required Information
	private String RequiredInfoTitleClass = "android.widget.TextView";
	private String RequiredInfoCloseBtnId = "com.lenddo.mobile.paylater:id/dialog_close";
	private String RequiredInfoSelfieId = "com.lenddo.mobile.paylater:id/selfie_text";
	private String RequiredInfoGovtId = "com.lenddo.mobile.paylater:id/gov_id";
	private String RequiredInfoAcceptId = "com.lenddo.mobile.paylater:id/accept";
	private String RequiredInfoDeclineId = "com.lenddo.mobile.paylater:id/decline";

//	Valid Identification
	private String ValidIdTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String ValidIdMenuPlaceholderId = "com.lenddo.mobile.paylater:id/placeholder";
	private String ValidIdMenuClass = "android.widget.RelativeLayout";
	private String IdType1 = "Voters Identity Card";
	private String IdType2 = "Driver Licence";
	private String ValidIdNumberId = "com.lenddo.mobile.paylater:id/id_number";
	private String VotersCardNumber = "12345";
	private String DriversLicence = "AOrgf633";
	private String ValidCardExpiryDateId = "com.lenddo.mobile.paylater:id/expiry_date";
	private String ExpiryClass = "android.widget.EditText";
	private String CalenderSubmitBtnId = "android:id/button1";
	private String ValidCardSubmitId = "com.lenddo.mobile.paylater:id/continue_flow";
	private String ValidCardCancelId = "com.lenddo.mobile.paylater:id/cancel_flow";

//	Loan Summary
	private String LoanSummaryTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String LoanSummaryAmountId = "com.lenddo.mobile.paylater:id/amount_view_amount";
	private String LoanSummaryInterestId = "com.lenddo.mobile.paylater:id/amount_view_amount";
	private String LoanSummaryDiscountId = "com.lenddo.mobile.paylater:id/discount_info_text";
	private String LoanSUmmaryDiscountBtnId = "com.lenddo.mobile.paylater:id/discount_button";
	private String LoanSummaryRepaymentId = "com.lenddo.mobile.paylater:id/discount_button";
	private String LoanSummaryTenureId = "com.lenddo.mobile.paylater:id/loan_spread";
	private String LoanSummaryApplyBtnId = "com.lenddo.mobile.paylater:id/take_loan_info_next";
	private String LoanSummaryTextClass = "android.widget.TextView";
	private String LocationInfoId = "com.lenddo.mobile.paylater:id/take_loan_info_location_resolution_clickable";
	private String LocationInfoTitleId = "com.lenddo.mobile.paylater:id/paylater_plus_dialog_title";
	private String LocationInfoSubmitBtnId = "com.lenddo.mobile.paylater:id/paylater_plus_dialog_positive";

//	Confirmation
	private String ConfirmationTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String ConfirmationPaymentsClass = "android.widget.LinearLayout";
	private String ConfirmationPaymentNumberId = "com.lenddo.mobile.paylater:id/application_confirmation_item_number";
	private String ConfirmationPayDatesId = "com.lenddo.mobile.paylater:id/application_confirmation_item_date";
	private String ConfirmationPaymentsId = "com.lenddo.mobile.paylater:id/application_confirmation_item_amount";
	private String ConfirmationSubmitId = "com.lenddo.mobile.paylater:id/application_confirmation_agree";

//	PIN Confirmation
	private String PINConfirmTextId = "com.lenddo.mobile.paylater:id/micro_text";
	private String PINConfirmInputId = "com.lenddo.mobile.paylater:id/edit_pin_placeholder1";
	private String PIN = "1234";
	private String ApplicationErrorId = "android:id/message";
	private String PINError = "Your PIN is incorrect";
	private String LocationErrorId = "com.google.android.gms:id/message";
	private String LocationError = "To continue, let your device turn on location, which uses Google’s location service ";
	private String PINDoneId = "com.lenddo.mobile.paylater:id/pin_done";

//	Application Submitted
	private String ApplicationSubmittedTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String ApplicationSubmittedTextId = "com.lenddo.mobile.paylater:id/fontTextView11";
	private String TellAFriendBtnId ="com.lenddo.mobile.paylater:id/share_referral_code";
	private String MaybeLaterBtnId = "com.lenddo.mobile.paylater:id/maybe_later";

	// Loan History PageTitleId
	private String LoanHistoryTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String LoanHistoryViewMore = "com.lenddo.mobile.paylater:id/view_more";
	private String LoanHistoryLoanItem = "com.lenddo.mobile.paylater:id/top_bar";

	public String getLoanStatusListItems() {
		return LoanStatusListItems;
	}

	public String getLoanHistoryTitleId() {
		return LoanHistoryTitleId;
	}

	public String getLoanHistoryViewMore() {
		return LoanHistoryViewMore;
	}

	public String getLoanHistoryLoanItem() {
		return LoanHistoryLoanItem;
	}

	public String getPageTitleId() {
		return PageTitleId;
	}

	public void setPageTitleId(String pageTitleId) {
		PageTitleId = pageTitleId;
	}

	public String getLoanStatusClass() {
		return LoanStatusClass;
	}

	public void setLoanStatusClass(String loanStatusClass) {
		LoanStatusClass = loanStatusClass;
	}

	public String getLoanStatusId() {
		return LoanStatusId;
	}

	public void setLoanStatusId(String loanStatusId) {
		LoanStatusId = loanStatusId;
	}

	public String getRetryBtnId() {
		return RetryBtnId;
	}

	public void setRetryBtnId(String retryBtnId) {
		RetryBtnId = retryBtnId;
	}

	public String getApplyButtonId() {
		return ApplyButtonId;
	}

	public void setApplyButtonId(String applyButtonId) {
		ApplyButtonId = applyButtonId;
	}

	public String getLoanHistoryButtonId() {
		return LoanHistoryButtonId;
	}

	public void setLoanHistoryButtonId(String loanHistoryButtonId) {
		LoanHistoryButtonId = loanHistoryButtonId;
	}

	public String getLoanHistoryButtonClass() {
		return LoanHistoryButtonClass;
	}

	public void setLoanHistoryButtonClass(String loanHistoryButtonClass) {
		LoanHistoryButtonClass = loanHistoryButtonClass;
	}

	public String getEarnPointsButtonId() {
		return EarnPointsButtonId;
	}

	public void setEarnPointsButtonId(String earnPointsButtonId) {
		EarnPointsButtonId = earnPointsButtonId;
	}

	public String getPersonalInformationTitleId() {
		return PersonalInformationTitleId;
	}

	public void setPersonalInformationTitleId(String personalInformationTitleId) {
		PersonalInformationTitleId = personalInformationTitleId;
	}

	public String getPersonalInformationFirstNameId() {
		return PersonalInformationFirstNameId;
	}

	public void setPersonalInformationFirstNameId(
			String personalInformationFirstNameId) {
		PersonalInformationFirstNameId = personalInformationFirstNameId;
	}

	public String getPersonalInformationFirstName() {
		return PersonalInformationFirstName;
	}

	public void setPersonalInformationFirstName(String personalInformationFirstName) {
		PersonalInformationFirstName = personalInformationFirstName;
	}

	public String getPersonalInformationLastNameId() {
		return PersonalInformationLastNameId;
	}

	public void setPersonalInformationLastNameId(
			String personalInformationLastNameId) {
		PersonalInformationLastNameId = personalInformationLastNameId;
	}

	public String getPersonalInformationLastName() {
		return PersonalInformationLastName;
	}

	public void setPersonalInformationLastName(String personalInformationLastName) {
		PersonalInformationLastName = personalInformationLastName;
	}

	public String getPersonalInformationDobId() {
		return PersonalInformationDobId;
	}

	public void setPersonalInformationDobId(String personalInformationDobId) {
		PersonalInformationDobId = personalInformationDobId;
	}

	public String getPersonalInformationDobClass() {
		return PersonalInformationDobClass;
	}

	public String getPersonalInformationDobDay() {
		return PersonalInformationDobDay;
	}

	public void setPersonalInformationDobDay(String personalInformationDobDay) {
		PersonalInformationDobDay = personalInformationDobDay;
	}

	public String getPersonalInformationDobMonth() {
		return PersonalInformationDobMonth;
	}

	public void setPersonalInformationDobMonth(String personalInformationDobMonth) {
		PersonalInformationDobMonth = personalInformationDobMonth;
	}

	public String getPersonalInformationDobYear() {
		return PersonalInformationDobYear;
	}

	public void setPersonalInformationDobYear(String personalInformationDobYear) {
		PersonalInformationDobYear = personalInformationDobYear;
	}

	public String getPersonalInformationCalenderSubmitBtnId() {
		return PersonalInformationCalenderSubmitBtnId;
	}

	public void setPersonalInformationCalenderSubmitBtnId(
			String personalInformationCalenderSubmitBtnId) {
		PersonalInformationCalenderSubmitBtnId = personalInformationCalenderSubmitBtnId;
	}

	public void setPersonalInformationDobClass(String personalInformationDobClass) {
		PersonalInformationDobClass = personalInformationDobClass;
	}

	public String getPersonalInformationMaleGenderId() {
		return PersonalInformationMaleGenderId;
	}

	public void setPersonalInformationMaleGenderId(
			String personalInformationMaleGenderId) {
		PersonalInformationMaleGenderId = personalInformationMaleGenderId;
	}

	public String getPersonalInformationFemaleGenderId() {
		return PersonalInformationFemaleGenderId;
	}

	public void setPersonalInformationFemaleGenderId(
			String personalInformationFemaleGenderId) {
		PersonalInformationFemaleGenderId = personalInformationFemaleGenderId;
	}

	public String getPersonalInformationEmailId() {
		return PersonalInformationEmailId;
	}

	public void setPersonalInformationEmailId(String personalInformationEmailId) {
		PersonalInformationEmailId = personalInformationEmailId;
	}

	public String getPersonalInformationEmail() {
		return PersonalInformationEmail;
	}

	public void setPersonalInformationEmail(String personalInformationEmail) {
		PersonalInformationEmail = personalInformationEmail;
	}

	public String getPersonalInformationMariatalStatusClass() {
		return PersonalInformationMariatalStatusClass;
	}

	public void setPersonalInformationMariatalStatusClass(
			String personalInformationMariatalStatusClass) {
		PersonalInformationMariatalStatusClass = personalInformationMariatalStatusClass;
	}

	public String getPersonalInformationMariatalStatus() {
		return PersonalInformationMariatalStatus;
	}

	public void setPersonalInformationMariatalStatus(
			String personalInformationMariatalStatus) {
		PersonalInformationMariatalStatus = personalInformationMariatalStatus;
	}

	public String getPersonalInformationSpouseId() {
		return PersonalInformationSpouseId;
	}

	public void setPersonalInformationSpouseId(String personalInformationSpouseId) {
		PersonalInformationSpouseId = personalInformationSpouseId;
	}

	public String getPersonalInformationSpouse() {
		return PersonalInformationSpouse;
	}

	public void setPersonalInformationSpouse(String personalInformationSpouse) {
		PersonalInformationSpouse = personalInformationSpouse;
	}

	public String getPersonalInformationChildrenClass() {
		return PersonalInformationChildrenClass;
	}

	public void setPersonalInformationChildrenClass(
			String personalInformationChildrenClass) {
		PersonalInformationChildrenClass = personalInformationChildrenClass;
	}

	public String getPersonalInformationChildren() {
		return PersonalInformationChildren;
	}

	public void setPersonalInformationChildren(String personalInformationChildren) {
		PersonalInformationChildren = personalInformationChildren;
	}

	public String getPersonalInformationNextBtnId() {
		return PersonalInformationNextBtnId;
	}

	public void setPersonalInformationNextBtnId(String personalInformationNextBtnId) {
		PersonalInformationNextBtnId = personalInformationNextBtnId;
	}

	public String getEducationTitleId() {
		return EducationTitleId;
	}

	public void setEducationTitleId(String educationTitleId) {
		EducationTitleId = educationTitleId;
	}

	public String getEducationLevelClass() {
		return EducationLevelClass;
	}

	public void setEducationLevelClass(String educationLevelClass) {
		EducationLevelClass = educationLevelClass;
	}

	public String getEducationLevel() {
		return EducationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		EducationLevel = educationLevel;
	}

	public String getEmployemtStatusClass() {
		return EmployemtStatusClass;
	}

	public void setEmployemtStatusClass(String employemtStatusClass) {
		EmployemtStatusClass = employemtStatusClass;
	}

	public String getEmploymentStatus() {
		return EmploymentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		EmploymentStatus = employmentStatus;
	}

	public String getEmployerId() {
		return EmployerId;
	}

	public void setEmployerId(String employerId) {
		EmployerId = employerId;
	}

	public String getEmployer() {
		return Employer;
	}

	public void setEmployer(String employer) {
		Employer = employer;
	}

	public String getEmploymentDateId() {
		return EmploymentDateId;
	}

	public void setEmploymentDateId(String employmentDateId) {
		EmploymentDateId = employmentDateId;
	}

	public String getEmploymentDateCalendarClass() {
		return EmploymentDateCalendarClass;
	}

	public void setEmploymentDateCalendarClass(String employmentDateCalendarClass) {
		EmploymentDateCalendarClass = employmentDateCalendarClass;
	}

	public String getEmploymentDay() {
		return EmploymentDay;
	}

	public void setEmploymentDay(String employmentDay) {
		EmploymentDay = employmentDay;
	}

	public String getEmploymentMonth() {
		return EmploymentMonth;
	}

	public void setEmploymentMonth(String employmentMonth) {
		EmploymentMonth = employmentMonth;
	}

	public String getEmploymentYear() {
		return EmploymentYear;
	}

	public void setEmploymentYear(String employmentYear) {
		EmploymentYear = employmentYear;
	}

	public String getEmploymentCalenderSubmitBtnId() {
		return EmploymentCalenderSubmitBtnId;
	}

	public void setEmploymentCalenderSubmitBtnId(
			String employmentCalenderSubmitBtnId) {
		EmploymentCalenderSubmitBtnId = employmentCalenderSubmitBtnId;
	}

	public String getEmploymentIncomeId() {
		return EmploymentIncomeId;
	}

	public void setEmploymentIncomeId(String employmentIncomeId) {
		EmploymentIncomeId = employmentIncomeId;
	}

	public String getEmploymentIncome() {
		return EmploymentIncome;
	}

	public void setEmploymentIncome(String employmentIncome) {
		EmploymentIncome = employmentIncome;
	}

	public String getSourceOfIncomeId() {
		return SourceOfIncomeId;
	}

	public void setSourceOfIncomeId(String sourceOfIncomeId) {
		SourceOfIncomeId = sourceOfIncomeId;
	}

	public String getSourceOfIncome() {
		return SourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		SourceOfIncome = sourceOfIncome;
	}

	public String getEducationNextBtnId() {
		return EducationNextBtnId;
	}

	public void setEducationNextBtnId(String educationNextBtnId) {
		EducationNextBtnId = educationNextBtnId;
	}

	public String getAddressTitleId() {
		return AddressTitleId;
	}

	public void setAddressTitleId(String addressTitleId) {
		AddressTitleId = addressTitleId;
	}

	public String getResidenceTypeClass() {
		return ResidenceTypeClass;
	}

	public void setResidenceTypeClass(String residenceTypeClass) {
		ResidenceTypeClass = residenceTypeClass;
	}

	public String getResidenceType() {
		return ResidenceType;
	}

	public void setResidenceType(String residenceType) {
		ResidenceType = residenceType;
	}

	public String getCurrentAddressId() {
		return CurrentAddressId;
	}

	public void setCurrentAddressId(String currentAddressId) {
		CurrentAddressId = currentAddressId;
	}

	public String getCurrentAddress() {
		return CurrentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		CurrentAddress = currentAddress;
	}

	public String getStateClass() {
		return StateClass;
	}

	public void setStateClass(String stateClass) {
		StateClass = stateClass;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getLgaClass() {
		return LgaClass;
	}

	public void setLgaClass(String lgaClass) {
		LgaClass = lgaClass;
	}

	public String getLga() {
		return Lga;
	}

	public void setLga(String lga) {
		Lga = lga;
	}

	public String getRentId() {
		return RentId;
	}

	public void setRentId(String rentId) {
		RentId = rentId;
	}

	public String getRent() {
		return Rent;
	}

	public void setRent(String rent) {
		Rent = rent;
	}

	public String getAddressDurationYearClass() {
		return AddressDurationYearClass;
	}

	public void setAddressDurationYearClass(String addressDurationYearClass) {
		AddressDurationYearClass = addressDurationYearClass;
	}

	public String getAddressDurationYearDefault() {
		return AddressDurationYearDefault;
	}

	public void setAddressDurationYearDefault(String addressDurationYearDefault) {
		AddressDurationYearDefault = addressDurationYearDefault;
	}

	public String getAddressDurationYear() {
		return AddressDurationYear;
	}

	public void setAddressDurationYear(String addressDurationYear) {
		AddressDurationYear = addressDurationYear;
	}

	public String getAddressDurationMonthClass() {
		return AddressDurationMonthClass;
	}

	public void setAddressDurationMonthClass(String addressDurationMonthClass) {
		AddressDurationMonthClass = addressDurationMonthClass;
	}

	public String getAddressDurationMonthDefault() {
		return AddressDurationMonthDefault;
	}

	public void setAddressDurationMonthDefault(String addressDurationMonthDefault) {
		AddressDurationMonthDefault = addressDurationMonthDefault;
	}

	public String getAddressDurationMonth() {
		return AddressDurationMonth;
	}

	public void setAddressDurationMonth(String addressDurationMonth) {
		AddressDurationMonth = addressDurationMonth;
	}

	public String getAddressDetailsNextBtnId() {
		return AddressDetailsNextBtnId;
	}

	public void setAddressDetailsNextBtnId(String addressDetailsNextBtnId) {
		AddressDetailsNextBtnId = addressDetailsNextBtnId;
	}

	public String getEditDetailsTitleId() {
		return EditDetailsTitleId;
	}

	public void setEditDetailsTitleId(String editDetailsTitleId) {
		EditDetailsTitleId = editDetailsTitleId;
	}

	public String getEditDetailsTextId() {
		return EditDetailsTextId;
	}

	public void setEditDetailsTextId(String editDetailsTextId) {
		EditDetailsTextId = editDetailsTextId;
	}

	public String getEditDetailsButtonId() {
		return EditDetailsButtonId;
	}

	public void setEditDetailsButtonId(String editDetailsButtonId) {
		EditDetailsButtonId = editDetailsButtonId;
	}

	public String getEditDetailsContinueId() {
		return EditDetailsContinueId;
	}

	public void setEditDetailsContinueId(String editDetailsContinueId) {
		EditDetailsContinueId = editDetailsContinueId;
	}

	public String getLoanDetailsTitleId() {
		return LoanDetailsTitleId;
	}

	public void setLoanDetailsTitleId(String loanDetailsTitleId) {
		LoanDetailsTitleId = loanDetailsTitleId;
	}

	public String getRequestedAmountId() {
		return RequestedAmountId;
	}

	public void setRequestedAmountId(String requestedAmountId) {
		RequestedAmountId = requestedAmountId;
	}

	public String getRequestedAmount() {
		return RequestedAmount;
	}

	public void setRequestedAmount(String requestedAmount) {
		RequestedAmount = requestedAmount;
	}

	public String getLoanReasonId() {
		return LoanReasonId;
	}

	public void setLoanReasonId(String loanReasonId) {
		LoanReasonId = loanReasonId;
	}

	public String getLoanDetailsSubmitButtonId() {
		return LoanDetailsSubmitButtonId;
	}

	public void setLoanDetailsSubmitButtonId(String loanDetailsSubmitButtonId) {
		LoanDetailsSubmitButtonId = loanDetailsSubmitButtonId;
	}

	public String getLoanReasonItemClass() {
		return LoanReasonItemClass;
	}

	public void setLoanReasonItemClass(String loanReasonItemClass) {
		LoanReasonItemClass = loanReasonItemClass;
	}

	public String getLoanReasonOkButton() {
		return LoanReasonOkButton;
	}

	public void setLoanReasonOkButton(String loanReasonOkButton) {
		LoanReasonOkButton = loanReasonOkButton;
	}

	public String getBankDetailsPageTitileId() {
		return BankDetailsPageTitileId;
	}

	public void setBankDetailsPageTitileId(String bankDetailsPageTitileId) {
		BankDetailsPageTitileId = bankDetailsPageTitileId;
	}

	public String getBankNameMenuClass() {
		return BankNameMenuClass;
	}

	public void setBankNameMenuClass(String bankNameMenuClass) {
		BankNameMenuClass = bankNameMenuClass;
	}

	public String getBank() {
		return Bank;
	}

	public void setBank(String bank) {
		Bank = bank;
	}

	public String getAccountNumberId() {
		return AccountNumberId;
	}

	public void setAccountNumberId(String accountNumberId) {
		AccountNumberId = accountNumberId;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getBVNId() {
		return BVNId;
	}

	public void setBVNId(String bVNId) {
		BVNId = bVNId;
	}

	public String getBVN() {
		return BVN;
	}

	public void setBVN(String bVN) {
		BVN = bVN;
	}

	public String getBankDetailsSubmitId() {
		return BankDetailsSubmitId;
	}

	public void setBankDetailsSubmitId(String bankDetailsSubmitId) {
		BankDetailsSubmitId = bankDetailsSubmitId;
	}

	public String getLoanOfferStatusTitleId() {
		return LoanOfferStatusTitleId;
	}

	public void setLoanOfferStatusTitleId(String loanOfferStatusTitleId) {
		LoanOfferStatusTitleId = loanOfferStatusTitleId;
	}

	public String getLoanOfferStatusMessageId() {
		return LoanOfferStatusMessageId;
	}

	public void setLoanOfferStatusMessageId(String loanOfferStatusMessageId) {
		LoanOfferStatusMessageId = loanOfferStatusMessageId;
	}

	public String getLoanOfferReadyTitleId() {
		return LoanOfferReadyTitleId;
	}

	public void setLoanOfferReadyTitleId(String loanOfferReadyTitleId) {
		LoanOfferReadyTitleId = loanOfferReadyTitleId;
	}

	public String getLoanOfferReadyMessageId() {
		return LoanOfferReadyMessageId;
	}

	public void setLoanOfferReadyMessageId(String loanOfferReadyMessageId) {
		LoanOfferReadyMessageId = loanOfferReadyMessageId;
	}

	public String getLoanOfferReadySubmitId() {
		return LoanOfferReadySubmitId;
	}

	public void setLoanOfferReadySubmitId(String loanOfferReadySubmitId) {
		LoanOfferReadySubmitId = loanOfferReadySubmitId;
	}

	public String getSelectLoanDetailsPageTitleId() {
		return SelectLoanDetailsPageTitleId;
	}

	public void setSelectLoanDetailsPageTitleId(
			String selectLoanDetailsPageTitleId) {
		SelectLoanDetailsPageTitleId = selectLoanDetailsPageTitleId;
	}

	public String getAvailableOfferAmountId() {
		return AvailableOfferAmountId;
	}

	public void setAvailableOfferAmountId(String availableOfferAmountId) {
		AvailableOfferAmountId = availableOfferAmountId;
	}

	public String getSelectedAmountId() {
		return SelectedAmountId;
	}

	public void setSelectedAmountId(String selectedAmountId) {
		SelectedAmountId = selectedAmountId;
	}

	public String getAvailableOfferTenureClass() {
		return AvailableOfferTenureClass;
	}

	public void setAvailableOfferTenureClass(String availableOfferTenureClass) {
		AvailableOfferTenureClass = availableOfferTenureClass;
	}

	public String getAnotherAmount() {
		return AnotherAmount;
	}

	public void setAnotherAmount(String anotherAmount) {
		AnotherAmount = anotherAmount;
	}

	public String getAmountListClass() {
		return AmountListClass;
	}

	public void setAmountListClass(String amountListClass) {
		AmountListClass = amountListClass;
	}

	public String getInterestRateId() {
		return InterestRateId;
	}

	public void setInterestRateId(String interestRateId) {
		InterestRateId = interestRateId;
	}

	public String getInterestAmountId() {
		return InterestAmountId;
	}

	public void setInterestAmountId(String interestAmountId) {
		InterestAmountId = interestAmountId;
	}

	public String getRepaymentAmountId() {
		return RepaymentAmountId;
	}

	public void setRepaymentAmountId(String repaymentAmountId) {
		RepaymentAmountId = repaymentAmountId;
	}

	public String getSelectLoanDetailsApplyButtonId() {
		return SelectLoanDetailsApplyButtonId;
	}

	public void setSelectLoanDetailsApplyButtonId(
			String selectLoanDetailsApplyButtonId) {
		SelectLoanDetailsApplyButtonId = selectLoanDetailsApplyButtonId;
	}

	public String getRequiredInfoTitleClass() {
		return RequiredInfoTitleClass;
	}

	public void setRequiredInfoTitleClass(String requiredInfoTitleClass) {
		RequiredInfoTitleClass = requiredInfoTitleClass;
	}

	public String getRequiredInfoCloseBtnId() {
		return RequiredInfoCloseBtnId;
	}

	public void setRequiredInfoCloseBtnId(String requiredInfoCloseBtnId) {
		RequiredInfoCloseBtnId = requiredInfoCloseBtnId;
	}

	public String getRequiredInfoSelfieId() {
		return RequiredInfoSelfieId;
	}

	public void setRequiredInfoSelfieId(String requiredInfoSelfieId) {
		RequiredInfoSelfieId = requiredInfoSelfieId;
	}

	public String getRequiredInfoGovtId() {
		return RequiredInfoGovtId;
	}

	public void setRequiredInfoGovtId(String requiredInfoGovtId) {
		RequiredInfoGovtId = requiredInfoGovtId;
	}

	public String getRequiredInfoAcceptId() {
		return RequiredInfoAcceptId;
	}

	public void setRequiredInfoAcceptId(String requiredInfoAcceptId) {
		RequiredInfoAcceptId = requiredInfoAcceptId;
	}

	public String getRequiredInfoDeclineId() {
		return RequiredInfoDeclineId;
	}

	public void setRequiredInfoDeclineId(String requiredInfoDeclineId) {
		RequiredInfoDeclineId = requiredInfoDeclineId;
	}

	public String getValidIdTitleId() {
		return ValidIdTitleId;
	}

	public void setValidIdTitleId(String validIdTitleId) {
		ValidIdTitleId = validIdTitleId;
	}

	public String getValidIdMenuPlaceholderId() {
		return ValidIdMenuPlaceholderId;
	}

	public void setValidIdMenuPlaceholderId(String validIdMenuPlaceholderId) {
		ValidIdMenuPlaceholderId = validIdMenuPlaceholderId;
	}

	public String getValidIdMenuClass() {
		return ValidIdMenuClass;
	}

	public void setValidIdMenuClass(String validIdMenuClass) {
		ValidIdMenuClass = validIdMenuClass;
	}

	public String getIdType1() {
		return IdType1;
	}

	public void setIdType1(String idType1) {
		IdType1 = idType1;
	}

	public String getIdType2() {
		return IdType2;
	}

	public void setIdType2(String idType2) {
		IdType2 = idType2;
	}

	public String getValidIdNumberId() {
		return ValidIdNumberId;
	}

	public void setValidIdNumberId(String validIdNumberId) {
		ValidIdNumberId = validIdNumberId;
	}

	public String getVotersCardNumber() {
		return VotersCardNumber;
	}

	public void setVotersCardNumber(String votersCardNumber) {
		VotersCardNumber = votersCardNumber;
	}

	public String getDriversLicence() {
		return DriversLicence;
	}

	public void setDriversLicence(String driversLicence) {
		DriversLicence = driversLicence;
	}

	public String getValidCardExpiryDateId() {
		return ValidCardExpiryDateId;
	}

	public void setValidCardExpiryDateId(String validCardExpiryDateId) {
		ValidCardExpiryDateId = validCardExpiryDateId;
	}

	public String getValidCardSubmitId() {
		return ValidCardSubmitId;
	}

	public void setValidCardSubmitId(String validCardSubmitId) {
		ValidCardSubmitId = validCardSubmitId;
	}

	public String getValidCardCancelId() {
		return ValidCardCancelId;
	}

	public void setValidCardCancelId(String validCardCancelId) {
		ValidCardCancelId = validCardCancelId;
	}

	public String getLoanSummaryTitleId() {
		return LoanSummaryTitleId;
	}

	public void setLoanSummaryTitleId(String loanSummaryTitleId) {
		LoanSummaryTitleId = loanSummaryTitleId;
	}

	public String getLoanSummaryAmountId() {
		return LoanSummaryAmountId;
	}

	public void setLoanSummaryAmountId(String loanSummaryAmountId) {
		LoanSummaryAmountId = loanSummaryAmountId;
	}

	public String getLoanSummaryInterestId() {
		return LoanSummaryInterestId;
	}

	public void setLoanSummaryInterestId(String loanSummaryInterestId) {
		LoanSummaryInterestId = loanSummaryInterestId;
	}

	public String getLoanSummaryDiscountId() {
		return LoanSummaryDiscountId;
	}

	public void setLoanSummaryDiscountId(String loanSummaryDiscountId) {
		LoanSummaryDiscountId = loanSummaryDiscountId;
	}

	public String getLoanSUmmaryDiscountBtnId() {
		return LoanSUmmaryDiscountBtnId;
	}

	public void setLoanSUmmaryDiscountBtnId(String loanSUmmaryDiscountBtnId) {
		LoanSUmmaryDiscountBtnId = loanSUmmaryDiscountBtnId;
	}

	public String getLoanSummaryRepaymentId() {
		return LoanSummaryRepaymentId;
	}

	public void setLoanSummaryRepaymentId(String loanSummaryRepaymentId) {
		LoanSummaryRepaymentId = loanSummaryRepaymentId;
	}

	public String getLoanSummaryTenureId() {
		return LoanSummaryTenureId;
	}

	public void setLoanSummaryTenureId(String loanSummaryTenureId) {
		LoanSummaryTenureId = loanSummaryTenureId;
	}

	public String getLoanSummaryApplyBtnId() {
		return LoanSummaryApplyBtnId;
	}

	public String getLoanSummaryTextClass() {
		return LoanSummaryTextClass;
	}

	public void setLoanSummaryTextClass(String loanSummaryTextClass) {
		LoanSummaryTextClass = loanSummaryTextClass;
	}

	public void setLoanSummaryApplyBtnId(String loanSummaryApplyBtnId) {
		LoanSummaryApplyBtnId = loanSummaryApplyBtnId;
	}

	public String getConfirmationTitleId() {
		return ConfirmationTitleId;
	}

	public void setConfirmationTitleId(String confirmationTitleId) {
		ConfirmationTitleId = confirmationTitleId;
	}

	public String getConfirmationPaymentsClass() {
		return ConfirmationPaymentsClass;
	}

	public void setConfirmationPaymentsClass(String confirmationPaymentsClass) {
		ConfirmationPaymentsClass = confirmationPaymentsClass;
	}

	public String getConfirmationPaymentNumberId() {
		return ConfirmationPaymentNumberId;
	}

	public void setConfirmationPaymentNumberId(String confirmationPaymentNumberId) {
		ConfirmationPaymentNumberId = confirmationPaymentNumberId;
	}

	public String getConfirmationPayDatesId() {
		return ConfirmationPayDatesId;
	}

	public void setConfirmationPayDatesId(String confirmationPayDatesId) {
		ConfirmationPayDatesId = confirmationPayDatesId;
	}

	public String getConfirmationPaymentsId() {
		return ConfirmationPaymentsId;
	}

	public void setConfirmationPaymentsId(String confirmationPaymentsId) {
		ConfirmationPaymentsId = confirmationPaymentsId;
	}

	public String getConfirmationSubmitId() {
		return ConfirmationSubmitId;
	}

	public void setConfirmationSubmitId(String confirmationSubmitId) {
		ConfirmationSubmitId = confirmationSubmitId;
	}

	public String getPINConfirmTextId() {
		return PINConfirmTextId;
	}

	public void setPINConfirmTextId(String pINConfirmTextId) {
		PINConfirmTextId = pINConfirmTextId;
	}

	public String getPINConfirmInputId() {
		return PINConfirmInputId;
	}

	public void setPINConfirmInputId(String pINConfirmInputId) {
		PINConfirmInputId = pINConfirmInputId;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public String getApplicationSubmittedTitleId() {
		return ApplicationSubmittedTitleId;
	}

	public void setApplicationSubmittedTitleId(String applicationSubmittedTitleId) {
		ApplicationSubmittedTitleId = applicationSubmittedTitleId;
	}

	public String getApplicationSubmittedTextId() {
		return ApplicationSubmittedTextId;
	}

	public void setApplicationSubmittedTextId(String applicationSubmittedTextId) {
		ApplicationSubmittedTextId = applicationSubmittedTextId;
	}

	public String getTellAFriendBtnId() {
		return TellAFriendBtnId;
	}

	public void setTellAFriendBtnId(String tellAFriendBtnId) {
		TellAFriendBtnId = tellAFriendBtnId;
	}

	public String getMaybeLaterBtnId() {
		return MaybeLaterBtnId;
	}

	public void setMaybeLaterBtnId(String maybeLaterBtnId) {
		MaybeLaterBtnId = maybeLaterBtnId;
	}

	public String getMonthlyIncomeErrorId() {
		return MonthlyIncomeErrorId;
	}

	public String getMonthlyIncomeError() {
		return MonthlyIncomeError;
	}

	public String getBankErrorTitleId() {
		return BankErrorTitleId;
	}

	public String getBankErrorTitle() {
		return BankErrorTitle;
	}

	public String getBankErrorMsgId() {
		return BankErrorMsgId;
	}

	
	public String getBankErrorOkId() {
		return BankErrorOkId;
	}

	public String getEmailError() {
		return EmailError;
	}

	public String getBVNError() {
		return BVNError;
	}

	public String getApplicationErrorId() {
		return ApplicationErrorId;
	}

	public String getPINError() {
		return PINError;
	}

	public String getLocationErrorId() {
		return LocationErrorId;
	}

	public String getLocationError() {
		return LocationError;
	}

	public String getMobileMoneyProviderid() {
		return MobileMoneyProviderid;
	}

	public String getMobileMoneyAccountId() {
		return MobileMoneyAccountId;
	}

	public String getApplyButtonId2() {
		return ApplyButtonId2;
	}

	public String getMobileMoneyDetailsSubmitId() {
		return MobileMoneyDetailsSubmitId;
	}

	public String getTownId() {
		return TownId;
	}

	public String getLandmarkId() {
		return LandmarkId;
	}

	public String getExpiryClass() {
		return ExpiryClass;
	}

	public String getCalenderSubmitBtnId() {
		return CalenderSubmitBtnId;
	}

	public String getButtonsClass() {
		return ButtonsClass;
	}

	public String getPINDoneId() {
		return PINDoneId;
	}

	public String getLocationInfoId() {
		return LocationInfoId;
	}

	public String getLocationInfoTitleId() {
		return LocationInfoTitleId;
	}

	public String getLocationInfoSubmitBtnId() {
		return LocationInfoSubmitBtnId;
	}

}
