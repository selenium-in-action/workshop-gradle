package lineair.exercises;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * The goal of this exercises is to register a new account
 *
 */
@Test
public class Exercise1b extends AbstractTestBase {

	public void registerNewAccount() {
		final String rand = Integer.toString(new Random().nextInt());

		// here some code

		Assertions.assertThat(driver.findElement(By.cssSelector("div#center_column > p")).getText()).isEqualTo("Your account has been created.");
	}
}
