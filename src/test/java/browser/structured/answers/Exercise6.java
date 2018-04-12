package browser.structured.answers;

import answers.pages.AuthenticationPage;
import answers.pages.HomePage;
import answers.pages.MyAccountPage;
import answers.types.Account;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to use an existing data object. (POJO)
 *
 */
@Test
public class Exercise6 extends AbstractTestBase {

	public void loginSuccess() {
		// This is the Account data object
		final Account account = new Account();
		account.setEmail("tester@test.com");
		account.setPassword("1qazxsw2");

		final MyAccountPage accountPage = new HomePage(getDriver()) //
				.get() //
				.clickOnLogin() //
				.loginWith(account.getEmail(), account.getPassword());

		Assertions.assertThat(accountPage.getWelcomeMessage())
				.isEqualTo("Welcome to your account. Here you can manage all of your personal information and orders.");
	}

	public void loginAccountDoesNotExist() {
		final Account account = new Account("1234@test.com", "1qazxsw2");

		final AuthenticationPage authenticationPage = new HomePage(this.getDriver()) //
				.get() //
				.clickOnLogin();
		authenticationPage.loginWith(account.getEmail(), account.getPassword());

		Assertions.assertThat(authenticationPage.isAlertPresent()).isEqualTo(true);
	}
}
