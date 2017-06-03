package lineair.answers;

import java.net.MalformedURLException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import util.File;

public abstract class AbstractTestBase {
	// protected WebDriver driver;
	protected RemoteWebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException {
		// Create a new instance of the Firefox driver
		// System.setProperty("webdriver.chrome.driver", File.findFileOnPath(DriverPath.getDriver())); // geckodriver
		System.setProperty("webdriver.chrome.driver", File.findFileOnPath("drivers/mac/chromedriver")); // geckodriver
		driver = new ChromeDriver();

		// final DesiredCapabilities dr = DesiredCapabilities.chrome();
		// driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), dr);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}
