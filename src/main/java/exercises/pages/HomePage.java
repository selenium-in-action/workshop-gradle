package exercises.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage<HomePage> {

	@FindBy(css = "a.login")
	private WebElement loginLink;

	@FindBy(css = "#contact-link > a")
	private WebElement contactLink;

	@FindBy(css = "input#search_query_top")
	private WebElement searchTextfield;

	@FindBy(css = "button[name='submit_search']")
	private WebElement searchButton;

	public HomePage(final WebDriver driver) {
		super(driver);
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

	public AuthenticationPage clickOnLogin() {
		loginLink.click();
		return new AuthenticationPage(driver);
	}

	public ContactPage navigateToContactPage() {
		contactLink.click();
		return new ContactPage(driver);
	}

	public SearchResultsPage searchFor(final String query) {
		searchTextfield.sendKeys(query);
		searchButton.click();
		return new SearchResultsPage(driver);
	}

}
