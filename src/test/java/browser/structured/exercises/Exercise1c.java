package browser.structured.exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * The goal of this exercises is to fix the broken tests.
 *
 */
@Test
public class Exercise1c {

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

	public void waitForCountDown() {
		// Open website
		driver.get("https://stuntcoders.com/snippets/javascript-countdown/");

		WebElement countdown = driver.findElement(By.id("javascript_countdown_time"));

		System.out.println(countdown.getText());

		Assertions.assertThat(countdown.getText()).isEqualTo("01:01:00");
	}

}
