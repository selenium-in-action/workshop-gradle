package structured.exercises;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exercises.pages.HomePage;
import exercises.pages.SearchResultsPage;
import util.File;
import util.Os;

/**
 * The goal of this exercise is to refactor this test class. Extracting the setup and teardown.
 * 
 *
 */
@Test
public class Exercise2 {

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

	public void submitSearch_shouldDisplayResult() {
		new HomePage(driver).get().searchFor("shirt");

		Assertions.assertThat(new SearchResultsPage(driver).getProductNames()).contains("Faded Short Sleeves T-shirt");
	}
}
