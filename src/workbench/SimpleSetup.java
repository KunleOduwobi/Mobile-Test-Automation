package workbench;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SimpleSetup {

	public static AndroidDriver driver;

	public static AndroidDriver getDriver() {
		return driver;
	}

	@BeforeTest
	// Launch app
	public void setUp() throws MalformedURLException, InterruptedException {

		File app = new File("/path/to/app" + "AppName");

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		caps.setCapability("platformVersion", "5.1.1");

		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723" + "/wd/hub"), caps);

	}

	@AfterTest
	// Close App
	public void shutDown() throws IOException, InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}

}
