package functionalTests;

public class Elements {

	public Elements() {

	}

	public void HelperTest() {
		System.out.println("Elements helper test successful");
	}

	// APP SESSION
	private boolean appSession;

	public boolean getAppSession() {
		return appSession;
	}

	public void setAppSession(boolean appSession) {
		this.appSession = appSession;
	}

	// SPLASH SCREEN
	private String SplashScreenId = "com.lenddo.mobile.paylater:id/splash_image_view";

	public String getSplashScreenId() {
		return SplashScreenId;
	}

	// ON-BOARDING SCREENS
	private String NextBtnId = "com.lenddo.mobile.paylater:id/tutorial_next";
	private String SkipSlidesId = "com.lenddo.mobile.paylater:id/tutorial_skip";
	private String SlideTitleId = "com.lenddo.mobile.paylater:id/header_text";
	private String Slide1Title = "Get a loan in minutes";
	private String Slide2Title = "Anywhere, anytime";
	private String Slide3Title = "All on your mobile device";
	private String SlideMsgId = "com.lenddo.mobile.paylater:id/tutorial_message";
	private String Slide1Msg = "To get a Paylater loan, all you need is a data connection, a means of"
			+ " ID and valid bank details. No collateral required. It's that easy!";
	private String Slide2Msg = "Our service is available 24/7 - whenever and wherever you need funds, we can help you.";
	private String Slide3Msg = "Please ensure you use your personal mobile device to register, as "
			+ "this helps us determine the best loan offer for you";
	private String FinishBtnId = "com.lenddo.mobile.paylater:id/finish";
	private String FinishBtn = "GET STARTED";

	public String getSlideTitleId() {
		return SlideTitleId;
	}

	public String getSlide1Title() {
		return Slide1Title;
	}

	public String getSlide2Title() {
		return Slide2Title;
	}

	public String getSlide3Title() {
		return Slide3Title;
	}

	public String getSlideMsgId() {
		return SlideMsgId;
	}

	public String getSlide1Msg() {
		return Slide1Msg;
	}

	public String getSlide2Msg() {
		return Slide2Msg;
	}

	public String getSlide3Msg() {
		return Slide3Msg;
	}

	public String getFinishBtnId() {
		return FinishBtnId;
	}

	public String getFinishBtn() {
		return FinishBtn;
	}

	public String getNextBtnId() {
		return NextBtnId;
	}

	public void setNextBtnId(String nextBtnId) {
		NextBtnId = nextBtnId;
	}

	public String getSkipSlidesId() {
		return SkipSlidesId;
	}

	public void setSkipSlidesId(String skipSlidesId) {
		SkipSlidesId = skipSlidesId;
	}

	// LANDING SCREEN
	private String LandingSignInBtnId = "com.lenddo.mobile.paylater:id/user_type_existing"; // com.lenddo.mobile.paylater:id/user_type_existing
	private String LangingRegisterBtnId = "com.lenddo.mobile.paylater:id/user_type_new";
	private String LandingPageTitleId = "com.lenddo.mobile.paylater:id/fontTextView15";
	private String LandingPageTitle = "Welcome to Paylater!";

	public String getLandingPageTitleId() {
		return LandingPageTitleId;
	}

	public void setLandingPageTitleId(String landingPageTitleId) {
		LandingPageTitleId = landingPageTitleId;
	}

	public String getLandingPageTitle() {
		return LandingPageTitle;
	}

	public void setLandingPageTitle(String landingPageTitle) {
		LandingPageTitle = landingPageTitle;
	}

	public String getLandingSignInBtnId() {
		return LandingSignInBtnId;
	}

	public void setLandingSignInBtnId(String landingSignInBtnId) {
		LandingSignInBtnId = landingSignInBtnId;
	}

	public String getLangingRegisterBtnId() {
		return LangingRegisterBtnId;
	}

	public void setLangingRegisterBtnId(String langingRegisterBtnId) {
		LangingRegisterBtnId = langingRegisterBtnId;
	}

