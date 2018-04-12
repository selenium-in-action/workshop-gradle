package browser.lineair.exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractTestBase {
    protected WebDriver driver;
    // protected RemoteWebDriver driver;

    @BeforeSuite
    public void setupDriverManager() {
        ChromeDriverManager.getInstance().setup();
//		OperaDriverManager.getInstance().version("2.27").forceDownload().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Create a new instance of the Chrome driver
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
