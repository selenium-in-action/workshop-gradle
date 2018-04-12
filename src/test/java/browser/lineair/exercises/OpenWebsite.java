package browser.lineair.exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenWebsite {

    @Test
    public void openSite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();

//        driver.manage().window().maximize();
//
//        driver.findElement(By.cssSelector("input")).clear();
//        driver.findElement(By.cssSelector("input")).sendKeys("");
//
//        WebElement el = driver.findElement(By.cssSelector("input"));
//        el.clear();
//        el.sendKeys("");

        driver.get("http://www.google.com");

        driver.quit();
    }
}
