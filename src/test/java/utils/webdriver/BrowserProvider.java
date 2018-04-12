package utils.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserProvider {

    public static WebDriver createDriver() throws MalformedURLException {
        String browser = (isPropertySet("seleniumBrowser")) ? System.getProperty("seleniumBrowser").toUpperCase() : "CHROME";
        if (isProperty("seleniumGrid")) {
            return BrowserProvider.createDriver(new URL(System.getProperty("seleniumGridUrl")), Browser.valueOf(browser));
        } else {
            return BrowserProvider.createDriver(Browser.valueOf(browser));
        }
    }

    public static WebDriver createDriver(Browser browser) {
        return browser.initialize();
    }

    public static RemoteWebDriver createDriver(URL hubUrl, Browser browser, DesiredCapabilities capabilities) {
        capabilities.setBrowserName(browser.toString().toLowerCase());
        return new RemoteWebDriver(hubUrl, capabilities);
    }

    public static RemoteWebDriver createDriver(URL hubUrl, Browser browser) {
        return createDriver(hubUrl, browser, new DesiredCapabilities());
    }

    private static boolean isProperty(String propertyName) {
        return Boolean.valueOf(getProperty(propertyName));
    }

    private static String getProperty(String propertyName) {
        return System.getProperty(propertyName);
    }

    private static boolean isPropertySet(String propertyName) {
        String value = getProperty(propertyName);
        return !StringUtils.isEmpty(value);
    }
}
