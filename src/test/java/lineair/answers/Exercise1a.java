package lineair.answers;

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
		driver.findElement(By.cssSelector("input#passwd")).sendKeys("1qazxsw2");
		driver.findElement(By.cssSelector("button#SubmitLogin")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector("div#center_column > p")).getText())
				.isEqualTo("Welcome to your account. Here you can manage all of your personal information and orders.");
	}

	public void loginAccountDoesNotExist() {

		driver.get("http://demo.selenium-in-action.io/index.php");

		driver.findElement(By.cssSelector("a.login")).click();

		driver.findElement(By.cssSelector("input#email")).sendKeys("1234@test.com");
		driver.findElement(By.cssSelector("input#passwd")).sendKeys("1qazxsw2");
		driver.findElement(By.cssSelector("button#SubmitLogin")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed()).isEqualTo(true);
	}

}
