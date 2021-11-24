package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.ui.BasePage;

public class CheckYourRatePage extends BasePage {

    private final By LOAN_AMOUNT_LOCATOR = By.name("desiredAmount");
    private final By LOAN_PURPOSE_LOCATOR = By.name("loan-purpose");
    private final By SUBMIT_LOCATOR = By.xpath("//button[contains(text(), 'Check your rate')]");

    public CheckYourRatePage(final WebDriver driver) {
        super(driver);
        waitForElementToAppear(LOAN_AMOUNT_LOCATOR);
    }

    public void enterLoanAmount(final String amount) {
        enterInputField(LOAN_AMOUNT_LOCATOR, amount);
    }

    public void selectLoanPurpose(final String purpose) {
        selectDropDownValueByText(LOAN_PURPOSE_LOCATOR, purpose);
    }

    public void submit() {
        clickElement(SUBMIT_LOCATOR);
    }
}
