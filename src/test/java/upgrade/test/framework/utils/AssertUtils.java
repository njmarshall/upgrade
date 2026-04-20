package upgrade.test.framework.utils;

import org.junit.jupiter.api.Assertions;
import upgrade.test.framework.models.LoanAppInfo;

/**
 * Custom assertion utilities for domain model comparisons.
 *
 * Now that LoanAppInfo and its nested models implement equals()/hashCode(),
 * a single assertEquals call covers the full object graph.
 * Field-level assertions are kept as a diagnostic fallback so that failures
 * report exactly which field diverged.
 */
public class AssertUtils {

    private AssertUtils() {
        // Utility class — not instantiable
    }

    /**
     * Assert two LoanAppInfo objects are equal.
     * Performs a top-level equals check first; if that fails, delegates to
     * granular field assertions so the failure message identifies the mismatch.
     */
    public static void assertEqualsOfLoadAppObjects(LoanAppInfo expected, LoanAppInfo actual) {
        if (!expected.equals(actual)) {
            assertLoanAppResumptionInfoFields(expected, actual);
            assertTopLevelFields(expected, actual);
        }
    }

    private static void assertLoanAppResumptionInfoFields(LoanAppInfo expected, LoanAppInfo actual) {
        var exp = expected.loanAppResumptionInfo;
        var act = actual.loanAppResumptionInfo;

        Assertions.assertEquals(exp.getLoanAppId(),     act.getLoanAppId(),     "loanAppId mismatch");
        Assertions.assertEquals(exp.getLoanAppUuid(),   act.getLoanAppUuid(),   "loanAppUuid mismatch");
        Assertions.assertEquals(exp.getReferrer(),      act.getReferrer(),      "referrer mismatch");
        Assertions.assertEquals(exp.getStatus(),        act.getStatus(),        "status mismatch");
        Assertions.assertEquals(exp.getProductType(),   act.getProductType(),   "productType mismatch");
        Assertions.assertEquals(exp.getDesiredAmount(), act.getDesiredAmount(), "desiredAmount mismatch");

        var expB = exp.borrowerResumptionInfo;
        var actB = act.borrowerResumptionInfo;
        Assertions.assertEquals(expB.getFirstName(),   actB.getFirstName(),   "borrower.firstName mismatch");
        Assertions.assertEquals(expB.getMaskedEmail(), actB.getMaskedEmail(), "borrower.maskedEmail mismatch");
        Assertions.assertEquals(expB.isSsnRequired(),  actB.isSsnRequired(),  "borrower.ssnRequired mismatch");
        Assertions.assertEquals(expB.getState(),       actB.getState(),       "borrower.state mismatch");
        Assertions.assertEquals(expB.getEmail(),       actB.getEmail(),       "borrower.email mismatch");

        Assertions.assertEquals(exp.getCoBorrowerResumptionInfo(),  act.getCoBorrowerResumptionInfo(),  "coBorrower mismatch");
        Assertions.assertEquals(exp.getTurnDown(),                  act.getTurnDown(),                   "turnDown mismatch");
        Assertions.assertEquals(exp.getHasLogin(),                  act.getHasLogin(),                   "hasLogin mismatch");
        Assertions.assertEquals(exp.getAvailableAppImprovements(),  act.getAvailableAppImprovements(),  "availableAppImprovements mismatch");
        Assertions.assertEquals(exp.getCashOutAmount(),             act.getCashOutAmount(),             "cashOutAmount mismatch");
        Assertions.assertEquals(exp.getCanAddCollateral(),          act.getCanAddCollateral(),           "canAddCollateral mismatch");
        Assertions.assertEquals(exp.getRewardProgramId(),           act.getRewardProgramId(),           "rewardProgramId mismatch");
        Assertions.assertEquals(exp.getRewardProgramCode(),         act.getRewardProgramCode(),         "rewardProgramCode mismatch");
        Assertions.assertEquals(exp.getAddon(),                     act.getAddon(),                     "addon mismatch");
        Assertions.assertEquals(exp.getIsMobileDiscountApplied(),   act.getIsMobileDiscountApplied(),      "mobileDiscountApplied mismatch");
        Assertions.assertEquals(exp.getCheckingDiscountAvailable(), act.getCheckingDiscountAvailable(),  "checkingDiscountAvailable mismatch");
    }

    private static void assertTopLevelFields(LoanAppInfo expected, LoanAppInfo actual) {
        Assertions.assertEquals(expected.getOffers(),             actual.getOffers(),             "offers mismatch");
        Assertions.assertEquals(expected.getSelectedOffer(),      actual.getSelectedOffer(),      "selectedOffer mismatch");
        Assertions.assertEquals(expected.getRequiredAgreements(), actual.getRequiredAgreements(), "requiredAgreements mismatch");
        Assertions.assertEquals(expected.getResetOptions(),       actual.getResetOptions(),       "resetOptions mismatch");
        Assertions.assertEquals(expected.getOriginalLoanApp(),    actual.getOriginalLoanApp(),    "originalLoanApp mismatch");
    }
}