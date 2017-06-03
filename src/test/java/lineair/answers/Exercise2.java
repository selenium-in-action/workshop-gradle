package lineair.answers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to search for products.
 * 
 *
 */
@Test
public class Exercise2 extends AbstractTestBase {

	public void submitSearch_shouldDisplayResult() {
		driver.get("http://demo.selenium-in-action.io/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("shirt");
		driver.findElement(By.cssSelector("button[name='submit_search']")).click();

		// Java 7
		// final List<String> productNames = new ArrayList<>();
		// final List<WebElement> nameEl = driver.findElements(By.cssSelector("ul.product_list a.product-name"));
		// for (final WebElement el : nameEl) {
		// productNames.add(el.getText());
		// }

		// Java 8
		final List<String> productNames = driver.findElements(By.cssSelector("ul.product_list a.product-name")).stream().map(WebElement::getText)
				.collect(Collectors.toList());

		Assertions.assertThat(productNames).contains("Faded Short Sleeves T-shirt");
	}
}
