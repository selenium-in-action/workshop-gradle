package structured.exercises;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exercises.pages.AuthenticationPage;
import exercises.pages.HomePage;
import exercises.pages.MyAccountPage;
import util.DriverPath;
import util.FileUtil;

/**
 * The goal of this exercises is to fix the broken tests.
 * 
 */

@Test
public class Exercise1a {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		// Create a new instance of the Firefox driver
		System.out.println(DriverPath.getChromeDriver());
		System.setProperty("webdriver.chrome.driver", FileUtil.findFileOnPath(DriverPath.getChromeDriver())); // geckodriver
		// System.setProperty("webdriver.gecko.driver", findFileOnPath("drivers/mac/geckodriver")); // geckodriver
		driver = new ChromeDriver();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

	public void loginSuccess() {
		final MyAccountPage accountPage = new HomePage(driver) //
				.get() //
				.clickOnLogin() //
				.loginWith("tester@test.com", "1qazxsw2");

		Assertions.assertThat(accountPage.getWelcomeMessage())
				.isEqualTo("Welcome to your accounts. Here you can manage all of your personal information.");
	}

	public void loginAccountDoesNotExist() {
		final AuthenticationPage authenticationPage = new HomePage(this.driver) //
				.get() //
				.clickOnLogin();
		authenticationPage.loginWith("1234@test.com", "1qazxsw2");

		Assertions.assertThat(authenticationPage.isAlertPresent()).isEqualTo(false);
	}

}
