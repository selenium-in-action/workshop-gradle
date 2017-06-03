package lineair.answers;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to verify the page title of the contactpage
 *
 */
@Test
public class Exercise3 extends AbstractTestBase {

	public void navigateToContactPage_contactPageShown() {
		driver.get("http://demo.selenium-in-action.io/index.php");

		driver.findElement(By.cssSelector("#contact-link > a")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector("h1.page-heading")).getText()).isEqualTo("CUSTOMER SERVICE - CONTACT US");

		// or

		Assertions.assertThat(driver.getTitle()).isEqualTo("Contact us - FashionShop");
	}
}
