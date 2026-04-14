package upgrade.test.framework.models;

import java.util.Objects;

public class Account {

    private String email;
    private String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail()            { return email; }
    public void setEmail(String v)      { this.email = v; }
    public String getPassword()         { return password; }
    public void setPassword(String v)   { this.password = v; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account that = (Account) o;
        // Intentionally excludes password — email is the identity key
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        // Password intentionally excluded for security
        return String.format("Account{email='%s'}", email);
    }
}