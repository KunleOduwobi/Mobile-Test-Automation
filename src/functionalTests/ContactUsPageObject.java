package functionalTests;

public class ContactUsPageObject {

	public ContactUsPageObject() {
		// TODO Auto-generated constructor stub
	}

	private String PageTitleId = "com.lenddo.mobile.paylater:id/title_text";
	private String TextViewClass = "android.widget.TextView";
	private String IconsId = "com.lenddo.mobile.paylater:id/social_icon"; // 6
	private String ContactsId = "com.lenddo.mobile.paylater:id/social_medium"; // 6

	public String getPageTitleId() {
		return PageTitleId;
	}

	public String getTextViewClass() {
		return TextViewClass;
	}

	public String getIconsId() {
		return IconsId;
	}

	public String getContactsId() {
		return ContactsId;
	}

}
