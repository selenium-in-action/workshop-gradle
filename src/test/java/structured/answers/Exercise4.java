package structured.answers;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import answers.pages.ForgotPasswordPage;
import answers.pages.HomePage;

/**
 * The goal of this exercise is to create a new page object. (Forgot Password)
 * 
 *
 */

@Test
public class Exercise4 extends AbstractTestBase {

	public void requestNewPasswordExistingUser_SuccessMessageShown() {
		final ForgotPasswordPage page = new HomePage(driver).get() //
				.clickOnLogin() //
				.clickOnForgotPassword() //
				.requestNewPassword("-1137205466tetser@test.com");

		Assertions.assertThat(page.getMessages()).contains("A confirmation email has been sent to your address: -1137205466tetser@test.com");
	}

	public void requestNewPasswordNonExistingUser_SuccessMessageShown() {
		final ForgotPasswordPage page = new HomePage(driver).get() //
				.clickOnLogin() //
				.clickOnForgotPassword() //
				.requestNewPassword("Test@test.com");

		Assertions.assertThat(page.getMessages()).contains("There is 1 error\nThere is no account registered for this email address.");
	}
}
