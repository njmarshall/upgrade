package upgrade.test.framework.models;

import java.util.ArrayList;
import java.util.Objects;

public class LoanAppInfo {

    public LoanAppResumptionInfo loanAppResumptionInfo;
    public ArrayList<String> offers;
    public String selectedOffer;
    public ArrayList<String> requiredAgreements;
    public ArrayList<String> resetOptions;
    public String originalLoanApp;

    public ArrayList<String> getOffers()                    { return offers; }
    public void setOffers(ArrayList<String> offers)         { this.offers = offers; }
    public String getSelectedOffer()                        { return selectedOffer; }
    public void setSelectedOffer(String selectedOffer)      { this.selectedOffer = selectedOffer; }
    public ArrayList<String> getRequiredAgreements()        { return requiredAgreements; }
    public void setRequiredAgreements(ArrayList<String> v)  { this.requiredAgreements = v; }
    public ArrayList<String> getResetOptions()              { return resetOptions; }
    public void setResetOptions(ArrayList<String> v)        { this.resetOptions = v; }
    public String getOriginalLoanApp()                      { return originalLoanApp; }
    public void setOriginalLoanApp(String originalLoanApp)  { this.originalLoanApp = originalLoanApp; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanAppInfo)) return false;
        LoanAppInfo that = (LoanAppInfo) o;
        return Objects.equals(loanAppResumptionInfo, that.loanAppResumptionInfo)
                && Objects.equals(offers, that.offers)
                && Objects.equals(selectedOffer, that.selectedOffer)
                && Objects.equals(requiredAgreements, that.requiredAgreements)
                && Objects.equals(resetOptions, that.resetOptions)
                && Objects.equals(originalLoanApp, that.originalLoanApp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanAppResumptionInfo, offers, selectedOffer,
                requiredAgreements, resetOptions, originalLoanApp);
    }
}