	// LOGIN
	// Login with Phone Number
	private String PhoneNumberLoginId = "com.lenddo.mobile.paylater:id/sign_in_phone";
	private String PhoneLogin = "08039414600";
	private String PINLoginId = "com.lenddo.mobile.paylater:id/sign_in_pin";
	private String PINLoginId2 = "com.lenddo.mobile.paylater:id/edit_pin_placeholder1";
	private String PINLoginClass = "android.widget.FrameLayout";
	private String PINLogin = "1234";
	private String SignInBtnId = "com.lenddo.mobile.paylater:id/sign_in_next";
	private String ForgotPinId = "com.lenddo.mobile.paylater:id/sign_in_forgot_pin";
	private String FacebookLoginBtnId = "com.lenddo.mobile.paylater:id/sign_in_facebook";
	private String SignInFailedAlertId = "com.lenddo.mobile.paylater:id/alertTitle";
	private String SignInFailedAlertId2 = "android:id/alertTitle";
	private String SignInFailedAlertMsgId = "android:id/message";
	private String ResetPinBtnId = "android:id/button3";
	private String SwitchUserId = "com.lenddo.mobile.paylater:id/not_user_text";
	private String CallDialogId = "com.android.packageinstaller:id/dialog_container";
	private String CallPermissionMsgId = "com.android.packageinstaller:id/permission_message";
	private String CallPermissionAllowId = "com.android.packageinstaller:id/permission_allow_button";
	private String CallPermissionDenyId = "com.android.packageinstaller:id/permission_deny_button";
	private String LoginAnotherUserId = "com.lenddo.mobile.paylater:id/not_user_text";
	private String SignInCompanyNameId = "com.lenddo.mobile.paylater:id/fontTextView17";
	private String SignInAppVersionId = "com.lenddo.mobile.paylater:id/sign_in_version_text";
	private String NGCompanyName = "Paylater is a service provided by One Finance & Investments Limited, a licensed and regulated lender.";
	private String GHCompanyName = "Paylater is a service provided by Link Exchange, a licensed and regulated lender.";

	public String getPhoneNumberLoginId() {
		return PhoneNumberLoginId;
	}

	public void setPhoneNumberLoginId(String phoneNumberLoginId) {
		PhoneNumberLoginId = phoneNumberLoginId;
	}

	public String getPhoneLogin() {
		return PhoneLogin;
	}

	public void setPhoneLogin(String phoneLogin) {
		PhoneLogin = phoneLogin;
	}

	public String getPINLoginId() {
		return PINLoginId;
	}

	public void setPINLoginId(String pINLoginId) {
		PINLoginId = pINLoginId;
	}

	public String getPINLogin() {
		return PINLogin;
	}

	public void setPINLogin(String pINLogin) {
		PINLogin = pINLogin;
	}

	public String getSignInBtnId() {
		return SignInBtnId;
	}

	public void setSignInBtnId(String signInBtnId) {
		SignInBtnId = signInBtnId;
	}

	public String getForgotPinId() {
		return ForgotPinId;
	}

	public void setForgotPinId(String forgotPinId) {
		ForgotPinId = forgotPinId;
	}

	public String getSignInFailedAlertId() {
		return SignInFailedAlertId;
	}

	public void setSignInFailedAlertId(String signInFailedAlertId) {
		SignInFailedAlertId = signInFailedAlertId;
	}

	public String getSwitchUserId() {
		return SwitchUserId;
	}

	public void setSwitchUserId(String switchUserId) {
		SwitchUserId = switchUserId;
	}

	public String getCallDialogId() {
		return CallDialogId;
	}

	public void setCallDialogId(String callDialogId) {
		CallDialogId = callDialogId;
	}

	public String getCallPermissionMsgId() {
		return CallPermissionMsgId;
	}

	public void setCallPermissionMsgId(String callPermissionMsgId) {
		CallPermissionMsgId = callPermissionMsgId;
	}

	public String getCallPermissionAllowId() {
		return CallPermissionAllowId;
	}

	public void setCallPermissionAllowId(String callPermissionAllowId) {
		CallPermissionAllowId = callPermissionAllowId;
	}

	public String getCallPermissionDenyId() {
		return CallPermissionDenyId;
	}

