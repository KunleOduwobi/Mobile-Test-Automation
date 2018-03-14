package functionalTests;

public class SignUpPageObject {
	public SignUpPageObject() {

	}

	private String FirstnameId = "com.lenddo.mobile.paylater:id/firstname_container";
	private String EnterFirstnameId = "com.lenddo.mobile.paylater:id/sign_up_a_first_name";
	private String Firstname = "Abiola";
	private String SurnameId = "com.lenddo.mobile.paylater:id/sign_up_a_last_name";
	private String Surname = "Balogun";
	private String NextBtnId = "com.lenddo.mobile.paylater:id/sign_up_a_next";
	private String EmailPHClass = "android.widget.LinearLayout";
	private String EmailId = "com.lenddo.mobile.paylater:id/sign_up_a_email";
	private String Email = "abiola_balogun@onefi.co";
	private String DoBId = "com.lenddo.mobile.paylater:id/sign_up_a_birthday";
	private String DobClass = "android.widget.EditText";
	private String DobDay = "04";
	private String DobMonth = "Jun";
	private String DobYear = "1989";
	private String CalenderSubmitBtnId = "android:id/button1";
	private String PhonenumberId = "com.lenddo.mobile.paylater:id/sign_up_a_phone";
	private String Phonenumber = "08138127656"; 
	private String PhonenumberDescId = "com.lenddo.mobile.paylater:id/sign_up_a_field_description";
	private String PhonenumberDesc = "You will receive all account updates on this number. Please ensure this is your own personal line.";
	private String TnCTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String TnCTitle = "Accept Terms";
	private String TnCTextId = "com.lenddo.mobile.paylater:id/terms_click_text";
	private String TnCAgreeId = "com.lenddo.mobile.paylater:id/application_confirmation_agree";
	private String TnCCancelId = "com.lenddo.mobile.paylater:id/application_confirmation_cancel";
	private String AccountExistsDialogId = "android:id/content";
	private String AccountExistsTitleId = "android:id/alertTitle";
	private String AccountExistsTitle = "Account Already Exists";
	private String AccountExistsMsgId = "android:id/message";
	private String AccountExistsMsg = "User with email already exists";
	private String AccountExistsSignInId = "android:id/button1";
	private String AccountExistsCancelId = "android:id/button3";
	private String CreatePinTitleId = "com.lenddo.mobile.paylater:id/create_pin_message";
	private String CreatePinTitleId2 = "com.lenddo.mobile.paylater:id/title_text";
	private String CreatePinId = "com.lenddo.mobile.paylater:id/edit_pin_placeholder1";
	private String CreatedPinId2 = "com.lenddo.mobile.paylater:id/pin_view";
	private String PIN = "1234";
	private String ConfirmPINTextId = "com.lenddo.mobile.paylater:id/micro_text";
	private String PINErrorId = "android:id/message";
	private String PINError = "PIN does not match";
	private String PINErrorOKId = "android:id/button1";
	private String UnlinkTitleId = "com.lenddo.mobile.paylater:id/unlink_title";
	private String UnlinkTextId = "com.lenddo.mobile.paylater:id/unlink_message";
	private String UnlinkText = "Device already registered to another user.";
	private String UnlinkText2 = "Device is already registered to another user.";
	private String UnlinkBtnId = "com.lenddo.mobile.paylater:id/unlink_device";
	private String UnlinkOkId = "com.lenddo.mobile.paylater:id/ok_button";
	private String PINSuccessTitleId = "com.lenddo.mobile.paylater:id/success_title";
	private String PINSuccessText = "Your Paylater PIN has been created successfully";
	private String VerifyTextId = "com.lenddo.mobile.paylater:id/sign_up_verify_info_text";
	private String VerifyText = "Enter 6 digit verification code sent to " + Phonenumber + ". Change number?";
	private String VerifyInputClass = "android.widget.FrameLayout"; //1
	private String ResendSMSID = "com.lenddo.mobile.paylater:id/sign_up_verify_resend";
	private String ChangeNumberId = "com.lenddo.mobile.paylater:id/sign_up_verify_edit_phone";
	private String InvalidCodeDialogId = "android:id/parentPanel";
	private String InvalidCodeTitleId = "android:id/alertTitle";
	private String InvalidCodeText = "Invalid Code Entered";
	private String InvalidCodeOKId = "android:id/button1";
	private String VerifySuccessTitleId = "com.lenddo.mobile.paylater:id/success_title";
	private String VerifySuccessText = "Your phone number has been verified";
	private String ProfileExistsId = "com.lenddo.mobile.paylater:id/alertTitle";
	private String ProfileExists = "Already registered";
	private String ProfileExistsOkId = "android:id/button1";
	private String ProfileExistsResetId = "android:id/button3";
	

	public String getFirstnameId() {
		return FirstnameId;
	}

	public void setFirstnameId(String firstnameId) {
		FirstnameId = firstnameId;
	}

	public String getSurnameId() {
		return SurnameId;
	}

