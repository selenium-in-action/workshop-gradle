package answers.exercise5.pages;

import answers.exercise5.components.SearchComponent;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage<HomePage> {

	private SearchComponent searchComponent;

	public HomePage(final WebDriver driver) {
		super(driver);
		this.searchComponent = new SearchComponent(driver);
	}

	@Override
	protected void load() {
		// Open the page
		driver.get("http://demo.seleniuminaction.com/index.php");
	}

	@Override
	protected void isLoaded() throws Error {
		// verify if the correct page is open
		Assertions.assertThat("FashionShop").isEqualTo(driver.getTitle());
	}

	public SearchComponent searchComponent() {
		return searchComponent;
	}
}
