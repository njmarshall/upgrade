package upgrade.test.framework.models;

public class LoanOffer {

    private String monthlyPayment;
    private String term;
    private String interestRate;
    private String APR;

    public LoanOffer(String monthlyPayment, String term, String interestRate, String APR) {
        this.monthlyPayment = monthlyPayment;
        this.term = term;
        this.interestRate = interestRate;
        this.APR = APR;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getAPR() {
        return APR;
    }

    public void setAPR(String APR) {
        this.APR = APR;
    }
}
