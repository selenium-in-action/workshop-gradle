package structured.answers;

import answers.pages.HomePage;
import answers.pages.MyAccountPage;
import answers.types.Title;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * The goal of this exercises is to fix the broken test(s).
 *
 */
@Test
public class Exercise1b extends AbstractTestBase {

	public void registerNewAccount() {
		final String rand = Integer.toString(new Random().nextInt());
		final MyAccountPage accountPage = new HomePage(getDriver()).get() //
				.clickOnLogin() //
				.createNewAccount(rand + "tetser@test.com") //
				.setTitle(Title.MR) //
				.setFirstname("T") //
				.setLastname("Tester") //
				.setPassword("1qazxsw2") //
				.setDob("12", "1", "1986")//
				.clickOnRegister();

		Assertions.assertThat(accountPage.getWelcomeMessage()).isEqualTo("Your account has been created.");
	}
}
