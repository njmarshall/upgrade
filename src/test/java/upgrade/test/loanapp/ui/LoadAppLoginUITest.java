package upgrade.test.loanapp.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upgrade.test.framework.core.ConfigManager;
import upgrade.test.framework.models.Borrower;
import upgrade.test.framework.models.LoanOffer;
import upgrade.test.framework.ui.BaseUITest;
import upgrade.test.loanapp.ui.pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * End-to-end UI tests for the Upgrade personal loan application flow.
 *
 * Test flow:
 *   1. Enter loan amount + purpose → Check Your Rate
 *   2. (Conditionally) skip the Fundera partner offer
 *   3. Fill out borrower personal + income + account info
 *   4. Capture the displayed loan offer
 *   5. Sign out, sign back in, and assert the loan offer is consistent
 */
@DisplayName("Loan Application UI Tests")
public class LoadAppLoginUITest extends BaseUITest {

    private Borrower borrowerData;

    @BeforeEach
    void setupData() {
        borrowerData = testData.getRandomBorrower();
        driver.get(ConfigManager.getInstance().getUiLoanAppUrl());
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    // -------------------------------------------------------------------------
    // Test Cases
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Full loan application flow: fill form, capture offer, sign out, sign in, verify offer persists")
    void fillOutPersonalLoanTest() {
        checkBorrowRate();
        skipFunderaOfferIfPresent();
        fillOutBorrowerInfo(borrowerData);

        LoanOffer capturedOffer = captureDisplayedLoanOffer();
        signOutThenBackIn();
        assertLoanOfferMatches(capturedOffer);
    }

    @Test
    @DisplayName("Loan application form submits successfully with valid borrower data")
    void formSubmitsWithValidDataTest() {
        checkBorrowRate();
        skipFunderaOfferIfPresent();
        fillOutBorrowerInfo(borrowerData);

        // Assert we have reached the offer page — a non-empty monthly payment is a proxy for success
        OfferInfoPage offerPage = new OfferInfoPage(driver);
        String monthlyPayment = offerPage.getMonthlyPayment();
        assertEquals(false, monthlyPayment == null || monthlyPayment.isEmpty(),
                "Expected a monthly payment value to be displayed after form submission");
    }

    // -------------------------------------------------------------------------
    // Private Helpers (workflow steps)
    // -------------------------------------------------------------------------

    private void checkBorrowRate() {
        CheckYourRatePage checkYourRate = new CheckYourRatePage(driver);
        checkYourRate.enterLoanAmount(Integer.toString(borrowerData.loanInfo.getAmount()));
        checkYourRate.selectLoanPurpose(borrowerData.loanInfo.getPurpose());
        checkYourRate.submit();
    }

    private void skipFunderaOfferIfPresent() {
        FunderaOfferPage funderaOffer = new FunderaOfferPage(driver);
        if (funderaOffer.logoImageExists(driver)) {
            funderaOffer.clickContinueUpgrade();
        }
    }

    private void fillOutBorrowerInfo(Borrower borrower) {
        // Step 1: Personal info
        BorrowerInfoPage borrowerInfo = new BorrowerInfoPage(driver);
        borrowerInfo.enterFirstName(borrower.getFirstName());
        borrowerInfo.enterLastName(borrower.getLastName());
        borrowerInfo.enterHomeAddress(borrower.getHomeAddress());
        borrowerInfo.enterCity(borrower.getCity());
        borrowerInfo.enterState(borrower.getState());
        borrowerInfo.enterZipCode(borrower.getZipCode());
        borrowerInfo.enterDateOfBirth(borrower.getDateOfBirth());
        borrowerInfo.submit();

        // Step 2: Income info
        IncomeInfoPage incomeInfo = new IncomeInfoPage(driver);
        incomeInfo.enterBorrowerIncome(Integer.toString(borrower.getIncome()));
        incomeInfo.enterBorrowerAdditionalIncome(Integer.toString(borrower.getAdditionalIncome()));
        incomeInfo.submit();
        incomeInfo.submit(); // second submit confirms income confirmation screen

        // Step 3: Account creation
        AccountInfoPage accountInfo = new AccountInfoPage(driver);
        accountInfo.enterEmailAddress(borrower.account.getEmail());
        accountInfo.enterPassword(borrower.account.getPassword());
        accountInfo.checkAgreements();
        accountInfo.submit();
    }

    private LoanOffer captureDisplayedLoanOffer() {
        OfferInfoPage offerInfo = new OfferInfoPage(driver);
        LoanOffer offer = new LoanOffer(
                offerInfo.getMonthlyPayment(),
                offerInfo.getTerm(),
                offerInfo.getInterestRate(),
                offerInfo.getAPR());
        offerInfo.signOut();
        return offer;
    }

    private void signOutThenBackIn() {
        PortalLoginPage portalLogin = new PortalLoginPage(driver);
        portalLogin.enterEmailAddress(borrowerData.account.getEmail());
        portalLogin.enterPassword(borrowerData.account.getPassword());
        portalLogin.submit();
    }

    private void assertLoanOfferMatches(LoanOffer expected) {
        OfferInfoPage actual = new OfferInfoPage(driver);
        assertEquals(expected.getMonthlyPayment(), actual.getMonthlyPayment(),
                "Monthly payment should match after re-login");
        assertEquals(expected.getTerm(), actual.getTerm(),
                "Term should match after re-login");
        assertEquals(expected.getInterestRate(), actual.getInterestRate(),
                "Interest rate should match after re-login");
        assertEquals(expected.getAPR(), actual.getAPR(),
                "APR should match after re-login");
    }
}
