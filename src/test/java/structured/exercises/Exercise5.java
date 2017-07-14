package structured.exercises;

import exercises.pages.HomePage;
import exercises.pages.SearchResultsPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to refactor pageobjects. (extract Search functionality to an component)
 * 
 */
@Test
public class Exercise5 {

	protected WebDriver driver;

	@BeforeSuite
	public void setupDriverManager() {
		ChromeDriverManager.getInstance().setup();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		// Create a new instance of the Chrome driver
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
