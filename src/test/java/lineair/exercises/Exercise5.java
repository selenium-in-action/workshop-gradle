package lineair.exercises;

import org.testng.annotations.Test;

/**
 * The goal of this test is to complete the contactform
 *
 */
@Test
public class Exercise5 extends AbstractTestBase {

	public void completeContactForm_confirmationShown() {
		driver.get("http://demo.selenium-in-action.io/index.php?controller=contact");

	}

	public void invalidEmailGiven_shouldShowErrorMessage() {

	}
}
