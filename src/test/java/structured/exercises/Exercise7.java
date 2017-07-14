package structured.exercises;

import exercises.pages.ContactPage;
import exercises.types.ContactSubject;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * The goal of this test is to create a new data object. (Contactform)
 *
 */
@Test
public class Exercise7 {
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
