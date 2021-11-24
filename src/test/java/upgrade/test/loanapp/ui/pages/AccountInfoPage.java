package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.ui.BasePage;

public class AccountInfoPage extends BasePage {

    private final By EMAIL_ADDRESS_LOCATOR = By.name("username");
    private final By PASSWORD_LOCATOR = By.name("password");
    private final By AGREEMENTS_LOCATOR = By.name("agreements");
    private final By SUBMIT_LOCATOR = By.xpath("//button[contains(text(), 'Check Your Rate')]");

    public AccountInfoPage(final WebDriver driver) {
        super(driver);
        waitForElementToAppear(EMAIL_ADDRESS_LOCATOR);
    }

    public void enterEmailAddress(final String value) {
        enterInputField(EMAIL_ADDRESS_LOCATOR, value);
    }

    public void enterPassword(final String value) {
        enterInputField(PASSWORD_LOCATOR, value);
    }

    public void checkAgreements() {
        selectCheckBox(AGREEMENTS_LOCATOR, true);
    }

    public void submit() {
        clickElement(SUBMIT_LOCATOR);
    }
}
