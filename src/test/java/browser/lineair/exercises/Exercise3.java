package browser.lineair.exercises;

import org.testng.annotations.Test;

/**
 * The goal of this exercise is to verify the page title of the contactpage
 *
 */
@Test
public class Exercise3 extends AbstractTestBase {

	public void navigateToContactPage_contactPageShown() {
		// Navigeer naar website
		driver.get("http://demo.seleniuminaction.com");

	}
}
