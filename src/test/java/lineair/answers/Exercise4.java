package lineair.answers;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The goal of this exercise is to request a new password
 * 
 *
 */

@Test
public class Exercise4 extends AbstractTestBase {

	public void requestNewPasswordExistingUser_SuccessMessageShown() {
		getDriver().get("http://demo.seleniuminaction.com/index.php");

		getDriver().findElement(By.cssSelector("a.login")).click();
		getDriver().findElement(By.cssSelector(".lost_password a")).click();

		getDriver().findElement(By.cssSelector("#email")).sendKeys("-1137205466tetser@test.com");
		getDriver().findElement(By.xpath("//button/span[text() = 'Retrieve Password']")).click();

		final List<String> messages = getDriver().findElements(By.cssSelector(".alert")).stream().map(WebElement::getText).collect(Collectors.toList());

		Assertions.assertThat(messages).contains("A confirmation email has been sent to your address: -1137205466tetser@test.com");
	}

	public void requestNewPasswordNonExistingUser_SuccessMessageShown() {
		getDriver().get("http://demo.seleniuminaction.com/index.php");

		getDriver().findElement(By.cssSelector("a.login")).click();
		getDriver().findElement(By.cssSelector(".lost_password a")).click();

		getDriver().findElement(By.cssSelector("#email")).sendKeys("Test@test.com");
		getDriver().findElement(By.xpath("//button/span[text() = 'Retrieve Password']")).click();

		final List<String> messages = getDriver().findElements(By.cssSelector(".alert")).stream().map(WebElement::getText).collect(Collectors.toList());

		Assertions.assertThat(messages).contains("There is 1 error\nThere is no account registered for this email address.");
	}
}
