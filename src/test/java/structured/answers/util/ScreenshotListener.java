package structured.answers.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import structured.answers.AbstractTestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotListener extends TestListenerAdapter {


    /**
     * Screenshot class that is called by listener to catch screenshot when test fails.<br>
     * <br>
     * Listener is implemented by adding new listener in testng file as
     * <li>< listener class-name="nl.essent.ui.listeners.ScreenshotListener" /><br>
     * <br>
     * File path is : /test-output/screenshots/
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(ScreenshotListener.class);

    private void captureScreenshot(final String path, final WebDriver driver) throws IOException {
        WebDriver augmentedDriver;
        try {
            augmentedDriver = new Augmenter().augment(driver);
        } catch (final Exception e) {
            LOGGER.debug("Unable to augment web driver, using original.", e);
            augmentedDriver = driver;
        }
        final File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(path));
        final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
        System.setProperty(ESCAPE_PROPERTY, "false");
        Reporter.log("<a href='" + path + "' target='_blank'>Screenshot</a>");
    }

    @Override
    public void onTestFailure(final ITestResult result) {
        super.onTestFailure(result);
        final Calendar now = Calendar.getInstance();
        final String sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(now.getTime());
        final String workingDirectory = System.getProperty("user.dir");
        final String screenshotPath = "/build/reports/tests/html/screenshots/";
        try {
            captureScreenshot(workingDirectory + screenshotPath + result.getName() + "_" + sdf + ".png",
                    ((AbstractTestBase) result.getInstance()).getDriver());
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }
    }
}