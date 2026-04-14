package upgrade.test.framework.models;

import java.util.Objects;

public class LoanInfo {

    private int amount;
    private String purpose;

    public LoanInfo(int amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public int getAmount()              { return amount; }
    public void setAmount(int v)        { this.amount = v; }
    public String getPurpose()          { return purpose; }
    public void setPurpose(String v)    { this.purpose = v; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanInfo)) return false;
        LoanInfo that = (LoanInfo) o;
        return amount == that.amount && Objects.equals(purpose, that.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, purpose);
    }

    @Override
    public String toString() {
        return String.format("LoanInfo{amount=%d, purpose='%s'}", amount, purpose);
    }
}