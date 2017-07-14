package structured.answers;

import answers.pages.AuthenticationPage;
import answers.pages.HomePage;
import answers.pages.MyAccountPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * The goal of this exercises is to fix the broken tests.
 * 
 */

@Test
public class Exercise1a extends AbstractTestBase {

	public void loginSuccess() {
		final MyAccountPage accountPage = new HomePage(getDriver()) //
				.get() //
				.clickOnLogin() //
				.loginWith("tester@test.com", "1qazxsw2");

		Assertions.assertThat(accountPage.getWelcomeMessage())
				.isEqualTo("Welcome to your account. Here you can manage all of your personal information and orders.");
	}

	public void loginAccountDoesNotExist() {
		final AuthenticationPage authenticationPage = new HomePage(getDriver()) //
				.get() //
				.clickOnLogin();
		authenticationPage.loginWith("1234@test.com", "1qazxsw2");

		Assertions.assertThat(authenticationPage.isAlertPresent()).isEqualTo(true);
	}

}