	public void setCallPermissionDenyId(String callPermissionDenyId) {
		CallPermissionDenyId = callPermissionDenyId;
	}

	// Unlink Pop Up
	private String UnlinkTitleId = "com.lenddo.mobile.paylater:id/unlink_title";
	private String UnlinkMessageId = "com.lenddo.mobile.paylater:id/unlink_message";
	private String UnlinkOKBtnId = "com.lenddo.mobile.paylater:id/ok_button";
	private String UnlinkDeviceBtnId = "com.lenddo.mobile.paylater:id/unlink_device";

	public String getFacebookLoginBtnId() {
		return FacebookLoginBtnId;
	}

	public void setFacebookLoginBtnId(String facebookLoginBtnId) {
		FacebookLoginBtnId = facebookLoginBtnId;
	}

	public String getUnlinkTitleId() {
		return UnlinkTitleId;
	}

	public void setUnlinkTitleId(String unlinkTitleId) {
		UnlinkTitleId = unlinkTitleId;
	}

	public String getUnlinkMessageId() {
		return UnlinkMessageId;
	}

	public void setUnlinkMessageId(String unlinkMessageId) {
		UnlinkMessageId = unlinkMessageId;
	}

	public String getUnlinkOKBtnId() {
		return UnlinkOKBtnId;
	}

	public void setUnlinkOKBtnId(String unlinkOKBtnId) {
		UnlinkOKBtnId = unlinkOKBtnId;
	}

	public String getUnlinkDeviceBtnId() {
		return UnlinkDeviceBtnId;
	}

	public void setUnlinkDeviceBtnId(String unlinkDeviceBtnId) {
		UnlinkDeviceBtnId = unlinkDeviceBtnId;
	}

	// Reset PIN
	private String PhoneNumberResetClass = "android.widget.EditText";
	private String PhoneNumberReset = "48635000000";
	private String DoBResetClass = "android.widget.Spinner";
	private String DateResetClass = "android.view.View";
	private String BVNResetClass = "android.widget.EditText";
	private String BVNReset = "20160514531";
	private String SubmitButtonResetClass = "android.widget.Button";

	public String getBVNReset() {
		return BVNReset;
	}

	public void setBVNReset(String bVNReset) {
		BVNReset = bVNReset;
	}

	public String getPhoneNumberResetClass() {
		return PhoneNumberResetClass;
	}

	public void setPhoneNumberResetClass(String phoneNumberResetClass) {
		PhoneNumberResetClass = phoneNumberResetClass;
	}

	public String getPhoneNumberReset() {
		return PhoneNumberReset;
	}

	public void setPhoneNumberReset(String phoneNumberReset) {
		PhoneNumberReset = phoneNumberReset;
	}

	public String getDoBResetClass() {
		return DoBResetClass;
	}

	public void setDoBResetClass(String doBResetClass) {
		DoBResetClass = doBResetClass;
	}

	public String getBVNResetClass() {
		return BVNResetClass;
	}

	public String getDateResetClass() {
		return DateResetClass;
	}

	public void setDateResetClass(String dateResetClass) {
		DateResetClass = dateResetClass;
	}

	public void setBVNResetClass(String bVNResetClass) {
		BVNResetClass = bVNResetClass;
	}

	public String getSubmitButtonResetClass() {
		return SubmitButtonResetClass;
	}

	public void setSubmitButtonResetClass(String submitButtonResetClass) {
		SubmitButtonResetClass = submitButtonResetClass;
	}

	// PERMISSIONS
	private String GrantAccessClass = "android.widget.TextView";
	private String GrantAccess = "Grant Access";
	private String ContinuePermissionsId = "com.lenddo.mobile.paylater:id/tv_btn_right";
	private String LearnMoreId = "com.lenddo.mobile.paylater:id/tv_btn_left";
	private String PermissionsDialogId = "com.android.packageinstaller:id/dialog_container";
	private String PermissionsMsgId = "com.android.packageinstaller:id/permission_message";
	private String SMSPermissionMsg = "Allow Paylater to send and view SMS messages?";
	private String ContactPermissionMsg = "Allow Paylater to access your contacts?";
	private String LocationPermissionMsg = "Allow Paylater to access this device's location?";
	private String CalendarPermissionMsg = "Allow Paylater to access your calendar?";
	private String PermissionsPageId = "com.android.packageinstaller:id/current_page_text";
	private String PermissionsAllowId = "com.android.packageinstaller:id/permission_allow_button";
	private String PermissionsDenyId = "com.android.packageinstaller:id/permission_deny_button";

