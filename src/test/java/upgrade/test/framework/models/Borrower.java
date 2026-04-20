package upgrade.test.framework.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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

    public String getFullAddress() {
        return String.format("%s, %s, %s %s %s",
                homeAddress, city, state, zipCode, country);
    }
}