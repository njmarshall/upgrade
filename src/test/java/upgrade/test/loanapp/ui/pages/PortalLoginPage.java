package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.core.ConfigManager;
import upgrade.test.framework.ui.BasePage;

/**
 * Page object for the Upgrade portal sign-in page.
 * Navigates to the portal login URL on construction and waits for the
 * "Welcome Back!" header to confirm the page has loaded.
 */
public class PortalLoginPage extends BasePage {

    private final By WELCOME_BACK_HEADER =
            By.xpath("//h2[text()='Welcome Back!']");
    private final By EMAIL_ADDRESS_LOCATOR =
            By.name("username");
    private final By PASSWORD_LOCATOR =
            By.name("password");
    private final By SIGN_IN_LOCATOR =
            By.xpath("//button[contains(text(), 'Sign in to your account')]");

    public PortalLoginPage(final WebDriver driver) {
        super(driver);
        driver.get(ConfigManager.getInstance().get("ui.portal.login.url",
                "https://www.credify.tech/portal/login"));
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