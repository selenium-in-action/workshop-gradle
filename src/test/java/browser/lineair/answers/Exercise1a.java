package browser.lineair.answers;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * The goal of this exercises is to login.
 */

@Test
public class Exercise1a extends AbstractTestBase {

    public void loginSuccess() {
        getDriver().get("http://demo.seleniuminaction.com");

        getDriver().findElement(By.cssSelector("input#email")).sendKeys("tester@test.com");
        getDriver().findElement(By.cssSelector("input#passwd")).sendKeys("1qazxsw2");
        getDriver().findElement(By.cssSelector("button#SubmitLogin")).click();

        Assertions.assertThat(getDriver().findElement(By.cssSelector("div#center_column > p")).getText())
                .isEqualTo("Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    public void loginAccountDoesNotExist() {

        getDriver().get("http://demo.seleniuminaction.com");

        getDriver().findElement(By.cssSelector("a.login")).click();

        getDriver().findElement(By.cssSelector("input#email")).sendKeys("1234@test.com");
        getDriver().findElement(By.cssSelector("input#passwd")).sendKeys("1qazxsw2");
        getDriver().findElement(By.cssSelector("button#SubmitLogin")).click();

        Assertions.assertThat(getDriver().findElement(By.cssSelector(".alert-danger")).isDisplayed()).isEqualTo(true);
    }

}
