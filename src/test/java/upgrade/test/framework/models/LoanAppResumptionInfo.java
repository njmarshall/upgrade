package upgrade.test.framework.models;

import java.util.ArrayList;

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

    public int getLoanAppId() {
        return loanAppId;
    }

    public void setLoanAppId(int loanAppId) {
        this.loanAppId = loanAppId;
    }

    public String getLoanAppUuid() {
        return loanAppUuid;
    }

    public void setLoanAppUuid(String loanAppUuid) {
        this.loanAppUuid = loanAppUuid;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public float getDesiredAmount() {
        return desiredAmount;
    }

    public void setDesiredAmount(float desiredAmount) {
        this.desiredAmount = desiredAmount;
    }

    public String getCoBorrowerResumptionInfo() {
        return coBorrowerResumptionInfo;
    }

    public void setCoBorrowerResumptionInfo(String coBorrowerResumptionInfo) {
        this.coBorrowerResumptionInfo = coBorrowerResumptionInfo;
    }

    public boolean isTurnDown() {
        return turnDown;
    }

    public void setTurnDown(boolean turnDown) {
        this.turnDown = turnDown;
    }

    public boolean isHasLogin() {
        return hasLogin;
    }

    public void setHasLogin(boolean hasLogin) {
        this.hasLogin = hasLogin;
    }

    public ArrayList<String> getAvailableAppImprovements() {
        return availableAppImprovements;
    }

    public void setAvailableAppImprovements(ArrayList<String> availableAppImprovements) {
        this.availableAppImprovements = availableAppImprovements;
    }

    public Float getCashOutAmount() {
        return cashOutAmount;
    }

    public void setCashOutAmount(Float cashOutAmount) {
        this.cashOutAmount = cashOutAmount;
    }

    public boolean isCanAddCollateral() {
        return canAddCollateral;
    }

    public void setCanAddCollateral(boolean canAddCollateral) {
        this.canAddCollateral = canAddCollateral;
    }

    public String getRewardProgramId() {
        return rewardProgramId;
    }

    public void setRewardProgramId(String rewardProgramId) {
        this.rewardProgramId = rewardProgramId;
    }

    public String getRewardProgramCode() {
        return rewardProgramCode;
    }

    public void setRewardProgramCode(String rewardProgramCode) {
        this.rewardProgramCode = rewardProgramCode;
    }

    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon;
    }

    public Boolean isMobileDiscountApplied() {
        return isMobileDiscountApplied;
    }

    public void setIsMobileDiscountApplied(Boolean isMobileDiscountApplied) {
        this.isMobileDiscountApplied = isMobileDiscountApplied;
    }

    public boolean isCheckingDiscountAvailable() {
        return checkingDiscountAvailable;
    }

    public void setCheckingDiscountAvailable(boolean checkingDiscountAvailable) {
        this.checkingDiscountAvailable = checkingDiscountAvailable;
    }
}
