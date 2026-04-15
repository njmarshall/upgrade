package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.ui.BasePage;

/**
 * Page object for the income information step of the loan application funnel.
 * Note: {@link #submit()} may need to be called twice — once to submit income
 * and once to confirm on the income-confirmation interstitial screen.
 */
public class IncomeInfoPage extends BasePage {

    private final By INCOME_LOCATOR =
            By.name("borrowerIncome");
    private final By ADDITIONAL_INCOME_LOCATOR =
            By.name("borrowerAdditionalIncome");
    private final By SUBMIT_LOCATOR =
            By.xpath("//button[contains(text(), 'Continue')]");

    public IncomeInfoPage(final WebDriver driver) {
        super(driver);
        waitForElementToAppear(INCOME_LOCATOR);
    }

    public void enterBorrowerIncome(final String value) {
        enterInputField(INCOME_LOCATOR, value);
    }

    public void enterBorrowerAdditionalIncome(final String value) {
        enterInputField(ADDITIONAL_INCOME_LOCATOR, value);
    }

    public void submit() {
        clickElement(SUBMIT_LOCATOR);
    }
}