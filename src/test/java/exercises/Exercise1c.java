package exercises;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.File;
import util.Os;

/**
 * The goal of this exercises is to fix the broken tests.
 *
 */
@Test
public class Exercise1c {

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

	public void waitForCountDown() {
		// Open website
		driver.get("https://stuntcoders.com/snippets/javascript-countdown/");

		WebElement countdown = driver.findElement(By.id("javascript_countdown_time"));

		System.out.println(countdown.getText());

		Assertions.assertThat(countdown.getText()).isEqualTo("01:01:00");
	}

}
