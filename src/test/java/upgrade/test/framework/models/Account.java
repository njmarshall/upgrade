package upgrade.test.framework.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "password") // never expose password in logs
public class Account {

    @EqualsAndHashCode.Include
    private String email;  // email is the identity key

    private String password;
}