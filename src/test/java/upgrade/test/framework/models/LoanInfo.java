package upgrade.test.framework.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanInfo {
    private int amount;
    private String purpose;
}