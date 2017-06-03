package util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DisplayUtil {
	/**
	 * If exception occurs the element can't be visible
	 * 
	 */
	public static boolean isDisplayed(final WebDriver driver, final By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (final NoSuchElementException ex) {
			return false;
		}
	}

}
