package structured.exercises;

import java.util.Random;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exercises.pages.HomePage;
import exercises.pages.MyAccountPage;
import exercises.types.Title;
import util.File;
import util.Os;

/**
 * The goal of this exercises is to fix the broken test(s).
 *
 */
@Test
public class Exercise1b {

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

	public void registerNewAccount() {
		final String rand = Integer.toString(new Random().nextInt());
		final MyAccountPage accountPage = new HomePage(driver).get() //
				.clickOnLogin() //
				.createNewAccount(rand + "tetser@test.com") //
				.setTitle(Title.MR) //
				.setFirstname("T") //
				.setLastname("Tester") //
				.setPassword("1qazxsw2") //
				.setDob("12", "1", "1986")//
				.clickOnRegister();

		Assertions.assertThat(accountPage.getWelcomeMessage()).isEqualTo("Your account has been created.");
	}
}
