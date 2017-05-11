package answers;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import answers.exercise5.pages.HomePage;
import answers.exercise5.pages.SearchResultsPage;

/**
 * The goal of this exercise is to refactor pageobjects. (extract components)
 * 
 */
@Test
public class Exercise5 extends AbstractTestBase {

	public void submitSearch_shouldDisplayResult() {
		new HomePage(driver).get().searchComponent().searchFor("shirt");

		Assertions.assertThat(new SearchResultsPage(driver).getProductNames()).contains("Faded Short Sleeves T-shirt");
	}

}
