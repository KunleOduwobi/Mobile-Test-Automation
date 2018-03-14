package functionalTests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

import org.apache.commons.io.FileUtils;
import org.apache.xalan.xsltc.dom.AbsoluteIterator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.Constants;

public class Helper extends SetUp {

	CardSetupPageObject cardSetupPageObject = new CardSetupPageObject();

	// public Helper() {
	//
	// }

	// WebDriver driver;

	// Helper test
	public void HelperTest() {
		System.out.println("Methods Helper Test Successful!");
	}

	// CHECK IF ELEMENT IS PRESENT
	public boolean isElementPresent(String element) {

		try {
			getDriver().findElement(By.id(element));
			return true;

		} catch (NoSuchElementException e) {

			return false;
		}

	}

	// GET TEXT ATTRIBUTE
	// By Xpath
	public String GetTextXpath(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getAttribute("text");
	}

	// By Element
	public String GetTextElement(WebElement element) {
		return element.getAttribute("text");
	}

	// By Id
	public String GetTextId(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("text");
	}

	// GET VALUE ATTRIBUTE
	// By id
	public String GetValueId(String element) {
		return getDriver().findElement(By.id(element)).getAttribute("value");
	}

	// CLICK
	// By Id
	public void ClickId(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	// By xpath
	public void ClickXpath(String xpathString) {
		getDriver().findElement(By.xpath(xpathString)).click();
	}

	// By ClassName
	public void ClickClass(String element, int i) {
		getDriver().findElements(By.className(element)).get(i);
	}

	// By Element
	public void ClickElement(WebElement element) {
		element.click();
	}

	// SEND KEYS
	// By xpath
	public void SendKeysXpath(String xpath, String keys) {
		getDriver().findElement(By.xpath(xpath)).sendKeys(keys);
	}

	// By Id
	public void SendKeysId(String id, String keys) {
		getDriver().findElement(By.id(id)).sendKeys(keys);
	}

	// By class
	public void SendKeysClass(String element, String keys) {
		getDriver().findElement(By.className(element)).sendKeys(keys);
	}

	// By Element
	public void SendKeysElement(WebElement element, String keys) {
		element.sendKeys(keys);
	}

	// SEND KEY EVENT
	// Enter
	public void SendEnterKey() {
		getDriver().pressKeyCode(AndroidKeyCode.ENTER);
	}

	public void SendZeroKey() {
		getDriver().pressKeyCode(AndroidKeyCode.KEYCODE_0);
	}

	public void SendOneKey() {
		getDriver().pressKeyCode(AndroidKeyCode.KEYCODE_1);
	}

	public void SendTwoKey() {
		getDriver().pressKeyCode(AndroidKeyCode.KEYCODE_2);
	}

	public void SendThreeKey() {
		getDriver().pressKeyCode(AndroidKeyCode.KEYCODE_3);
	}

	public void SendFourKey() {
		getDriver().pressKeyCode(AndroidKeyCode.KEYCODE_4);
	}

	public void SendFiveKey() {
		getDriver().pressKeyCode(AndroidKeyCode.KEYCODE_5);
	}

	// Home
	public void SendHomeKey() {
		// getDriver().pressKeyCode(AndroidKeyCode.HOME);
		getDriver().pressKeyCode(3);

	}

	// Click Paylater App
	public void ClickPaylater() {
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"Paylater\")").click();
	}

