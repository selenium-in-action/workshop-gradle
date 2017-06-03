package lineair.answers;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to request a new password
 * 
 *
 */

@Test
public class Exercise4 extends AbstractTestBase {

	public void requestNewPasswordExistingUser_SuccessMessageShown() {
		driver.get("http://demo.selenium-in-action.io/index.php");

		driver.findElement(By.cssSelector("a.login")).click();
		driver.findElement(By.cssSelector(".lost_password a")).click();

		driver.findElement(By.cssSelector("#email")).sendKeys("-1137205466tetser@test.com");
		driver.findElement(By.xpath("//button/span[text() = 'Retrieve Password']")).click();

		final List<String> messages = driver.findElements(By.cssSelector(".alert")).stream().map(WebElement::getText).collect(Collectors.toList());

		Assertions.assertThat(messages).contains("A confirmation email has been sent to your address: -1137205466tetser@test.com");
	}

	public void requestNewPasswordNonExistingUser_SuccessMessageShown() {
		driver.get("http://demo.selenium-in-action.io/index.php");

		driver.findElement(By.cssSelector("a.login")).click();
		driver.findElement(By.cssSelector(".lost_password a")).click();

		driver.findElement(By.cssSelector("#email")).sendKeys("Test@test.com");
		driver.findElement(By.xpath("//button/span[text() = 'Retrieve Password']")).click();

		final List<String> messages = driver.findElements(By.cssSelector(".alert")).stream().map(WebElement::getText).collect(Collectors.toList());

		Assertions.assertThat(messages).contains("There is 1 error\nThere is no account registered for this email address.");
	}
}
