package upgrade.test.framework.models;

import java.util.ArrayList;
import java.util.Objects;

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

    public int getLoanAppId()                               { return loanAppId; }
    public void setLoanAppId(int v)                         { this.loanAppId = v; }
    public String getLoanAppUuid()                          { return loanAppUuid; }
    public void setLoanAppUuid(String v)                    { this.loanAppUuid = v; }
    public String getReferrer()                             { return referrer; }
    public void setReferrer(String v)                       { this.referrer = v; }
    public String getStatus()                               { return status; }
    public void setStatus(String v)                         { this.status = v; }
    public String getProductType()                          { return productType; }
    public void setProductType(String v)                    { this.productType = v; }
    public String getSourceSystem()                         { return sourceSystem; }
    public void setSourceSystem(String v)                   { this.sourceSystem = v; }
    public float getDesiredAmount()                         { return desiredAmount; }
    public void setDesiredAmount(float v)                   { this.desiredAmount = v; }
    public String getCoBorrowerResumptionInfo()             { return coBorrowerResumptionInfo; }
    public void setCoBorrowerResumptionInfo(String v)       { this.coBorrowerResumptionInfo = v; }
    public boolean isTurnDown()                             { return turnDown; }
    public void setTurnDown(boolean v)                      { this.turnDown = v; }
    public boolean isHasLogin()                             { return hasLogin; }
    public void setHasLogin(boolean v)                      { this.hasLogin = v; }
    public ArrayList<String> getAvailableAppImprovements()  { return availableAppImprovements; }
    public void setAvailableAppImprovements(ArrayList<String> v) { this.availableAppImprovements = v; }
    public Float getCashOutAmount()                         { return cashOutAmount; }
    public void setCashOutAmount(Float v)                   { this.cashOutAmount = v; }
    public boolean isCanAddCollateral()                     { return canAddCollateral; }
    public void setCanAddCollateral(boolean v)              { this.canAddCollateral = v; }
    public String getRewardProgramId()                      { return rewardProgramId; }
    public void setRewardProgramId(String v)                { this.rewardProgramId = v; }
    public String getRewardProgramCode()                    { return rewardProgramCode; }
    public void setRewardProgramCode(String v)              { this.rewardProgramCode = v; }
    public String getAddon()                                { return addon; }
    public void setAddon(String v)                          { this.addon = v; }
    public Boolean isMobileDiscountApplied()                { return isMobileDiscountApplied; }
    public void setIsMobileDiscountApplied(Boolean v)       { this.isMobileDiscountApplied = v; }
    public boolean isCheckingDiscountAvailable()            { return checkingDiscountAvailable; }
    public void setCheckingDiscountAvailable(boolean v)     { this.checkingDiscountAvailable = v; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanAppResumptionInfo)) return false;
        LoanAppResumptionInfo that = (LoanAppResumptionInfo) o;
        return Objects.equals(loanAppId, that.loanAppId)
                && Objects.equals(loanAppUuid, that.loanAppUuid)
                && Objects.equals(referrer, that.referrer)
                && Objects.equals(status, that.status)
                && Objects.equals(productType, that.productType)
                && Objects.equals(sourceSystem, that.sourceSystem)
                && Objects.equals(desiredAmount, that.desiredAmount)
                && Objects.equals(borrowerResumptionInfo, that.borrowerResumptionInfo)
                && Objects.equals(coBorrowerResumptionInfo, that.coBorrowerResumptionInfo)
                && Objects.equals(turnDown, that.turnDown)
                && Objects.equals(hasLogin, that.hasLogin)
                && Objects.equals(availableAppImprovements, that.availableAppImprovements)
                && Objects.equals(cashOutAmount, that.cashOutAmount)
                && Objects.equals(canAddCollateral, that.canAddCollateral)
                && Objects.equals(rewardProgramId, that.rewardProgramId)
                && Objects.equals(rewardProgramCode, that.rewardProgramCode)
                && Objects.equals(addon, that.addon)
                && Objects.equals(isMobileDiscountApplied, that.isMobileDiscountApplied)
                && Objects.equals(checkingDiscountAvailable, that.checkingDiscountAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanAppId, loanAppUuid, referrer, status, productType,
                sourceSystem, desiredAmount, borrowerResumptionInfo, coBorrowerResumptionInfo,
                turnDown, hasLogin, availableAppImprovements, cashOutAmount, canAddCollateral,
                rewardProgramId, rewardProgramCode, addon, isMobileDiscountApplied,
                checkingDiscountAvailable);
    }
}