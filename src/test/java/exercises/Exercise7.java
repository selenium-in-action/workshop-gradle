package exercises;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exercises.pages.ContactPage;
import exercises.types.ContactSubject;
import util.File;
import util.Os;

/**
 * The goal of this test is to create a new data object. (Contactform)
 *
 */
@Test
public class Exercise7 {

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

	public void completeContactForm_confirmationShown() {

		final ContactPage contactPage = new ContactPage(driver).get() //
				.completeForm(ContactSubject.CUSTOMER_SERVICE, "email@test.com", "order4321", "The product arrived with damages.");

		Assertions.assertThat(contactPage.getSuccessMessage()).isEqualTo("Your message has been successfully sent to our team.");
	}

	public void invalidEmailGiven_shouldShowErrorMessage() {
		final ContactPage contactPage = new ContactPage(driver).get() //
				.completeForm(ContactSubject.CUSTOMER_SERVICE, "email", "order4321", "The product arrived with damages.");

		Assertions.assertThat(contactPage.getErrorMessage()).isEqualTo("Invalid email address.");
	}
}