	// SCORE CARD
	private String ScoreCardTitleId = "com.lenddo.mobile.paylater:id/welcome_text";

	public String getGrantAccessClass() {
		return GrantAccessClass;
	}

	public void setGrantAccessClass(String grantAccessClass) {
		GrantAccessClass = grantAccessClass;
	}

	public String getGrantAccess() {
		return GrantAccess;
	}

	public void setGrantAccess(String grantAccess) {
		GrantAccess = grantAccess;
	}

	public String getContinuePermissionsId() {
		return ContinuePermissionsId;
	}

	public void setContinuePermissionsId(String continuePermissionsId) {
		ContinuePermissionsId = continuePermissionsId;
	}

	public String getLearnMoreId() {
		return LearnMoreId;
	}

	public void setLearnMoreId(String learnMoreId) {
		LearnMoreId = learnMoreId;
	}

	public String getPermissionsDialogId() {
		return PermissionsDialogId;
	}

	public void setPermissionsDialogId(String permissionsDialogId) {
		PermissionsDialogId = permissionsDialogId;
	}

	public String getPermissionsMsgId() {
		return PermissionsMsgId;
	}

	public void setPermissionsMsgId(String permissionsMsgId) {
		PermissionsMsgId = permissionsMsgId;
	}

	public String getSMSPermissionMsg() {
		return SMSPermissionMsg;
	}

	public void setSMSPermissionMsg(String sMSPermissionMsg) {
		SMSPermissionMsg = sMSPermissionMsg;
	}

	public String getContactPermissionMsg() {
		return ContactPermissionMsg;
	}

	public void setContactPermissionMsg(String contactPermissionMsg) {
		ContactPermissionMsg = contactPermissionMsg;
	}

	public String getLocationPermissionMsg() {
		return LocationPermissionMsg;
	}

	public void setLocationPermissionMsg(String locationPermissionMsg) {
		LocationPermissionMsg = locationPermissionMsg;
	}

	public String getCalendarPermissionMsg() {
		return CalendarPermissionMsg;
	}

	public void setCalendarPermissionMsg(String calendarPermissionMsg) {
		CalendarPermissionMsg = calendarPermissionMsg;
	}

	public String getPermissionsPageId() {
		return PermissionsPageId;
	}

	public void setPermissionsPageId(String permissionsPageId) {
		PermissionsPageId = permissionsPageId;
	}

	public String getPermissionsAllowId() {
		return PermissionsAllowId;
	}

	public void setPermissionsAllowId(String permissionsAllowId) {
		PermissionsAllowId = permissionsAllowId;
	}

	public String getPermissionsDenyId() {
		return PermissionsDenyId;
	}

	public void setPermissionsDenyId(String permissionsDenyId) {
		PermissionsDenyId = permissionsDenyId;
	}

	private String ScoreCardNetIncomeId = "com.lenddo.mobile.paylater:id/user_info_business_income_source";
	private String ScoreCardAccountNumberId = "com.lenddo.mobile.paylater:id/user_info_bank_account_number";
	private String ScoreCardCalculateBtnId = "com.lenddo.mobile.paylater:id/calculate";

	public String getScoreCardTitleId() {
		return ScoreCardTitleId;
	}

	public void setScoreCardTitleId(String scoreCardTitleId) {
		ScoreCardTitleId = scoreCardTitleId;
	}

	public String getScoreCardNetIncomeId() {
		return ScoreCardNetIncomeId;
	}

	public void setScoreCardNetIncomeId(String scoreCardNetIncomeId) {
		ScoreCardNetIncomeId = scoreCardNetIncomeId;
	}

	public String getScoreCardAccountNumberId() {
		return ScoreCardAccountNumberId;
	}

