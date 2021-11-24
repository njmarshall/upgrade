package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.ui.BasePage;

public class BorrowerInfoPage extends BasePage {

    private final By FIRST_NAME_LOCATOR = By.name("borrowerFirstName");
    private final By LAST_NAME_LOCATOR = By.name("borrowerLastName");
    private final By HOME_ADDRESS_LOCATOR = By.name("borrowerStreet");
    private final By FIRST_GEO_SUGGESTION_LOCATOR = By.xpath("//*[@class='geosuggest__item'][1]");
    private final By CITY_LOCATOR = By.name("borrowerCity");
    private final By STATE_LOCATOR = By.name("borrowerState");
    private final By ZIP_CODE_LOCATOR = By.name("borrowerZipCode");
    private final By DATE_OF_BIRTH_LOCATOR = By.name("borrowerDateOfBirth");
    private final By SUBMIT_LOCATOR = By.xpath("//button[contains(text(), 'Continue')]");

    public BorrowerInfoPage(final WebDriver driver) {
        super(driver);
        waitForElementToAppear(FIRST_NAME_LOCATOR);
    }

    public void enterFirstName(final String value) {
        enterInputField(FIRST_NAME_LOCATOR, value);
    }

    public void enterLastName(final String value) {
        enterInputField(LAST_NAME_LOCATOR, value);
    }

    public void enterHomeAddress(final String value) {
        enterInputField(HOME_ADDRESS_LOCATOR, value);
        waitForElementToAppear(FIRST_GEO_SUGGESTION_LOCATOR);
        actions.sendKeys(Keys.ESCAPE);
    }

    public void enterCity(final String value) {
        enterInputField(CITY_LOCATOR, value);
    }

    public void enterState(final String value) {
        enterInputField(STATE_LOCATOR, value);
    }

    public void enterZipCode(final String value) {
        enterInputField(ZIP_CODE_LOCATOR, value);
    }

    public void enterDateOfBirth(final String value) {
        enterInputField(DATE_OF_BIRTH_LOCATOR, value);
    }

    public void submit() {
        clickElement(SUBMIT_LOCATOR);
    }
}
