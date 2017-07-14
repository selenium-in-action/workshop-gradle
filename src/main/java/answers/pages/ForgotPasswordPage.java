package answers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ForgotPasswordPage extends AbstractPage<ForgotPasswordPage> {

	@FindBy(css = "#email")
	private WebElement emailField;

	@FindBy(xpath = "//button/span[text() = 'Retrieve Password']")
	private WebElement retrievePasswordButton;

	@FindBy(css = ".alert")
	private List<WebElement> messages;

	public ForgotPasswordPage(final WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {
		driver.get("http://demo.seleniuminaction.com/index.php?controller=password");
	}

	@Override
	protected void isLoaded() throws Error {
		// verify if the correct page is open
		Assert.assertTrue(driver.getTitle().startsWith("Forgot your password"));
	}

	public ForgotPasswordPage requestNewPassword(final String email) {
		emailField.sendKeys(email);
		retrievePasswordButton.click();
		return this;
	}

	public List<String> getMessages() {
		return messages.stream().map(WebElement::getText).collect(Collectors.toList());
	}

}
