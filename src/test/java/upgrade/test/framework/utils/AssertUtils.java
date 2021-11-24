package upgrade.test.framework.utils;

import org.junit.jupiter.api.Assertions;
import upgrade.test.framework.models.LoanAppInfo;

public class AssertUtils {

    public static void assertEqualsOfLoadAppObjects(
        LoanAppInfo expectedObj,
        LoanAppInfo actualObj) {

        // Loan App Resumption Info
        // Loan App Id
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getLoanAppId(),
                actualObj.loanAppResumptionInfo.getLoanAppId());
        // Loan App Uuid
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getLoanAppUuid(),
                actualObj.loanAppResumptionInfo.getLoanAppUuid());
        // Referrer
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getReferrer(),
                actualObj.loanAppResumptionInfo.getReferrer());
        // Status
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getStatus(),
                actualObj.loanAppResumptionInfo.getStatus());
        // Product Type
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getProductType(),
                actualObj.loanAppResumptionInfo.getProductType());
        // Desired Amount
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getDesiredAmount(),
                actualObj.loanAppResumptionInfo.getDesiredAmount());

        // Borrower Resumption Info
        // First name
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.borrowerResumptionInfo.getFirstName(),
                actualObj.loanAppResumptionInfo.borrowerResumptionInfo.getFirstName());
        // Masked Email
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.borrowerResumptionInfo.getMaskedEmail(),
                actualObj.loanAppResumptionInfo.borrowerResumptionInfo.getMaskedEmail());
        // SSN Required
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.borrowerResumptionInfo.isSsnRequired(),
                actualObj.loanAppResumptionInfo.borrowerResumptionInfo.isSsnRequired());
        // State
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.borrowerResumptionInfo.getState(),
                actualObj.loanAppResumptionInfo.borrowerResumptionInfo.getState());
        // Email
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.borrowerResumptionInfo.getEmail(),
                actualObj.loanAppResumptionInfo.borrowerResumptionInfo.getEmail());

        // Loan Resumption Info
        // Co-borrower Resumption Info
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getCoBorrowerResumptionInfo(),
                actualObj.loanAppResumptionInfo.getCoBorrowerResumptionInfo());
        // Turn Down
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.isTurnDown(),
                actualObj.loanAppResumptionInfo.isTurnDown());
        // Has Login
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.isHasLogin(),
                actualObj.loanAppResumptionInfo.isHasLogin());
        // Available App Improvements
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getAvailableAppImprovements(),
                actualObj.loanAppResumptionInfo.getAvailableAppImprovements());
        // Cash Out Amount
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getCashOutAmount(),
                actualObj.loanAppResumptionInfo.getCashOutAmount());
        // Can Add Collateral
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.isCanAddCollateral(),
                actualObj.loanAppResumptionInfo.isCanAddCollateral());
        // Reward Program Id
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getRewardProgramId(),
                actualObj.loanAppResumptionInfo.getRewardProgramId());
        // Reward Program Code
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getRewardProgramCode(),
                actualObj.loanAppResumptionInfo.getRewardProgramCode());
        // Add on
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.getAddon(),
                actualObj.loanAppResumptionInfo.getAddon());
        // Is Mobile Discount Applied
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.isMobileDiscountApplied(),
                actualObj.loanAppResumptionInfo.isMobileDiscountApplied());
        // Checking Discount Applied
        Assertions.assertEquals(
                expectedObj.loanAppResumptionInfo.isCheckingDiscountAvailable(),
                actualObj.loanAppResumptionInfo.isCheckingDiscountAvailable());

        // Misc Fields
        Assertions.assertEquals(
                expectedObj.getOffers(),
                actualObj.getOffers());
        // Selected Offer
        Assertions.assertEquals(
                expectedObj.getSelectedOffer(),
                actualObj.getSelectedOffer());
        // Required Aggreements
        Assertions.assertEquals(
                expectedObj.getRequiredAgreements(),
                actualObj.getRequiredAgreements());
        // Reset Options
        Assertions.assertEquals(
                expectedObj.getResetOptions(),
                actualObj.getResetOptions());
        // Original Loan App
        Assertions.assertEquals(
                expectedObj.getOffers(),
                actualObj.getOffers());
    }
}
