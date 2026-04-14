package upgrade.test.framework.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Base class for all Page Objects.
 * Provides common Selenium interaction helpers and explicit wait strategies.
 * All page objects should extend this class and call super(driver) in their constructor.
 */
public class BasePage {

    public static final int TIMEOUT_BY_DEFAULT = 5;
    public static final int POLLING_BY_DEFAULT = 100;

    protected final WebDriver driver;
    protected final Actions actions;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this(driver, TIMEOUT_BY_DEFAULT, POLLING_BY_DEFAULT);
    }

    public BasePage(WebDriver driver, final int timeoutSeconds, final int pollingMs) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(timeoutSeconds),
                Duration.ofMillis(pollingMs));
        this.actions = new Actions(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeoutSeconds), this);
    }

    // -------------------------------------------------------------------------
    // Wait helpers
    // -------------------------------------------------------------------------

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    // -------------------------------------------------------------------------
    // Interaction helpers
    // -------------------------------------------------------------------------

    /**
     * Clears the input field before typing, preventing residual values
     * from prior test runs from corrupting input.
     */
    protected void enterInputField(By locator, String value) {
        WebElement field = waitForElement(locator);
        field.clear();
        field.sendKeys(value);
    }

    protected void selectDropDownValueByText(By locator, String value) {
        new Select(waitForElement(locator)).selectByVisibleText(value);
    }

    protected void clickElement(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    /**
     * Ensures a checkbox matches the expected selected state.
     * Uses SPACE key to toggle, which works across most browser/OS combos.
     */
    protected void selectCheckBox(By locator, boolean shouldBeSelected) {
        WebElement element = driver.findElement(locator);
        if (element.isSelected() != shouldBeSelected) {
            element.sendKeys(Keys.SPACE);
        }
    }

    // -------------------------------------------------------------------------
    // Query helpers
    // -------------------------------------------------------------------------

    /**
     * Returns true if at least one element matching the locator exists in the DOM.
     * Does not require the element to be visible.
     */
    protected boolean isElementPresent(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements != null && !elements.isEmpty();
    }

    protected String getText(By locator) {
        return waitForElement(locator).getText();
    }

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
