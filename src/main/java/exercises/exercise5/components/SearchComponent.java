package exercises.exercise5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import answers.exercise5.pages.SearchResultsPage;

public class SearchComponent {
	@FindBy(css = "input#search_query_top")
	private WebElement searchTextfield;

	@FindBy(css = "button[name='submit_search']")
	private WebElement searchButton;

	private WebDriver driver;

	public SearchComponent(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public SearchResultsPage searchFor(final String query) {
		searchTextfield.sendKeys(query);
		searchButton.click();
		return new SearchResultsPage(driver);
	}
}
