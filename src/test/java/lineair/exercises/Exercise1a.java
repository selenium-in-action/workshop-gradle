package lineair.exercises;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * The goal of this exercises is to login.
 * 
 */

@Test
public class Exercise1a extends AbstractTestBase {

	public void loginSuccess() {
		driver.get("http://demo.selenium-in-action.io/index.php");

		driver.findElement(By.cssSelector("a.login")).click();

		driver.findElement(By.cssSelector("input#email")).sendKeys("tester@test.com");
	}

	public void loginAccountDoesNotExist() {
		// Here some code

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed()).isEqualTo(true);
	}

}
