package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exercises.pages.ContactPage;
import exercises.pages.HomePage;
import util.File;
import util.Os;

/**
 * The goal of this exercise is to adjust an existing page. Verify the title of the page
 * 
 *
 */
@Test
public class Exercise3 {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		// Determine OS
		final String os = Os.getOs();

		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", File.findFileOnPath("drivers/" + os + "/chromedriver")); // geckodriver
		// System.setProperty("webdriver.gecko.driver", findFileOnPath("drivers/mac/geckodriver")); // geckodriver
		driver = new ChromeDriver();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

	public void navigateToContactPage_contactPageShown() {
		final ContactPage contactPage = new HomePage(driver).get() //
				.navigateToContactPage();

		// ...

	}
}
