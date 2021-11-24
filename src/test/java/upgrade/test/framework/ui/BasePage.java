package upgrade.test.framework.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public static final int TIMEOUT_BY_DEFAULT = 5;
    public static final int POLLING_BY_DEFAULT = 100;

    protected WebDriver driver;
    protected Actions actions;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT_BY_DEFAULT, POLLING_BY_DEFAULT);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT_BY_DEFAULT), this);
        actions = new Actions(driver);
    }

    public BasePage(WebDriver driver, final int timeOut, final int polling) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOut, polling);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOut), this);
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    protected void enterInputField(By locator, String value) {
        final WebElement inputField = driver.findElement(locator);
        inputField.sendKeys(value);
    }

    protected void selectDropDownValueByText(By locator, String value) {
        final WebElement selectField = driver.findElement(locator);
        new Select(selectField).selectByVisibleText(value);
    }

    protected void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    protected void selectCheckBox(By locator, boolean isExpectedSelected) {
        WebElement element = driver.findElement(locator);
        if (element.isSelected() != isExpectedSelected) {
            element.sendKeys(Keys.SPACE);
        }
    }

    protected boolean isElementPresent(By bySelector) {
        List<WebElement> elements = driver.findElements(bySelector);
        return elements == null ? false : true;
    }

    protected String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}
