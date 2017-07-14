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
		getDriver().get("http://demo.seleniuminaction.com/index.php");

		getDriver().findElement(By.cssSelector("#contact-link > a")).click();

		Assertions.assertThat(getDriver().findElement(By.cssSelector("h1.page-heading")).getText()).isEqualTo("CUSTOMER SERVICE - CONTACT US");

		// or

		Assertions.assertThat(getDriver().getTitle()).isEqualTo("Contact us - FashionShop");
	}
}
