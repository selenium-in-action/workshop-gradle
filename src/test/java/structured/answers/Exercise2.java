package structured.answers;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import answers.pages.HomePage;
import answers.pages.SearchResultsPage;

/**
 * The goal of this exercise is to refactor this test class. Extracting the setup and teardown.
 * 
 *
 */
@Test
public class Exercise2 extends AbstractTestBase {

	public void submitSearch_shouldDisplayResult() {
		new HomePage(driver).get().searchFor("shirt");

		Assertions.assertThat(new SearchResultsPage(driver).getProductNames()).contains("Faded Short Sleeves T-shirt");
	}
}
