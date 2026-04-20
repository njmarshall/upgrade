package upgrade.test.framework.models;

import lombok.Data;

@Data
public class BorrowerResumptionInfo {
    private String firstName;
    private String maskedEmail;
    private boolean ssnRequired;
    private String state;
    private String email;
}