package browser.structured.exercises;

import exercises.pages.ContactPage;
import exercises.pages.HomePage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to adjust an existing page. Verify the title of the page
 * 
 *
 */
@Test
public class Exercise3 {

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

	public void navigateToContactPage_contactPageShown() {
		final ContactPage contactPage = new HomePage(driver).get() //
				.navigateToContactPage();

		// ...

	}
}
