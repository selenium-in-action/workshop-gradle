package structured.answers;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.DisplayUtil;

@Test
public class FormAddDiv extends AbstractTestBase {

	/**
	 * Doesn't work, as the div is added to the DOM.
	 */
	public void waitForSuccessMessage() {
		driver.get("http://www.selenium-in-action.io/examples/FormAddDiv.html");

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-success")).isDisplayed()).isEqualTo(false);

		driver.findElement(By.cssSelector("input#firstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input#email")).sendKeys("foo@bar.com");

		driver.findElement(By.cssSelector("button")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-success")).isDisplayed()).isEqualTo(true);
	}

	public void waitForSuccessMessage_CustomIsDisplayed() {
		driver.get("http://www.selenium-in-action.io/examples/FormAddDiv.html");

		Assertions.assertThat(DisplayUtil.isDisplayed(driver, By.cssSelector(".alert-success"))).isEqualTo(false);

		driver.findElement(By.cssSelector("input#firstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input#email")).sendKeys("foo@bar.com");

		driver.findElement(By.cssSelector("button")).click();

		Assertions.assertThat(DisplayUtil.isDisplayed(driver, By.cssSelector(".alert-success"))).isEqualTo(true);
	}

}
