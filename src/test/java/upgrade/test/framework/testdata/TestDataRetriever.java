package upgrade.test.framework.testdata;

import io.restassured.path.json.JsonPath;
import upgrade.test.framework.models.LoanAppInfo;
import upgrade.test.framework.models.LoanInfo;
import upgrade.test.framework.testdata.words.BirthOfDates;
import upgrade.test.framework.testdata.words.FirstNames;
import upgrade.test.framework.testdata.words.HomeAddresses;
import upgrade.test.framework.testdata.words.LastNames;
import upgrade.test.framework.models.Account;
import upgrade.test.framework.models.Borrower;
import upgrade.test.framework.utils.SystemUtils;

import java.io.File;
import java.util.Random;

public class TestDataRetriever {

    private Random r;

    public TestDataRetriever() {
        this.r = new Random();
    }

    public Borrower getRandomBorrower() {

        String[] addressContents = getRandomStringFor("ha").split(",");
        String homeAddress = addressContents[0];
        String city = addressContents[1];
        String state = addressContents[2];
        String zipCode = addressContents[3];
        String country = addressContents[4];

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
                new LoanInfo(
                        2000,
                        "Business")
        );
    }

    public String getExistingLoanAppId() {
        return "b8096ec7-2150-405f-84f5-ae99864b3e96";
    }

    public String getNonExistingLoadApiId() {
        return "b8096ec7-2150-405f-84f5-ae99864b3e99";
    }

    public LoanAppInfo getStaticLoadApiInfo() {
        JsonPath jsonPath = new JsonPath(
                new File(System.getProperty("user.dir"),
                        "src/test/data/LoanAppResumptionInfoRequest.json"));
        return jsonPath.getObject("", LoanAppInfo.class);
    }

    private String getRandomStringFor(String aCode) {

        RandomItemsArray itemsArray;

        switch(aCode) {
            case "fn":
                itemsArray = new FirstNames();
                break;

            case "ln":
                itemsArray = new LastNames();
                break;

            case "ha":
                itemsArray = new HomeAddresses();
                break;

            case "dob":
                itemsArray = new BirthOfDates();
                break;

            default:
                System.err.println(String.format("You forgot to add %s", aCode));
                itemsArray = new FirstNames();
                break;
        }

        return itemsArray.
                getItems()[r.nextInt(itemsArray.getItems().length)];
    }
}
