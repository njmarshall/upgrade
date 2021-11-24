package upgrade.test.framework.models;

public class Borrower {
    private String firstName;
    private String lastName;
    private String homeAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String dateOfBirth;
    private int income;
    private int additionalIncome;
    public Account account;
    public LoanInfo loanInfo;

    public Borrower(String firstName,
                    String lastName,
                    String homeAddress,
                    String city,
                    String state,
                    String zipCode,
                    String country,
                    String dateOfBirth,
                    int income,
                    int additionalIncome,
                    Account account,
                    LoanInfo loanInfo) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.income = income;
        this.additionalIncome = additionalIncome;
        this.account = account;
        this.loanInfo = loanInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getAdditionalIncome() {
        return additionalIncome;
    }

    public void setAdditionalIncome(int additionalIncome) {
        this.additionalIncome = additionalIncome;
    }

    public String getFullAddress() {
        return String.format("%s, %s, %s %s %s",
                homeAddress,
                city,
                state,
                zipCode,
                country);
    }

}
