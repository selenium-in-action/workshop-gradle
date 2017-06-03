package structured.answers;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Test
public class FormWithDisabledButton extends AbstractTestBase {

	public void submitForm() {
		driver.get("http://selenium-in-action.io/examples/FormWithDisabledButton.html");

		Assertions.assertThat(driver.findElement(By.cssSelector("button[type=submit]")).isEnabled()).isEqualTo(false);

		driver.findElement(By.cssSelector("input#username")).sendKeys("John");
		driver.findElement(By.cssSelector("input#password")).sendKeys("pass");

		driver.findElement(By.cssSelector("body")).click();

		Assertions.assertThat(driver.findElement(By.cssSelector("button[type=submit]")).isEnabled()).isEqualTo(true);
	}

}
