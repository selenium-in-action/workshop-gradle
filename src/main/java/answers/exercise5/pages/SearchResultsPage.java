package answers.exercise5.pages;

import answers.types.SearchResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends AbstractPage<SearchResultsPage> {

	private Log log = LogFactory.getLog(SearchResultsPage.class);

	@FindBy(css = "ul.product_list a.product-name")
	private List<WebElement> productNames;

	@FindBy(xpath = "//ul[contains(@class,'product_list')]/li")
	private List<WebElement> productList;

	public SearchResultsPage(final WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {
		log.info("Can't navigate to the resultspage directly");
	}

	@Override
	protected void isLoaded() throws Error {
		Assertions.assertThat(driver.findElements(By.cssSelector("body#search"))).isNotEmpty();
	}

	public List<String> getProductNames() {
		return productNames.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<SearchResult> getResults() {
		return productList.stream().map(SearchResult::new).collect(Collectors.toList());
	}

}
