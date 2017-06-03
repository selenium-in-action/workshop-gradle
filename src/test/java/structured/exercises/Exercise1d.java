package structured.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.File;
import util.Os;

/**
 * The goal of this exercise is to replace regular identifiers by angular identifiers
 *
 */
@Test
public class Exercise1d {

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

	public void addToDo() {
		driver.get("http://todomvc.com/examples/angularjs/#/");

		driver.findElement(By.cssSelector("new-todo")).sendKeys("new TODO");

		driver.findElement(By.cssSelector("#todo-form")).submit();

	}

}
