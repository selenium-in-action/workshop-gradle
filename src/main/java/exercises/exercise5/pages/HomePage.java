package exercises.exercise5.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import answers.exercise5.components.SearchComponent;

public class HomePage extends AbstractPage<HomePage> {

	private SearchComponent searchComponent;

	public HomePage(final WebDriver driver) {
		super(driver);
		this.searchComponent = new SearchComponent(driver);
	}

	@Override
	protected void load() {
		// Open the page
		driver.get("http://demo.selenium-in-action.io/index.php");
	}

	@Override
	protected void isLoaded() throws Error {
		// verify if the correct page is open
		Assert.assertTrue("FashionShop".equals(driver.getTitle()));
	}

	public SearchComponent searchComponent() {
		return searchComponent;
	}
}
