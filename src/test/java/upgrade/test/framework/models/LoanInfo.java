package upgrade.test.framework.models;

public class LoanInfo {

    private int amount;
    private String purpose;

    public LoanInfo(int amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
