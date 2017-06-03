package structured.answers;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import answers.pages.AuthenticationPage;
import answers.pages.HomePage;
import answers.pages.MyAccountPage;

/**
 * The goal of this exercises is to fix the broken tests.
 * 
 */

@Test
public class Exercise1a extends AbstractTestBase {

	public void loginSuccess() {
		final MyAccountPage accountPage = new HomePage(driver) //
				.get() //
				.clickOnLogin() //
				.loginWith("tester@test.com", "1qazxsw2");

		Assertions.assertThat(accountPage.getWelcomeMessage())
				.isEqualTo("Welcome to your account. Here you can manage all of your personal information and orders.");
	}

	public void loginAccountDoesNotExist() {
		final AuthenticationPage authenticationPage = new HomePage(this.driver) //
				.get() //
				.clickOnLogin();
		authenticationPage.loginWith("1234@test.com", "1qazxsw2");

		Assertions.assertThat(authenticationPage.isAlertPresent()).isEqualTo(true);
	}

}