	public void setSurnameId(String surnameId) {
		SurnameId = surnameId;
	}

	public String getNextBtnId() {
		return NextBtnId;
	}

	public void setNextBtnId(String nextBtnId) {
		NextBtnId = nextBtnId;
	}

	public String getEnterFirstnameId() {
		return EnterFirstnameId;
	}

	public void setEnterFirstnameId(String enterFirstnameId) {
		EnterFirstnameId = enterFirstnameId;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmailPHClass() {
		return EmailPHClass;
	}

	public void setEmailPHClass(String emailPHClass) {
		EmailPHClass = emailPHClass;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDoBId() {
		return DoBId;
	}

	public void setDoBId(String doBId) {
		DoBId = doBId;
	}

	public String getDobClass() {
		return DobClass;
	}

	public void setDobClass(String dobClass) {
		DobClass = dobClass;
	}

	public String getDobDay() {
		return DobDay;
	}

	public void setDobDay(String dobDay) {
		DobDay = dobDay;
	}

	public String getDobMonth() {
		return DobMonth;
	}

	public void setDobMonth(String dobMonth) {
		DobMonth = dobMonth;
	}

	public String getDobYear() {
		return DobYear;
	}

	public void setDobYear(String dobYear) {
		DobYear = dobYear;
	}

	public String getCalenderSubmitBtnId() {
		return CalenderSubmitBtnId;
	}

	public void setCalenderSubmitBtnId(String calenderSubmitBtnId) {
		CalenderSubmitBtnId = calenderSubmitBtnId;
	}

	public String getPhonenumberId() {
		return PhonenumberId;
	}

	public void setPhonenumberId(String phonenumberId) {
		PhonenumberId = phonenumberId;
	}

	public String getPhonenumber() {
		return Phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}

	public String getTnCTitleId() {
		return TnCTitleId;
	}

	public void setTnCTitleId(String tnCTitleId) {
		TnCTitleId = tnCTitleId;
	}

	public String getTnCTextId() {
		return TnCTextId;
	}

	public void setTnCTextId(String tnCTextId) {
		TnCTextId = tnCTextId;
	}

	public String getTnCAgreeId() {
		return TnCAgreeId;
	}

	public void setTnCAgreeId(String tnCAgreeId) {
		TnCAgreeId = tnCAgreeId;
	}

	public String getTnCCancelId() {
		return TnCCancelId;
	}

	public void setTnCCancelId(String tnCCancelId) {
		TnCCancelId = tnCCancelId;
	}

	public String getAccountExistsDialogId() {
		return AccountExistsDialogId;
	}

	public void setAccountExistsDialogId(String accountExistsDialogId) {
		AccountExistsDialogId = accountExistsDialogId;
	}

	public String getAccountExistsTitleId() {
		return AccountExistsTitleId;
	}

	public void setAccountExistsTitleId(String accountExistsTitleId) {
		AccountExistsTitleId = accountExistsTitleId;
	}

	public String getAccountExistsTitle() {
		return AccountExistsTitle;
	}

	public void setAccountExistsTitle(String accountExistsTitle) {
		AccountExistsTitle = accountExistsTitle;
	}

	public String getAccountExistsSignInId() {
		return AccountExistsSignInId;
	}

	public void setAccountExistsSignInId(String accountExistsSignInId) {
		AccountExistsSignInId = accountExistsSignInId;
	}

	public String getAccountExistsCancelId() {
		return AccountExistsCancelId;
	}

	public void setAccountExistsCancelId(String accountExistsCancelId) {
		AccountExistsCancelId = accountExistsCancelId;
	}

	public String getCreatePinTitleId() {
		return CreatePinTitleId;
	}

	public void setCreatePinTitleId(String createPinTitleId) {
		CreatePinTitleId = createPinTitleId;
	}

	public String getCreatePinId() {
		return CreatePinId;
	}

	public void setCreatePinId(String createPinId) {
		CreatePinId = createPinId;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public String getConfirmPINTextId() {
		return ConfirmPINTextId;
	}

	public void setConfirmPINTextId(String confirmPINTextId) {
		ConfirmPINTextId = confirmPINTextId;
	}

	public String getPINErrorId() {
		return PINErrorId;
	}

	public void setPINErrorId(String pINErrorId) {
		PINErrorId = pINErrorId;
	}

	public String getPINError() {
		return PINError;
	}

	public void setPINError(String pINError) {
		PINError = pINError;
	}

	public String getPINErrorOKId() {
		return PINErrorOKId;
	}

	public void setPINErrorOKId(String pINErrorOKId) {
		PINErrorOKId = pINErrorOKId;
	}

	public String getUnlinkTitleId() {
		return UnlinkTitleId;
	}

	public void setUnlinkTitleId(String unlinkTitleId) {
		UnlinkTitleId = unlinkTitleId;
	}

	public String getUnlinkTextId() {
		return UnlinkTextId;
	}

	public void setUnlinkTextId(String unlinkTextId) {
		UnlinkTextId = unlinkTextId;
	}

	public String getUnlinkText() {
		return UnlinkText;
	}

	public void setUnlinkText(String unlinkText) {
		UnlinkText = unlinkText;
	}

	public String getUnlinkBtnId() {
		return UnlinkBtnId;
	}

	public void setUnlinkBtnId(String unlinkBtnId) {
		UnlinkBtnId = unlinkBtnId;
	}

	public String getUnlinkOkId() {
		return UnlinkOkId;
	}

	public void setUnlinkOkId(String unlinkOkId) {
		UnlinkOkId = unlinkOkId;
	}

	public String getPINSuccessTitleId() {
		return PINSuccessTitleId;
	}

	public void setPINSuccessTitleId(String pINSuccessTitleId) {
		PINSuccessTitleId = pINSuccessTitleId;
	}

	public String getPINSuccessText() {
		return PINSuccessText;
	}

	public void setPINSuccessText(String pINSuccessText) {
		PINSuccessText = pINSuccessText;
	}

	public String getVerifyTextId() {
		return VerifyTextId;
	}

	public void setVerifyTextId(String verifyTextId) {
		VerifyTextId = verifyTextId;
	}

	public String getVerifyText() {
		return VerifyText;
	}

	public void setVerifyText(String verifyText) {
		VerifyText = verifyText;
	}

	public String getVerifyInputClass() {
		return VerifyInputClass;
	}

	public void setVerifyInputClass(String verifyInputClass) {
		VerifyInputClass = verifyInputClass;
	}

	public String getResendSMSID() {
		return ResendSMSID;
	}

	public void setResendSMSID(String resendSMSID) {
		ResendSMSID = resendSMSID;
	}

	public String getChangeNumberId() {
		return ChangeNumberId;
	}

	public void setChangeNumberId(String changeNumberId) {
		ChangeNumberId = changeNumberId;
	}

	public String getInvalidCodeTitleId() {
		return InvalidCodeTitleId;
	}

	public void setInvalidCodeTitleId(String invalidCodeTitleId) {
		InvalidCodeTitleId = invalidCodeTitleId;
	}

	public String getInvalidCodeText() {
		return InvalidCodeText;
	}

	public void setInvalidCodeText(String invalidCodeText) {
		InvalidCodeText = invalidCodeText;
	}

	public String getInvalidCodeOKId() {
		return InvalidCodeOKId;
	}

	public void setInvalidCodeOKId(String invalidCodeOKId) {
		InvalidCodeOKId = invalidCodeOKId;
	}

	public String getVerifySuccessTitleId() {
		return VerifySuccessTitleId;
	}

	public void setVerifySuccessTitleId(String verifySuccessTitleId) {
		VerifySuccessTitleId = verifySuccessTitleId;
	}

	public String getVerifySuccessText() {
		return VerifySuccessText;
	}

	public void setVerifySuccessText(String verifySuccessText) {
		VerifySuccessText = verifySuccessText;
	}

	public String getPhonenumberDescId() {
		return PhonenumberDescId;
	}

	public void setPhonenumberDescId(String phonenumberDescId) {
		PhonenumberDescId = phonenumberDescId;
	}

	public String getPhonenumberDesc() {
		return PhonenumberDesc;
	}

	public void setPhonenumberDesc(String phonenumberDesc) {
		PhonenumberDesc = phonenumberDesc;
	}

	public String getTnCTitle() {
		return TnCTitle;
	}

	public void setTnCTitle(String tnCTitle) {
		TnCTitle = tnCTitle;
	}

	public String getProfileExistsId() {
		return ProfileExistsId;
	}

	public void setProfileExistsId(String profileExistsId) {
		ProfileExistsId = profileExistsId;
	}

	public String getProfileExists() {
		return ProfileExists;
	}

	public void setProfileExists(String profileExists) {
		ProfileExists = profileExists;
	}

	public String getProfileExistsOkId() {
		return ProfileExistsOkId;
	}

	public void setProfileExistsOkId(String profileExistsOkId) {
		ProfileExistsOkId = profileExistsOkId;
	}

	public String getProfileExistsResetId() {
		return ProfileExistsResetId;
	}

	public void setProfileExistsResetId(String profileExistsResetId) {
		ProfileExistsResetId = profileExistsResetId;
	}

	public String getInvalidCodeDialogId() {
		return InvalidCodeDialogId;
	}

	public void setInvalidCodeDialogId(String invalidCodeDialogId) {
		InvalidCodeDialogId = invalidCodeDialogId;
	}

	public String getUnlinkText2() {
		return UnlinkText2;
	}

	public String getAccountExistsMsgId() {
		return AccountExistsMsgId;
	}

	public String getAccountExistsMsg() {
		return AccountExistsMsg;
	}

	public String getCreatePinTitleId2() {
		return CreatePinTitleId2;
	}

	public String getCreatedPinId2() {
		return CreatedPinId2;
	}

}
