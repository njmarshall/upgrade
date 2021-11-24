package upgrade.test.framework.api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import upgrade.test.framework.testdata.TestDataRetriever;

public class BaseApiTest {
    protected static TestDataRetriever testData = null;
    protected String endPoint;

    @BeforeAll
    public static void beforeSuite() {
        testData = new TestDataRetriever();
    }

    @AfterAll
    public static void afterSuite() {
        if (testData != null) {
            testData = null;
        }
    }
}
