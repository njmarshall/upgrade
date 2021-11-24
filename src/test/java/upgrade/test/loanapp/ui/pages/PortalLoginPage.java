package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.ui.BasePage;

public class PortalLoginPage extends BasePage {

    private final String PORTAL_LOGIN_URL = "https://www.credify.tech/portal/login";
    private final By WELCOME_BACK_HEADER = By.xpath("//h2[text()='Welcome Back!']");
    private final By EMAIL_ADDRESS_LOCATOR = By.name("username");
    private final By PASSWORD_LOCATOR = By.name("password");
    private final By SIGN_IN_LOCATOR = By.xpath("//button[contains(text(), 'Sign in to your account')]");

    public PortalLoginPage(final WebDriver driver) {
        super(driver);
        driver.get(PORTAL_LOGIN_URL);
        waitForElementToAppear(WELCOME_BACK_HEADER);
    }

    public void enterEmailAddress(final String value) {
        enterInputField(EMAIL_ADDRESS_LOCATOR, value);
    }

    public void enterPassword(final String value) {
        enterInputField(PASSWORD_LOCATOR, value);
    }

    public void submit() {
        clickElement(SIGN_IN_LOCATOR);
    }
}
