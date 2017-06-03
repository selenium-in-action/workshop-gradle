package structured.answers;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Test
public class FormShowDiv extends AbstractTestBase {

	public void waitForSuccessMessage() {
		driver.get("http://www.selenium-in-action.io/examples/FormShowDiv.html");

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-success")).isDisplayed()).isEqualTo(false);

		driver.findElement(By.cssSelector("input#firstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input#email")).sendKeys("foo@bar.com");

		driver.findElement(By.cssSelector("button")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector(".alert-success")).isDisplayed()).isEqualTo(true);
	}

}
