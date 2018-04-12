package browser.structured.answers;

import answers.pages.ContactPage;
import answers.pages.HomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to adjust an existing page.
 * 
 *
 */
@Test
public class Exercise3 extends AbstractTestBase {

	public void navigateToContactPage_contactPageShown() {
		final ContactPage contactPage = new HomePage(getDriver()).get() //
				.navigateToContactPage();
		Assertions.assertThat(contactPage.getPageTitle()).isEqualTo("CUSTOMER SERVICE - CONTACT US");
	}
}
