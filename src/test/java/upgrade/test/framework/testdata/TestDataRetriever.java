package upgrade.test.framework.testdata;

import io.restassured.path.json.JsonPath;
import upgrade.test.framework.core.ConfigManager;
import upgrade.test.framework.models.Account;
import upgrade.test.framework.models.Borrower;
import upgrade.test.framework.models.LoanAppInfo;
import upgrade.test.framework.models.LoanInfo;
import upgrade.test.framework.testdata.words.BirthOfDates;
import upgrade.test.framework.testdata.words.FirstNames;
import upgrade.test.framework.testdata.words.HomeAddresses;
import upgrade.test.framework.testdata.words.LastNames;
import upgrade.test.framework.utils.SystemUtils;

import java.io.File;
import java.util.Random;

/**
 * Provides test data for both API and UI tests.
 * Loan app IDs are loaded from config (not hardcoded) to avoid committing
 * environment-specific values to version control.
 */
public class TestDataRetriever {

    private final Random random;
    private final ConfigManager config;

    public TestDataRetriever() {
        this.random = new Random();
        this.config = ConfigManager.getInstance();
    }

    public Borrower getRandomBorrower() {
        String[] addressParts = getRandomStringFor("ha").split(",");
        String homeAddress = addressParts[0].trim();
        String city        = addressParts[1].trim();
        String state       = addressParts[2].trim();
        String zipCode     = addressParts[3].trim();
        String country     = addressParts[4].trim();

        return new Borrower(
                getRandomStringFor("fn"),
                getRandomStringFor("ln"),
                homeAddress,
                city,
                state,
                zipCode,
                country,
                getRandomStringFor("dob"),
                120000,
                5000,
                new Account(
                        String.format("candidate+%s@upgrade-challenge.com", SystemUtils.getGuid()),
                        "upradE200"),
                new LoanInfo(2000, "Business")
        );
    }

    /** Returns the existing loan app UUID from config (not hardcoded). */
    public String getExistingLoanAppId() {
        return config.getExistingLoanAppId();
    }

    /** Returns a UUID known not to exist in the system from config. */
    public String getNonExistingLoadApiId() {
        return config.getNonExistingLoanAppId();
    }

    public LoanAppInfo getStaticLoadApiInfo() {
        JsonPath jsonPath = new JsonPath(
                new File(System.getProperty("user.dir"),
                        "src/test/data/LoanAppResumptionInfoRequest.json"));
        return jsonPath.getObject("", LoanAppInfo.class);
    }

    private String getRandomStringFor(String code) {
        RandomItemsArray itemsArray;
        switch (code) {
            case "fn":  itemsArray = new FirstNames();     break;
            case "ln":  itemsArray = new LastNames();      break;
            case "ha":  itemsArray = new HomeAddresses();  break;
            case "dob": itemsArray = new BirthOfDates();   break;
            default:
                throw new IllegalArgumentException(
                        String.format("Unknown test data code: '%s'", code));
        }
        String[] items = itemsArray.getItems();
        return items[random.nextInt(items.length)];
    }
}
