package upgrade.test.framework.models;

import java.util.Objects;

public class LoanOffer {

    private String monthlyPayment;
    private String term;
    private String interestRate;
    private String apr;

    public LoanOffer(String monthlyPayment, String term, String interestRate, String apr) {
        this.monthlyPayment = monthlyPayment;
        this.term = term;
        this.interestRate = interestRate;
        this.apr = apr;
    }

    public String getMonthlyPayment()               { return monthlyPayment; }
    public void setMonthlyPayment(String v)         { this.monthlyPayment = v; }
    public String getTerm()                         { return term; }
    public void setTerm(String v)                   { this.term = v; }
    public String getInterestRate()                 { return interestRate; }
    public void setInterestRate(String v)           { this.interestRate = v; }

    /** @deprecated Use {@link #getApr()} — field renamed to follow Java naming conventions. */
    @Deprecated
    public String getAPR()                          { return apr; }
    public String getApr()                          { return apr; }
    public void setApr(String v)                    { this.apr = v; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanOffer)) return false;
        LoanOffer that = (LoanOffer) o;
        return Objects.equals(monthlyPayment, that.monthlyPayment)
                && Objects.equals(term, that.term)
                && Objects.equals(interestRate, that.interestRate)
                && Objects.equals(apr, that.apr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthlyPayment, term, interestRate, apr);
    }

    @Override
    public String toString() {
        return String.format("LoanOffer{monthlyPayment='%s', term='%s', interestRate='%s', APR='%s'}",
                monthlyPayment, term, interestRate, apr);
    }
}
