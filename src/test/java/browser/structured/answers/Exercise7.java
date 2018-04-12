package browser.structured.answers;

import answers.pages.ContactPage;
import answers.types.ContactSubject;
import answers.types.ServiceDetails;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * The goal of this test is to create a new data object. (Contactform)
 *
 */
@Test
public class Exercise7 extends AbstractTestBase {

	public void completeContactForm_confirmationShown() {
		final ServiceDetails details = new ServiceDetails();
		details.setSubject(ContactSubject.CUSTOMER_SERVICE);
		details.setEmail("email@test.com");
		details.setReference("order4321");
		details.setMessage("The product arrived with damages.");

		final ContactPage contactPage = new ContactPage(getDriver()).get() //
				.completeForm(details.getSubject(), details.getEmail(), details.getReference(), details.getMessage());

		Assertions.assertThat(contactPage.getSuccessMessage()).isEqualTo("Your message has been successfully sent to our team.");
	}

	public void invalidEmailGiven_shouldShowErrorMessage() {
		final ServiceDetails details = new ServiceDetails();
		details.setSubject(ContactSubject.CUSTOMER_SERVICE);
		details.setEmail("email");
		details.setReference("order4321");
		details.setMessage("The product arrived with damages.");

		final ContactPage contactPage = new ContactPage(getDriver()).get() //
				.completeForm(details.getSubject(), details.getEmail(), details.getReference(), details.getMessage());

		Assertions.assertThat(contactPage.getErrorMessage()).isEqualTo("Invalid email address.");
	}
}
