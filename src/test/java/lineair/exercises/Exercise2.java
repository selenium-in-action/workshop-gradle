package lineair.exercises;

import org.testng.annotations.Test;

/**
 * The goal of this exercise is to search for products.
 * 
 *
 */
@Test
public class Exercise2 extends AbstractTestBase {

	public void submitSearch_shouldDisplayResult() {

		// Java 7
		// final List<String> productNames = new ArrayList<>();
		// final List<WebElement> nameEl = driver.findElements(By.cssSelector("ul.product_list a.product-name"));
		// for (final WebElement el : nameEl) {
		// productNames.add(el.getText());
		// }

		// Java 8
		// final List<String> productNames = driver.findElements(By.cssSelector("ul.product_list a.product-name")).stream().map(WebElement::getText)
		// .collect(Collectors.toList());

	}
}
