package answers;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import answers.pages.ContactPage;
import answers.pages.HomePage;

/**
 * The goal of this exercise is to adjust an existing page.
 * 
 *
 */
@Test
public class Exercise3 extends AbstractTestBase {

	public void navigateToContactPage_contactPageShown() {
		final ContactPage contactPage = new HomePage(driver).get() //
				.navigateToContactPage();
		Assertions.assertThat(contactPage.getPageTitle()).isEqualTo("CUSTOMER SERVICE - CONTACT US");
	}
}
