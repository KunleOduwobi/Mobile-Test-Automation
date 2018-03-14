package functionalTests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

//import android.os.Build;

public class SetUp {
	public Boolean userSession;
	public static String HomeDir = System.getProperty("user.dir");;
	private static String sdkPath;
	private static String adbPath;
	private static String emulatorPath;
	private String EmulatorName = "Nexus5X";
//	private String AppName = "paylater-stagingv3.1_ng.apk";
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	// public Boolean EmulatorState;
	// SetUp appiumServer = new SetUp();

	// Get Emulator Path
	static {
		if (System.getenv("ANDROID_HOME") != null) {
			sdkPath = System.getenv("ANDROID_HOME");
		} else {
			sdkPath = System.getenv("HOME") + "/Library/Android/sdk";
		}
		adbPath = sdkPath + "/platform-tools" + File.separator + "adb";
		emulatorPath = sdkPath + "/tools" + File.separator + "emulator";
	}

	public static AndroidDriver driver;

	public static AndroidDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	@Parameters({ "port-number" })
	public void PreSetUp(int port) throws IOException {

//		if (!checkIfServerIsRunning(port)) {
//			startServer(port);
//			System.out.println(String.format("Server started successfully on port %s", port));
//		} else {
//			System.out.println("Appium Server already running on Port - "
//					+ port);
//		}
		// launchEmulator();
		// Remove old reports
		File dir = new File(HomeDir + "/test-output/screenshots/");
		cleanDirectory(dir);
//		File dir2 = new File(
//				"/Users/olukunle/.jenkins/workspace/PaylaterTest/Reports");
//		cleanDirectory(dir2);
	}

	// Use BeforeMethod for Data-Driven test, else use BeforeTest
	@BeforeTest
	@Parameters({ "app-session", "android-version", "port-number", "app-name", "deviceId" })
	// Launch app and accept app session
	public void setUp(Boolean appSession, String androidVersion,
			String PortNumber, String AppName, String DeviceId) throws MalformedURLException,
			InterruptedException {

		// Pass app session parameter
		userSession = appSession;
		File app = new File(HomeDir + "/apps/" + AppName);
		// server.startServer();

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", DeviceId);
		caps.setCapability("udid", DeviceId);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,
				MobilePlatform.ANDROID);
		caps.setCapability("platformVersion", androidVersion);
		// Use uiautomator 2 framework for Android 7 & up
		if (Float.parseFloat(androidVersion) > 6) {
			caps.setCapability("automationName", "uiautomator2");
		}
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		// caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		// Use app session
		if (userSession) {
			caps.setCapability("noReset", true);
			caps.setCapability("fullReset", false);
		}

		driver = new AndroidDriver(new URL("http://127.0.0.1:" + PortNumber
				+ "/wd/hub"), caps);

		// Configure Logger
		Logger logger = Logger.getLogger("SetUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		logger.info("App launched");

		// Thread.sleep(3000L);
	}

	@AfterTest
	@Parameters({ "TestMode" })
	// Close App
	public void shutDown(String TestMode) throws IOException,
			InterruptedException {
		screenshot(HomeDir + "/test-output/screenshots/", TestMode);
		// jenkinsScreenshot(HomeDir + ".jenkins/workspace/PaylaterTest/",
		// TestMode);
//		copyReport();
		Thread.sleep(3000);
		driver.quit();
		Logger logger = Logger.getLogger("SetUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");

		logger.info("App Closed");

	}

	@AfterSuite
	@Parameters({ "port-number" })
	// Close Emulator
	public void afterSuite(int port) {
		Logger logger = Logger.getLogger("SetUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
//		try {
//			stopServer();
//			logger.info("Appium Server stopped");
//		} catch (Exception e) {
//			logger.error("Unable to stop appium server");
//		}

	}

	// Start Emulator
	public void launchEmulator() {
		Logger logger = Logger.getLogger("SetUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		System.out.println("Starting emulator for '" + EmulatorName + "' ...");
		String[] aCommand = new String[] { emulatorPath, "-avd", EmulatorName };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(30, TimeUnit.SECONDS);
			logger.info("Emulator launched successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Emaulator failed to start");
		}
	}

	// Quit Emulator
	public void quitEmulator() {

		System.out.println("Killing emulator...");
		String[] aCommand = new String[] { adbPath, "emu", "kill" };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(1, TimeUnit.SECONDS);
			System.out.println("Emulator closed successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Emulator failed to close");
		}
	}

	// Take Screenshot
	public void screenshot(String path_screenshot, String testMode)
			throws IOException {
		File srcFile = getDriver().getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String filename = testMode + "_" + dateFormat.format(date).toString();
		// String filename=UUID.randomUUID().toString();
		File targetFile = new File(path_screenshot + filename + ".jpg");
		FileUtils.copyFile(srcFile, targetFile);
		Logger logger = Logger.getLogger("SetUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		logger.info("Screenshot taken");
	}

	public void jenkinsScreenshot(String path_screenshot, String FileName)
			throws IOException {
		File srcFile = getDriver().getScreenshotAs(OutputType.FILE);

		String filename = FileName;
		File targetFile = new File(path_screenshot + filename + ".jpg");
		FileUtils.copyFile(srcFile, targetFile);
		Logger logger = Logger.getLogger("SetUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		logger.info("Jenkins screenshot taken");
	}

	// Copy Output Files to Jenkins Workspace
	public void copyReport() {
		File source = new File(HomeDir + "/test-output/screenshots");
		File dest = new File(
				"/Users/olukunle/.jenkins/workspace/PaylaterTest/Reports");
		Logger logger = Logger.getLogger("SetUp");
		PropertyConfigurator.configure(HomeDir + "/log4j.properties");
		try {
			FileUtils.copyDirectory(source, dest);
			logger.info("files copied");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("files not copied");
		}
	}

	// Clean Directory
	public static void cleanDirectory(File directory) throws IOException {
		FileUtils.cleanDirectory(directory);

	}

	// Start Appium Server
	public void startServer(int port) {

		// Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(port);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		// Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		try {
			service.start();
			System.out.println("Appium server started on port " + port);
		} catch (Exception e) {
			System.out.println("The requested port may already be in use");
		}
	}

	public void stopServer() {
		// builder = new AppiumServiceBuilder();
		// builder.withIPAddress("127.0.0.1");
		// builder.usingPort(port);
		// builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		// builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		// Stop the server with the builder
//		service = AppiumDriverLocalService.buildService(builder);
		service.stop();
	}

	public boolean checkIfServerIsRunning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	// Check if Emulator is running
	// public static boolean isEmulator() {
	// return Build.FINGERPRINT.startsWith("generic")
	// || Build.FINGERPRINT.startsWith("unknown")
	// || Build.MODEL.contains("google_sdk")
	// || Build.MODEL.contains("Emulator")
	// || Build.MODEL.contains("Android SDK built for x86")
	// || Build.MANUFACTURER.contains("Genymotion")
	// || (Build.BRAND.startsWith("generic") && Build.DEVICE
	// .startsWith("generic"))
	// || "google_sdk".equals(Build.PRODUCT);
	// }

}
