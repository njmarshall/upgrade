package upgrade.test.loanapp.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upgrade.test.framework.models.Borrower;
import upgrade.test.framework.models.LoanOffer;
import upgrade.test.framework.ui.BaseUITest;
import upgrade.test.loanapp.ui.pages.*;

public class LoadAppLoginUITest extends BaseUITest {

    private Borrower borrowerData;
    private final String LOAD_APP_URL = "https://www.credify.tech/funnel/nonDMFunnel";

    @BeforeEach
    public void setupData() {
        borrowerData = testData.getRandomBorrower();
        driver.get(LOAD_APP_URL);
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void fillOutPersonalLoanTest() throws Exception {
        checkBorrowRate();
        skipFunderaOffer();
        fillOutBorrowerInfo(borrowerData);

        LoanOffer expectedLoanOffer = showLoanOfferAndExtractInfo();
        getSignInAndAssertLoanOfferInfo(expectedLoanOffer);
    }

    private void checkBorrowRate() {
        CheckYourRatePage checkYourRate = new CheckYourRatePage(driver);
        checkYourRate.enterLoanAmount(Integer.toString(borrowerData.loanInfo.getAmount()));
        checkYourRate.selectLoanPurpose(borrowerData.loanInfo.getPurpose());
        checkYourRate.submit();
    }

    private void skipFunderaOffer() {
        // Skip Fundera Offer and continue to the borrower info page
        FunderaOfferPage funderaOffer = new FunderaOfferPage(driver);
        if ( funderaOffer.logoImageExists(driver) ){
            funderaOffer.clickContinueUpgrade();
        }
    }

    private void fillOutBorrowerInfo(Borrower borrower) {
        // Fill out borrower info
        BorrowerInfoPage borrowerInfo = new BorrowerInfoPage(driver);
        borrowerInfo.enterFirstName(borrower.getFirstName());
        borrowerInfo.enterLastName(borrower.getLastName());
        borrowerInfo.enterHomeAddress(borrower.getHomeAddress());
        borrowerInfo.enterCity(borrower.getCity());
        borrowerInfo.enterState(borrower.getState());
        borrowerInfo.enterZipCode(borrower.getZipCode());
        borrowerInfo.enterDateOfBirth(borrower.getDateOfBirth());
        borrowerInfo.submit();

        // Fill out income info
        IncomeInfoPage incomeInfo = new IncomeInfoPage(driver);
        incomeInfo.enterBorrowerIncome(Integer.toString(borrower.getIncome()));
        incomeInfo.enterBorrowerAdditionalIncome(Integer.toString(borrower.getAdditionalIncome()));
        incomeInfo.submit();
        incomeInfo.submit();

        // Fill out account info
        AccountInfoPage accountInfo = new AccountInfoPage(driver);
        accountInfo.enterEmailAddress(borrower.account.getEmail());
        accountInfo.enterPassword(borrower.account.getPassword());
        accountInfo.checkAgreements();
        accountInfo.submit();
    }

    private LoanOffer showLoanOfferAndExtractInfo() throws Exception {
        OfferInfoPage offerInfo = new OfferInfoPage(driver);
        LoanOffer loanOffer = new LoanOffer(
                offerInfo.getMonthlyPayment(),
                offerInfo.getTerm(),
                offerInfo.getInterestRate(),
                offerInfo.getAPR());

        offerInfo.signOut();
        return loanOffer;
    }

    private void getSignInAndAssertLoanOfferInfo(LoanOffer expectedLoanOffer) {
        PortalLoginPage portalLogin = new PortalLoginPage(driver);
        portalLogin.enterEmailAddress(borrowerData.account.getEmail());
        portalLogin.enterPassword(borrowerData.account.getPassword());
        portalLogin.submit();

        OfferInfoPage actualOfferInfo = new OfferInfoPage(driver);
        Assertions.assertEquals(
                expectedLoanOffer.getMonthlyPayment(),
                actualOfferInfo.getMonthlyPayment());
        Assertions.assertEquals(
                expectedLoanOffer.getTerm(),
                actualOfferInfo.getTerm());
        Assertions.assertEquals(
                expectedLoanOffer.getInterestRate(),
                actualOfferInfo.getInterestRate());
        Assertions.assertEquals(
                expectedLoanOffer.getAPR(),
                actualOfferInfo.getAPR());
    }
}
