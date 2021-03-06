package browser.structured.answers;

import answers.pages.HomePage;
import answers.pages.SearchResultsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class DataDrivenSearchTest extends AbstractTestBase {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{ //
                {"Dress"}, //
                {"Sleeves"}, //
                {"Blouse"}, //
                {"T-shirt"} //
        };
    }

    @Test(dataProvider = "data")
    public void searchSuccess(final String query) {
        final SearchResultsPage searchResultsPage = new HomePage(getDriver()).get() //
                .searchFor(query);

        Assertions.assertThat(searchResultsPage.getResults().size()).isGreaterThan(0);
    }
}