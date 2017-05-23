package answers;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class DelayedForm extends AbstractTestBase {

	/**
	 * Doesn't work
	 */
	@Test(invocationCount = 10)
	public void waitForSuccessMessage() {
		driver.get("http://www.selenium-in-action.io/FormWithDelay.html");

		driver.findElement(By.cssSelector("input#firstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input#email")).sendKeys("foo@bar.com");

		driver.findElement(By.cssSelector("button")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-success")).isDisplayed()).isEqualTo(true);
	}

	/**
	 * Doesn't work, as the element is already visible in the DOM (only not visible)
	 */
	@Test(invocationCount = 10)
	public void waitForSuccessMessage_withImplicitlyWait() {
		driver.get("http://www.selenium-in-action.io/FormWithDelay.html");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("input#firstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input#email")).sendKeys("foo@bar.com");

		driver.findElement(By.cssSelector("button")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-success")).isDisplayed()).isEqualTo(true);
	}

	/**
	 * Doesn't work as you don't know how long you have to wait
	 * 
	 * @throws InterruptedException
	 */
	@Test(invocationCount = 10)
	public void waitForSuccessMessage_withSleep() throws InterruptedException {
		driver.get("http://www.selenium-in-action.io/FormWithDelay.html");

		driver.findElement(By.cssSelector("input#firstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input#email")).sendKeys("foo@bar.com");

		driver.findElement(By.cssSelector("button")).click();

		Thread.sleep(5000);

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-success")).isDisplayed()).isEqualTo(true);
	}

	/**
	 * Works, as long as the timeOutInSeconds isn't exceeds <br/>
	 * In this case we just wait as long as needed.
	 */
	@Test(invocationCount = 10)
	public void waitForSuccessMessage_withWait() {
		driver.get("http://www.selenium-in-action.io/FormWithDelay.html");

		driver.findElement(By.cssSelector("input#firstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input#email")).sendKeys("foo@bar.com");

		driver.findElement(By.cssSelector("button")).click();

		final WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".alert-success"))));

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-success")).isDisplayed()).isEqualTo(true);
	}

}