	public void setScoreCardAccountNumberId(String scoreCardAccountNumberId) {
		ScoreCardAccountNumberId = scoreCardAccountNumberId;
	}

	public String getScoreCardCalculateBtnId() {
		return ScoreCardCalculateBtnId;
	}

	public void setScoreCardCalculateBtnId(String scoreCardCalculateBtnId) {
		ScoreCardCalculateBtnId = scoreCardCalculateBtnId;
	}

	// APP MENU
	private String MenuButtonId = "com.lenddo.mobile.paylater:id/title_up";
	private String YourLoansId = "com.lenddo.mobile.paylater:id/navigation_menu_loans";
	private String ReferAFriendId = "com.lenddo.mobile.paylater:id/navigation_menu_refer";
	private String YourProfileId = "com.lenddo.mobile.paylater:id/navigation_menu_account";
	private String NotificationsId = "com.lenddo.mobile.paylater:id/navigation_menu_notifications";
	private String ManageCards = "com.lenddo.mobile.paylater:id/navigation_menu_manage_cards";

	public String getMenuButtonId() {
		return MenuButtonId;
	}

	public void setMenuButtonId(String menuButtonId) {
		MenuButtonId = menuButtonId;
	}

	public String getYourLoansId() {
		return YourLoansId;
	}

	public void setYourLoansId(String yourLoansId) {
		YourLoansId = yourLoansId;
	}

	public String getReferAFriendId() {
		return ReferAFriendId;
	}

	public void setReferAFriendId(String referAFriendId) {
		ReferAFriendId = referAFriendId;
	}

	public String getYourProfileId() {
		return YourProfileId;
	}

	public void setYourProfileId(String yourProfileId) {
		YourProfileId = yourProfileId;
	}

	public String getNotificationsId() {
		return NotificationsId;
	}

	public void setNotificationsId(String notificationsId) {
		NotificationsId = notificationsId;
	}

	public String getManageCards() {
		return ManageCards;
	}

	public void setManageCards(String manageCards) {
		ManageCards = manageCards;
	}

	public String getYourPoints() {
		return YourPoints;
	}

	public void setYourPoints(String yourPoints) {
		YourPoints = yourPoints;
	}

	private String YourPoints = "com.lenddo.mobile.paylater:id/navigation_menu_points";

	// Welcome Popup
	private String WelcomeTitleId = "com.lenddo.mobile.paylater:id/fontTextView3";
	private String WelcomeTextId = "com.lenddo.mobile.paylater:id/fontTextView14";
	private String WelcomeBeginBtnId = "com.lenddo.mobile.paylater:id/begin";

	public String getWelcomeTitleId() {
		return WelcomeTitleId;
	}

	public void setWelcomeTitleId(String welcomeTitleId) {
		WelcomeTitleId = welcomeTitleId;
	}

	public String getWelcomeTextId() {
		return WelcomeTextId;
	}

	public void setWelcomeTextId(String welcomeTextId) {
		WelcomeTextId = welcomeTextId;
	}

	public String getWelcomeBeginBtnId() {
		return WelcomeBeginBtnId;
	}

	public void setWelcomeBeginBtnId(String welcomeBeginBtnId) {
		WelcomeBeginBtnId = welcomeBeginBtnId;
	}

	public String getLoginAnotherUserId() {
		return LoginAnotherUserId;
	}

	public void setLoginAnotherUserId(String loginAnotherUserId) {
		LoginAnotherUserId = loginAnotherUserId;
	}

	public String getSignInCompanyNameId() {
		return SignInCompanyNameId;
	}

	public String getSignInAppVersionId() {
		return SignInAppVersionId;
	}

	public String getNGCompanyName() {
		return NGCompanyName;
	}

	public String getSignInFailedAlertMsgId() {
		return SignInFailedAlertMsgId;
	}

	public String getResetPinBtnId() {
		return ResetPinBtnId;
	}

	public String getGHCompanyName() {
		return GHCompanyName;
	}

	public String getPINLoginId2() {
		return PINLoginId2;
	}

	public String getPINLoginClass() {
		return PINLoginClass;
	}

	public String getSignInFailedAlertId2() {
		return SignInFailedAlertId2;
	}

}