	// Maximze App
	public void Maximize() throws InterruptedException {
		// getDriver().launchApp();
		List<AndroidElement> Menu = ElementsClass("android.widget.TextView");
		Menu.get(4).click();
		ScrollDown(0.05);
		Thread.sleep(2000);
		// getDriver().findElementByName("Paylater").click(); Deprecated
		// getDriver().findElement(By
		// .xpath("//*[@name=\"Paylater\"]")).click();
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"Paylater\")").click();
	}

	// SCROLL TO
	public void ScrollAndClick(String location) {
		getDriver().scrollTo(location).click();
	}

	// SWIPE
	// Up xpath
	public void SwipeUpXPath(String location, int duration) {
		MobileElement abc = (MobileElement) driver.findElement(By.xpath(location));
		abc.swipe(SwipeElementDirection.UP, duration);
	}

	// Up Class
	public void SwipeUpClass(String location, int duration) {
		MobileElement abc = (MobileElement) driver.findElement(By.className(location));
		abc.swipe(SwipeElementDirection.UP, duration);
	}
	
	// Up Id
		public void SwipeUpId(String location, int duration) {
			MobileElement abc = (MobileElement) driver.findElement(By.id(location));
			abc.swipe(SwipeElementDirection.UP, duration);
		}

	// Left
	public void SwipeLeft(String location, int duration) {
		MobileElement abc = (MobileElement) driver.findElement(By.id(location));
		abc.swipe(SwipeElementDirection.LEFT, duration);
	}

	// Right
	public void SwipeRight(String location, int duration) {
		MobileElement abc = (MobileElement) driver.findElement(By.id(location));
		abc.swipe(SwipeElementDirection.RIGHT, duration);
	}

	// Vertical Scroll
	public void ScrollDown(double heightPercent) {
		Dimension size = getDriver().manage().window().getSize();
		int y_start = (int) (size.height * 0.60);
		int y_end = (int) (size.height * heightPercent);
		int x = size.width / 2;
		getDriver().swipe(x, y_start, x, y_end, 1000);
	}

	// Screenshot
	public void screenshot() throws IOException {
		File srcFile = getDriver().getScreenshotAs(OutputType.FILE);
		String filename = UUID.randomUUID().toString();
		File targetFile = new File(
				"/Users/olukunle/Documents/workspace/PaylaterCopy/test-output/screenshots/" + filename + ".jpg");
		FileUtils.copyFile(srcFile, targetFile);
	}

	// Wait for element
	public void waitForElement(String element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
	}

	// Custom wait for element
	public void CustomWaitForElement(String element, int secs) {
		WebDriverWait wait = new WebDriverWait(getDriver(), secs);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
	}

	public void waitForElementClass(String element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
	}

	public void CustomWaitForElementClass(String element, int secs) {
		WebDriverWait wait = new WebDriverWait(getDriver(), secs);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
	}

	// public void waitForElement2 (By androidElement){
	// WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	// wait.until(ExpectedConditions.visibilityOfElementLocated((androidElement)));
	// }

	// Size of Element
	public int ElementSizeId(String element) {
		return getDriver().findElements(By.id(element)).size();
	}

	// GET STRING LENGTH
	public int GetStringLengthId(String element) {
		return getDriver().findElement(By.id(element)).getAttribute("text").length();

	}

	// Clear Text
	// id
	public void ClearText(String element) {
		getDriver().findElement(By.id(element)).clear();
	}

	// xpath
	public void ClearTextXpath(String element) {
		getDriver().findElement(By.xpath(element)).clear();
	}

	// ASSERT
	// Assert element
	public void assertElement(String element, String Message) {
		Boolean iselementpresent = getDriver().findElements(By.id(element)).size() != 0;
		Assert.assertTrue(iselementpresent, Message + " is not present on screen");
		System.out.println(Message + " is present on screen.");
	}

	// FIND ELEMENTS
	// Classname
	public List<AndroidElement> ElementsClass(String element) {
		List<AndroidElement> Al = getDriver().findElementsByClassName(element);
		return Al;

	}

	// ID
	public List<AndroidElement> ElementsId(String element) {
		List<AndroidElement> list = getDriver().findElementsById(element);
		return list;
	}

	// CALENDAR PICKER
	public void PickDate(int CurrentDay, int Day, int CurrentYear, int Year, String CurrentMonth, String Month) {
		int CurrentMonthNumber = 0;
		int MonthNumber = 0;

		// Convert current month
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("dd-MMM-yyyy").parse(CurrentDay + "-" + CurrentMonth + "-" + CurrentYear));
			// SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
			// System.out.println(sdf.format(cal.getTime()));
			CurrentMonthNumber = Integer.valueOf(sdf2.format(cal.getTime()));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Convert birth month
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("dd-MMM-yyyy").parse(Day + "-" + Month + "-" + Year));
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
			// System.out.println(sdf.format(cal.getTime()));
			MonthNumber = Integer.valueOf(sdf2.format(cal.getTime()));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Select Month
		int MonthDiff = Math.abs(CurrentMonthNumber - MonthNumber);
		if (CurrentMonthNumber > MonthNumber) {
			for (int i = 0; i < MonthDiff; i++) {
				((AndroidElement) (getDriver().findElement(
						By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.Button[@index=0]")))).tap(1,
								2);
			}
		} else {
			for (int i = 0; i < MonthDiff; i++) {
				((AndroidElement) (getDriver().findElement(
						By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.Button[@index=2]")))).tap(1,
								2);
			}
		}

		// Select Date
		int DayDiff = Math.abs(CurrentDay - Day);
		// System.out.println("Current Day: " + CurrentDay);
		// System.out.println("New Day: " + Day);
		// System.out.println("Day Difference: " + DayDiff);
		if (CurrentDay > Day) {
			for (int i = 0; i < DayDiff; i++) {
				((AndroidElement) (getDriver().findElement(
						By.xpath("//android.widget.NumberPicker[@index='1']//android.widget.Button[@index=0]")))).tap(1,
								2);
			}
		} else {
			for (int i = 0; i < DayDiff; i++) {
				((AndroidElement) (getDriver().findElement(
						By.xpath("//android.widget.NumberPicker[@index='1']//android.widget.Button[@index=2]")))).tap(1,
								2);
			}
		}

		// Select Year
		int YearDiff = Math.abs(CurrentYear - Year);
		if (CurrentYear > Year) {
			for (int i = 0; i < YearDiff; i++) {
				((AndroidElement) (getDriver().findElement(
						By.xpath("//android.widget.NumberPicker[@index='2']//android.widget.Button[@index=0]")))).tap(1,
								2);
			}
		} else {
			for (int i = 0; i < YearDiff; i++) {
				((AndroidElement) (getDriver().findElement(
						By.xpath("//android.widget.NumberPicker[@index='2']//android.widget.Button[@index=2]")))).tap(1,
								2);
			}
		}

	}

	// MONTH CONVERTER
	public String MonthConverter(String Date) throws ParseException {
		// Convert birth month
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("dd/MMM/yyyy").parse(Date));
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		// System.out.println(sdf.format(cal.getTime()));
		return sdf2.format(cal.getTime());

	}

	// Wait until visibilty of element or timeout
	public void Waiter(AndroidElement androidElement, String ExpectedField, int TimeSeconds)
			throws InterruptedException {
		int timeout = 0;
		Boolean fieldFound = false;
		// Check field for x seconds
		while (fieldFound == false && timeout <= TimeSeconds) {
			if (androidElement.getAttribute("name").equals(ExpectedField)) {
				fieldFound = true;
			} else {
				Thread.sleep(1000);

				timeout += 1;
			}
		}
	}

	// Check Payment Transaction Status
	public String CheckTransactionStatus(String ClassName) throws InterruptedException {
		List<AndroidElement> status = ElementsClass(ClassName);
		Boolean statusFound = false;
		int timeout = 0;
		while (statusFound == false && timeout <= 60) {
			if (status.get(0).getAttribute("name").contains("Transaction Successful")) {
				statusFound = true;
				return "Transaction Successful";
			} else if (status.get(0).getAttribute("name").contains("Transaction Unsuccessful")) {
				statusFound = true;
				return "Transaction unuccessful!" + '\n' + (status.get(1).getAttribute("name"));

			} else {
				Thread.sleep(2000);
				// logger.info("debug: " + status.get(0).getAttribute("name"));
				timeout += 1;
			}
		}
		return "";

	}

	// Click name (cont-desc) specified button in class
	public String ClickWebClassButton(String ClassName, String ButtonName) {
		List<AndroidElement> buttons = ElementsClass(ClassName);
		int Index = 0;
		int Count = 0;
		String BtnName = "";
		for (AndroidElement androidElement : buttons) {
			if (androidElement.getAttribute("name").contains(ButtonName)) {
				Index = Count;
				BtnName = buttons.get(Index).getAttribute("name");
				buttons.get(Index).click();
				return BtnName + " clicked";

			}
			Count++;

		}

		return "No Button clicked";
	}

	// Click button in list specified by name
	public String ClickAppIdButton(String Id, String ButtonName) {
		List<AndroidElement> buttons = ElementsId(Id);
		int Index = 0;
		int Count = 0;
		String BtnName = "";
		for (AndroidElement androidElement : buttons) {
			if (androidElement.getAttribute("name").contains(ButtonName)) {
				Index = Count;
				BtnName = buttons.get(Index).getAttribute("name");
				buttons.get(Index).click();
				return BtnName + " clicked";

			}
			Count++;

		}

		return "No Button clicked";
	}

	// Find name (text) specified element in class
	public String FindWebClassElement(String ClassName, String ElementText) {
		List<AndroidElement> elements = ElementsClass(ClassName);
		int Index = 0;
		int Count = 0;
		String ElementName = "";
		for (AndroidElement androidElement : elements) {
			if (androidElement.getAttribute("name").contains(ElementText)) {
				Index = Count;
				ElementName = elements.get(Index).getAttribute("name");
				// elements.get(Index).click();
				return ElementName;

			}
			Count++;

		}

		return "Element not found";
	}

	// CARD TYPE
	// Validate Card Type Page
	public String validateCardTypePage() {
		// Validate Choose a Card Type page
		String Logs = "";
		try {
			CustomWaitForElementClass(cardSetupPageObject.getCardRadioClass(), 30);
			Logs = "Card radio option found";
		} catch (Exception e) {
			Logs = "No card type found";
		}

		List<AndroidElement> titles = ElementsClass(cardSetupPageObject.getSubTitleClass());
		assertEquals(titles.get(0).getAttribute("name"), cardSetupPageObject.getSubTitle());
		Logs += "\nChoose card page validated: " + titles.get(0).getAttribute("name");

		return Logs;
	}

	// Select VISA Card
	public String selectVISA() {
		String Logs = "";

		List<AndroidElement> options = ElementsClass(cardSetupPageObject.getCardRadioClass());
		String selectedOption = options.get(1).getAttribute("name");
		options.get(1).click();
		Logs = "Card type selected: " + selectedOption;
		return Logs;
	}

	// PAYSTACK PAYMENT
	// Validate Paystack Page
	public String ValidatePaystackPage() throws InterruptedException {

		CustomWaitForElementClass("android.widget.Image", 20);
		Thread.sleep(2000);
		List<AndroidElement> views = ElementsClass("android.view.View");
		Waiter(views.get(12), "WHAT IS PAYSTACK?)", 5);
		assertEquals(views.get(12).getAttribute("name"), "WHAT IS PAYSTACK?");
		return "Paystack page validated";

	}

	// Enter Card Details
	public String EnterPaystackCardNumber(String CardNumber1, String CardNumber2, String CardNumber3,
			String CardNumber4, String CardNumber5) throws InterruptedException {
		List<AndroidElement> inputs = ElementsClass("android.widget.EditText");

		// Card Number
		inputs.get(0).sendKeys(CardNumber5);
		Thread.sleep(100);
		inputs.get(0).sendKeys(CardNumber4);
		Thread.sleep(100);
		inputs.get(0).sendKeys(CardNumber3);
		Thread.sleep(100);
		inputs.get(0).sendKeys(CardNumber2);
		Thread.sleep(100);
		inputs.get(0).sendKeys(CardNumber1);

		return "Card number entered: " + inputs.get(0).getAttribute("name");

	}

	public String EnterPaystackCardNumber2(String CardNumber) throws InterruptedException {
		List<AndroidElement> inputs = ElementsClass("android.widget.EditText");

		// Card Number
		inputs.get(0).sendKeys(CardNumber);

		return "Card number entered: " + inputs.get(0).getAttribute("name");

	}

	public boolean isFieldCorrect(String ExpiryDate, AndroidElement androidElement) {
		return androidElement.getAttribute("name").replaceAll("\\s", "").equals(ExpiryDate);
	}

	public String EnterPaystackCardExpDate(String ExpDate) throws InterruptedException {
		// Expiry Date
		List<AndroidElement> inputs = ElementsClass("android.widget.EditText");
		inputs.get(1).sendKeys(ExpDate);
		Thread.sleep(2000);

		Boolean valid = false; // reset expiry validity status

		// Validate expiry date
		while (valid == false) {
			valid = isFieldCorrect(ExpDate, inputs.get(1));
			if (!valid) {
				// logger.warn("Expiry date incorrect");
				// Enter Expiry
				try {
					inputs.get(1).clear();
					;
					inputs.get(1).sendKeys(ExpDate);
					// logger.info("Expiry date re-entered: "
					// + inputs.get(1).getAttribute("name"));

				} catch (Exception e) {
					// logger.error("Unable to re-enter expiry date");
				}

			} else {

			}
		}
		return "Expiry date entered: " + inputs.get(1).getAttribute("name");

	}

	// CVV
	public String EnterPaystackCVV(String CVV) {
		List<AndroidElement> inputs = ElementsClass("android.widget.EditText");
		inputs.get(2).sendKeys(CVV);
		return "CVV entered: " + inputs.get(2).getAttribute("name");

	}

	// Submit Card
	public String SubmitPaystackCard() {
		List<AndroidElement> buttons = ElementsClass("android.widget.Button");
		assertEquals(buttons.get(0).getAttribute("name"), "Pay NGN 50");
		String BtnName = buttons.get(0).getAttribute("name");
		buttons.get(0).click();
		return "Payment Button clicked: " + BtnName;

	}

	// Validate PIN Page
	public String ValidatePaystackPINPage() throws InterruptedException {
		CustomWaitForElementClass("android.widget.Image", 20);
		List<AndroidElement> views = ElementsClass("android.view.View");
		Waiter(views.get(5), "ENTER CARD PIN)", 5);
		assertEquals(views.get(5).getAttribute("name"), "ENTER CARD PIN");
		return "Paystack PIN page validated";

	}

	// Enter PIN
	public String EnterPaystackPIN() throws InterruptedException {
		List<AndroidElement> buttons = ElementsClass("android.widget.Button");
		Thread.sleep(1000);
		// logger.info("PIN: " + buttons.get(10).getAttribute("name"));
		buttons.get(10).click();
		buttons.get(10).click();
		buttons.get(10).click();
		buttons.get(10).click();
		Thread.sleep(1000);
		return "Card PIN entered";

	}

	// Validate Phone Number Page
	public String ValidatePaystackPhoneNumberPage() throws InterruptedException {
		CustomWaitForElementClass("android.widget.Image", 10);
		List<AndroidElement> views = ElementsClass("android.view.View");
		Waiter(views.get(5), "ENROLL PHONE)", 5);
		assertEquals(views.get(5).getAttribute("name"), "ENROLL PHONE");
		return "Paystack Phone Number page validated";

	}

	// Enter Phone Number
	public String EnterPaystackPhoneNumber() {
		List<AndroidElement> inputs = ElementsClass("android.widget.EditText");
		inputs.get(1).sendKeys("0123456789");
		return "Phone number Entered";

	}

	// Click Send OTP button
	public String RequestPaystackOTP() {
		List<AndroidElement> buttons = ElementsClass("android.widget.Button");
		String ButtonName = buttons.get(0).getAttribute("name");
		buttons.get(0).click();
		return "Button clicked: " + ButtonName;

	}

	// Validate OTP Page
	public String ValidatePaystackOTPPage() throws InterruptedException {
		CustomWaitForElementClass("android.widget.Image", 10);
		List<AndroidElement> views = ElementsClass("android.view.View");
		Waiter(views.get(5), "AUTHORIZATON REQUIRED)", 5);
		assertEquals(views.get(5).getAttribute("name"), "AUTHORIZATON REQUIRED");
		return "Paystack OTP page validated";

	}

	// Enter OTP
	public String EnterPaystackOTP(String OTP) {
		List<AndroidElement> inputs = ElementsClass("android.widget.EditText");
		inputs.get(0).sendKeys(OTP);
		return "OTP Entered";

	}

	// Click Authorize button
	public String ClickPaystackAuthorizeBtn() {
		List<AndroidElement> buttons = ElementsClass("android.widget.Button");
		String ButtonName = buttons.get(0).getAttribute("name");
		buttons.get(0).click();
		return "Button clicked: " + ButtonName;

	}

	// Select Date of Birth
	public String selectDate(String CalenderClass, String DOBDay, String DOBMonth, String DOBYear) {
		String Logs = "";
		List<AndroidElement> date = ElementsClass(CalenderClass);

		PickDate(Integer.valueOf(date.get(1).getAttribute("text")), Integer.valueOf(DOBDay),
				Integer.valueOf(date.get(2).getAttribute("text")), Integer.valueOf(DOBYear),
				date.get(0).getAttribute("text"), DOBMonth);

		String DateOfBirth = date.get(0).getAttribute("text") + "-";
		DateOfBirth += date.get(1).getAttribute("text") + "-";
		DateOfBirth += date.get(2).getAttribute("text");
		Logs += "\nDate of Birth selected: " + DateOfBirth;
		String DateOfBirth2 = DOBMonth + "-";
		DateOfBirth2 += DOBDay + "-";
		DateOfBirth2 += DOBYear;
		Logs += "\nDate of Birth expected: " + DateOfBirth2;
		// assertEquals(DateOfBirth, DateOfBirth2);

		// Check if selected Date was correct
		if (!DateOfBirth.equals(DateOfBirth2)) {
			date = ElementsClass(CalenderClass);
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
		}
		return Logs;
	}

	// Validate Phone Number
	public String validatePhonenumber(String PhoneNumber, String PhonenumberId) {
		String Logs = "";
		Boolean valid = false; // reset phone validity status

		while (valid == false) {
			valid = isPhoneCorrect(PhoneNumber, PhonenumberId);
			if (!valid) {
				Logs += "\nPhone number incorrect";
				// Enter Phone
				try {
					ClearText(PhonenumberId);
					SendKeysId(PhonenumberId, PhoneNumber);
					Logs += "\nPhone number re-entered: " + GetTextId(PhonenumberId);

				} catch (Exception e) {
					Logs += "\nUnable to re-enter phonenumber";
				}
				// Hide Keyboard
				try {
					getDriver().hideKeyboard();
					Logs += "\nKeyboard closed";
				} catch (Exception e) {
					Logs += "\nKeyboard aleady hidden";
				}
			} else {
				Logs += "\nPhone number validated";
			}
		}
		// assertEquals(GetTextId(signUpPageObject.getPhonenumberDescId()),
		// signUpPageObject.getPhonenumberDesc());

		return Logs;
	}

	// Check if Phone Number is correct
	private boolean isPhoneCorrect(String PhoneNumber, String PhonenumberId) {
		return GetTextId(PhonenumberId).replaceAll("\\s", "").equals(PhoneNumber);
	}

	// CHECK IF BUTTON IS ENABLED
	public Boolean isButtonIdEnabled(String ButtonId) {
		return getDriver().findElementById(ButtonId).isEnabled();
	}

	// To check text present
	// if(driver.getPageSource().contains("Text to check")){
	// System.out.println("Text is present");
	// }else{
	// System.out.println("Text is absent");
	// }

	// Left
	// appiumDriver.context("NATIVE_APP");
	// Dimension size = appiumDriver.manage().window().getSize();
	// int startx = (int) (size.width * 0.8);
	// int endx = (int) (size.width * 0.20);
	// int starty = size.height / 2;
	// appiumDriver.swipe(startx, starty, endx, starty, 1000);

	// Right
	// appiumDriver.context("NATIVE_APP");
	// Dimension size = appiumDriver.manage().window().getSize();
	// int endx = (int) (size.width * 0.8);
	// int startx = (int) (size.width * 0.20);
	// int starty = size.height / 2;
	// appiumDriver.swipe(startx, starty, endx, starty, 1000);

	// Vertical
	// public void verticalScroll()
	// {
	// Dimension size=driver.manage().window().getSize();
	// int y_start=(int)(size.height*0.60);
	// int y_end=(int)(size.height*0.30);
	// int x=size.width/2;
	// driver.swipe(x,y_start,x,y_end,4000);
	// }

	// TAP, ZOOM
	// MobileElement
	// abc=(MobileElement)driver.findElement(By.className("android.widget.CheckedTextView"));
	// abc.swipe(SwipeElementDirection.UP, 6000);
	// // abc.tap(left, duration);
	// abc.zoom();

	// Scroll
	// try {
	// WebElement element = getDriver().findElement(
	// By.xpath(elements.getMotherMaidenNameXpath()));
	// Actions actions = new Actions(getDriver());
	// actions.moveToElement(element);
	// // actions.click();
	// actions.perform();
	// logger.info("Page scrolled");
	// } catch (Exception e) {
	// logger.error("Unable to scroll page");
	// }

	// Scroll2
	// TouchAction action = new TouchAction(driver).longPress(20,20).moveTo(20,
	// 60).release();
	// action.perform();

}
