package upgrade.test.framework.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LoanAppResumptionInfo {
    public Integer loanAppId;
    private String loanAppUuid;
    private String referrer;
    private String status;
    private String productType;
    private String sourceSystem;
    private Float desiredAmount;
    public BorrowerResumptionInfo borrowerResumptionInfo;
    private String coBorrowerResumptionInfo;
    private Boolean turnDown;
    private Boolean hasLogin;
    private ArrayList<String> availableAppImprovements;
    private Float cashOutAmount;
    private Boolean canAddCollateral;
    private String rewardProgramId;
    private String rewardProgramCode;
    private String addon;
    private Boolean isMobileDiscountApplied;
    private Boolean checkingDiscountAvailable;
}