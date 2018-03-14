package functionalTests;

public class UnlockAppPageObject {
	
	public UnlockAppPageObject() {

	}

	private String UnlockPageTitleId = "com.lenddo.mobile.paylater:id/title_text"; 
	private String UnlockPageTitle = "Unlock";
	private String UnlockPageTitle2 = "Enter PIN";
	private String PinId = "com.lenddo.mobile.paylater:id/edit_pin_placeholder1";
	private String ForgotPinId = "com.lenddo.mobile.paylater:id/lock_pin_forgot";
	private String DoneBtnId = "com.lenddo.mobile.paylater:id/pin_done";

	public String getUnlockPageTitleId() {
		return UnlockPageTitleId;
	}

	public String getUnlockPageTitle() {
		return UnlockPageTitle;
	}

	public String getPinId() {
		return PinId;
	}

	public String getForgotPinId() {
		return ForgotPinId;
	}

	public String getUnlockPageTitle2() {
		return UnlockPageTitle2;
	}

	public String getDoneBtnId() {
		return DoneBtnId;
	}

}
