package upgrade.test.framework.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanOffer {
    private String monthlyPayment;
    private String term;
    private String interestRate;
    private String apr;
}