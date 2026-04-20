package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.ui.BasePage;
import upgrade.test.framework.ui.utils.SeleniumUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page object for the Loan Offer display page (/offer-page).
 * Uses an extended timeout since offer generation can take several seconds.
 */
public class OfferInfoPage extends BasePage {

    private static final int EXTENDED_TIMEOUT = 15;

    private final By YOUR_OFFERS_HEADER_LOCATOR =
            By.xpath("//h1[contains(text(), 'here are your offers')]");
    private final By MONTHLY_PAYMENT_LOCATOR =
            By.xpath("//h3[text()='Monthly Payment']/ancestor::li/div");
    private final By TERM_LOCATOR =
            By.xpath("//h3[text()='Term']/ancestor::li/div");
    private final By INTEREST_RATE_LOCATOR =
            By.xpath("//h3[text()='Interest Rate']/ancestor::li/div");
    private final By APR_LOCATOR =
            By.xpath("//h3/div[contains(text(), 'APR')]/ancestor::li/div");
    private final By MENU_SANDWICH_LOCATOR =
            By.className("header-nav__toggle");
    private final By SIGN_OUT_LOCATOR =
            By.linkText("Sign Out");

    public OfferInfoPage(final WebDriver driver) {
        super(driver, EXTENDED_TIMEOUT, BasePage.POLLING_BY_DEFAULT);
        waitForElementToAppear(YOUR_OFFERS_HEADER_LOCATOR);
        assertTrue(
                SeleniumUtils.getCurrentUrl(driver).contains("/offer-page"),
                "Expected URL to contain '/offer-page' but was: "
                        + SeleniumUtils.getCurrentUrl(driver));
    }

    public String getMonthlyPayment() {
        return getText(MONTHLY_PAYMENT_LOCATOR);
    }

    public String getTerm() {
        return getText(TERM_LOCATOR);
    }

    public String getInterestRate() {
        return getText(INTEREST_RATE_LOCATOR);
    }

    public String getApr() {
        return getText(APR_LOCATOR);
    }

    /**
     * Opens the navigation menu and clicks Sign Out.
     */
    public void signOut() {
        clickElement(MENU_SANDWICH_LOCATOR);
        waitForElementToAppear(SIGN_OUT_LOCATOR);
        clickElement(SIGN_OUT_LOCATOR);
    }
}