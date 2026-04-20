package upgrade.test.framework.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LoanAppInfo {
    public LoanAppResumptionInfo loanAppResumptionInfo;
    public ArrayList<String> offers;
    public String selectedOffer;
    public ArrayList<String> requiredAgreements;
    public ArrayList<String> resetOptions;
    public String originalLoanApp;
}