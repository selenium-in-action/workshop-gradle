package answers.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends AbstractPage<AuthenticationPage> {

	@FindBy(css = "input#email")
	private WebElement emailTextfield;

	@FindBy(css = "input#passwd")
	private WebElement passwordTextfield;

	@FindBy(css = "input#email_create")
	private WebElement emailCreatTextfield;

	@FindBy(css = "button#SubmitLogin")
	private WebElement loginButton;

	@FindBy(css = "button#SubmitCreate")
	private WebElement createNewButton;

	@FindBy(css = ".lost_password a")
	private WebElement forgotPasswordLink;

	@FindBy(css = ".alert-danger")
	private WebElement alert;

	public AuthenticationPage(final WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {
		// Open the page
		driver.get("http://demo.seleniuminaction.com/index.php?controller=authentication");
	}

	@Override
	protected void isLoaded() throws Error {
		// verify if the correct page is open
		Assertions.assertThat(driver.getTitle()).startsWith("Login");
	}

	public MyAccountPage loginWith
			(final String email, final String password) {
		emailTextfield.sendKeys(email);
		passwordTextfield.sendKeys(password);
		loginButton.click();
		return new MyAccountPage(driver);
	}

	public boolean isAlertPresent() {
		return alert.isDisplayed();
	}

	public AccountCreationPage createNewAccount(final String email) {
		emailCreatTextfield.sendKeys(email);
		createNewButton.click();
		return new AccountCreationPage(driver);
	}

	public ForgotPasswordPage clickOnForgotPassword() {
		forgotPasswordLink.click();
		return new ForgotPasswordPage(driver);
	}

}
