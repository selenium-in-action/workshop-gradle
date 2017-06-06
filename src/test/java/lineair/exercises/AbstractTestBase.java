package lineair.exercises;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import util.DriverPath;
import util.FileUtil;

public abstract class AbstractTestBase {
	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws MalformedURLException {
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", FileUtil.findFileOnPath(DriverPath.getChromeDriver())); // geckodriver
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
