package workbench;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.apache.commons.net.telnet.TelnetClient;

public class SendLocation extends functionalTests.Helper {

	static TelnetClient tc = null;

	public InputStream inptStream;
	public PrintStream outptStream;
	public String prompt = "OK";

	@Test(groups = { "SendLocation.sendLocation" })
	public void login() throws InterruptedException, IOException {

		// Instantiate the telnet client -- we use this to send geo fix commands to the
		// emulator
		tc = new TelnetClient();

		// Connect, this will generate the auth_token if it does not already exist in
		// file system
		System.out.println("Trying to connect to AVD...");
		tc.connect("localhost", 5554);

		// Check to see if we are connected
		Boolean areWeConn = tc.isConnected();
		System.out.println("Are we connected?" + areWeConn);

		// Get input and output stream references
		System.out.println("Getting input and output streams...");
		inptStream = tc.getInputStream();
		outptStream = new PrintStream(tc.getOutputStream());

		// wait for OK prompt
		System.out.println("Waiting for the OK prompt...");
		// Not including readUntil() code because it's just reading terminal output
		// readUntil(prompt);

		// Send the auth token number
		System.out.println("Sending auth token...");
		outptStream.println("auth " + "FnkhOQPKjzowVP8u"); 
		outptStream.flush();

		// wait for OK prompt
		// System.out.println("Waiting for the OK prompt...");
		// readUntil(prompt);

		// Send current location for our Starting Point
		System.out.println("Sending Current Location - Starting Point");
		outptStream.println("geo fix -81.5812 28.4194");
		outptStream.flush();

		// Now disconnect from Telnet
		System.out.println("Disconnecting from AVD...");
		tc.disconnect();

		// Check to see if we are still connected
		Boolean stillConn = tc.isConnected();
		System.out.println("Are we still connected? " + stillConn);

	}

}
