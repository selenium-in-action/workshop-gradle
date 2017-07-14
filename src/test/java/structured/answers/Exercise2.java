package structured.answers;

import answers.pages.HomePage;
import answers.pages.SearchResultsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to refactor this test class. Extracting the setup and teardown.
 * 
 *
 */
@Test
public class Exercise2 extends AbstractTestBase {

	public void submitSearch_shouldDisplayResult() {
		new HomePage(getDriver()).get().searchFor("shirt");

		Assertions.assertThat(new SearchResultsPage(getDriver()).getProductNames()).contains("Faded Short Sleeves T-shirt");
	}
}
