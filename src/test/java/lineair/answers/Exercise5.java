package lineair.answers;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * The goal of this test is to complete the contactform
 *
 */
@Test
public class Exercise5 extends AbstractTestBase {

	public void completeContactForm_confirmationShown() {
		driver.get("http://demo.selenium-in-action.io/index.php?controller=contact");

		new Select(driver.findElement(By.cssSelector("select#id_contact"))).selectByVisibleText("Customer service");
		driver.findElement(By.cssSelector("input#email")).sendKeys("email@test.com");
		driver.findElement(By.cssSelector("input#id_order")).sendKeys("order4321");
		driver.findElement(By.cssSelector("textarea#message")).sendKeys("The product arrived with damages.");
		driver.findElement(By.cssSelector("button#submitMessage")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector("p.alert-success")).getText())
				.isEqualTo("Your message has been successfully sent to our team.");
	}

	public void invalidEmailGiven_shouldShowErrorMessage() {
		driver.get("http://demo.selenium-in-action.io/index.php?controller=contact");

		new Select(driver.findElement(By.cssSelector("select#id_contact"))).selectByVisibleText("Customer service");
		driver.findElement(By.cssSelector("input#email")).sendKeys("email");
		driver.findElement(By.cssSelector("input#id_order")).sendKeys("order4321");
		driver.findElement(By.cssSelector("textarea#message")).sendKeys("The product arrived with damages.");
		driver.findElement(By.cssSelector("button#submitMessage")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector("div.alert ol>li")).getText()).isEqualTo("Invalid email address.");
	}
}
