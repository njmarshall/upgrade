package upgrade.test.framework.models;

import java.util.Objects;

public class BorrowerResumptionInfo {

    private String firstName;
    private String maskedEmail;
    private boolean ssnRequired;
    private String state;
    private String email;

    public String getFirstName()                { return firstName; }
    public void setFirstName(String v)          { this.firstName = v; }
    public String getMaskedEmail()              { return maskedEmail; }
    public void setMaskedEmail(String v)        { this.maskedEmail = v; }
    public boolean isSsnRequired()              { return ssnRequired; }
    public void setSsnRequired(boolean v)       { this.ssnRequired = v; }
    public String getState()                    { return state; }
    public void setState(String v)              { this.state = v; }
    public String getEmail()                    { return email; }
    public void setEmail(String v)              { this.email = v; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BorrowerResumptionInfo)) return false;
        BorrowerResumptionInfo that = (BorrowerResumptionInfo) o;
        return ssnRequired == that.ssnRequired
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(maskedEmail, that.maskedEmail)
                && Objects.equals(state, that.state)
                && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, maskedEmail, ssnRequired, state, email);
    }
}