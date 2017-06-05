package structured.exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.DriverPath;
import util.FileUtil;

/**
 * The goal of this exercise is to create a new page object. (Forgot Password)
 * 
 *
 */

@Test
public class Exercise4 {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", FileUtil.findFileOnPath(DriverPath.getChromeDriver())); // geckodriver
		// System.setProperty("webdriver.gecko.driver", findFileOnPath("drivers/mac/geckodriver")); // geckodriver
		driver = new ChromeDriver();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

	public void requestNewPasswordExistingUser_SuccessMessageShown() {
	}

	public void requestNewPasswordNonExistingUser_SuccessMessageShown() {
	}
}
