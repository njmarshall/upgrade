package upgrade.test.framework.ui.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility methods for common Selenium operations that don't belong
 * in a specific page object.
 */
public class SeleniumUtils {

    private SeleniumUtils() {
        // Utility class — not instantiable
    }

    /** Returns the browser's current URL. */
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    /**
     * Scrolls the given element into view using JavaScript.
     * Useful for elements that are off-screen and can't be clicked directly.
     */
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Waits up to {@code timeoutSeconds} for the page title to contain the given text.
     *
     * @return true if the title contained the text within the timeout, false otherwise
     */
    public static boolean waitForTitleContains(WebDriver driver, String titleFragment, int timeoutSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.titleContains(titleFragment));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Waits up to {@code timeoutSeconds} for the URL to contain the given fragment.
     *
     * @return true if the URL contained the fragment within the timeout, false otherwise
     */
    public static boolean waitForUrlContains(WebDriver driver, String urlFragment, int timeoutSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.urlContains(urlFragment));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Uses JavaScript to set an input field's value directly.
     * Useful for fields that reject normal sendKeys (e.g. date pickers).
     */
    public static void setValueViaJavaScript(WebDriver driver, WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];", element, value);
    }
}
