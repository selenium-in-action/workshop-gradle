package utils.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Browser {

    FIREFOX {
        @Override
        public WebDriver initialize() {
            FirefoxDriverManager.getInstance().setup();
            return new FirefoxDriver();
        }
    },
    CHROME {
        @Override
        public WebDriver initialize() {
            ChromeDriverManager.getInstance().setup();
            final ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--start-fullscreen");
            return new ChromeDriver(chromeOptions);
        }
    },
    CHROME_HEADLESS {
        @Override
        public WebDriver initialize() {
            ChromeDriverManager.getInstance().setup();
            final ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            return new ChromeDriver(chromeOptions);
        }
    };

    public abstract WebDriver initialize();

    @Override
    public String toString() {
        switch (this) {
            case FIREFOX:
                return "FIREFOX";
            case CHROME:
                return "CHROME";
            case CHROME_HEADLESS:
                return "CHROME_HEADLESS";
            default:
                throw new IllegalArgumentException();
        }
    }
}
