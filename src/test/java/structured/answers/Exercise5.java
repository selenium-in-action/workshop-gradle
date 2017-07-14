package structured.answers;

import answers.exercise5.pages.HomePage;
import answers.exercise5.pages.SearchResultsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * The goal of this exercise is to refactor pageobjects. (extract components)
 * 
 */
@Test
public class Exercise5 extends AbstractTestBase {

	public void submitSearch_shouldDisplayResult() {
		new HomePage(getDriver()).get().searchComponent().searchFor("shirt");

		Assertions.assertThat(new SearchResultsPage(getDriver()).getProductNames()).contains("Faded Short Sleeves T-shirt");
	}

}
