package upgrade.test.framework.models;

import java.util.ArrayList;

public class LoanAppInfo {
    public LoanAppResumptionInfo loanAppResumptionInfo;
    public ArrayList<String> offers;
    public String selectedOffer;
    public ArrayList<String> requiredAgreements;
    public ArrayList<String> resetOptions;
    public String originalLoanApp;

    public ArrayList<String> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<String> offers) {
        this.offers = offers;
    }

    public String getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(String selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

    public ArrayList<String> getRequiredAgreements() {
        return requiredAgreements;
    }

    public void setRequiredAgreements(ArrayList<String> requiredAgreements) {
        this.requiredAgreements = requiredAgreements;
    }

    public ArrayList<String> getResetOptions() {
        return resetOptions;
    }

    public void setResetOptions(ArrayList<String> resetOptions) {
        this.resetOptions = resetOptions;
    }

    public String getOriginalLoanApp() {
        return originalLoanApp;
    }

    public void setOriginalLoanApp(String originalLoanApp) {
        this.originalLoanApp = originalLoanApp;
    }
}
