package browser.structured.exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to replace regular identifiers by angular identifiers
 *
 */
@Test
public class Exercise1d {

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

	public void addToDo() {
		driver.get("http://todomvc.com/examples/angularjs/#/");

		driver.findElement(By.cssSelector("new-todo")).sendKeys("new TODO");

		driver.findElement(By.cssSelector("#todo-form")).submit();

	}

}
