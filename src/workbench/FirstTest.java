package workbench;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstTest extends workbench.SimpleSetup {

	@Test
	public void firstTest() throws InterruptedException {

		// Click Menu Button
		try {
			getDriver().findElement(By.id("id"));
			System.out.println("App menu button clicked");
		} catch (Exception e) {
			System.out.println("Unable to click app menu button");
		}

	}

}
