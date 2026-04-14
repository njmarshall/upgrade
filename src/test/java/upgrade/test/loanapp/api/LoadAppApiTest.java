package upgrade.test.loanapp.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upgrade.test.framework.api.BaseApiTest;
import upgrade.test.framework.core.ConfigManager;
import upgrade.test.framework.core.Enums.HttpStatusCode;
import upgrade.test.framework.models.LoanAppInfo;
import upgrade.test.framework.utils.AssertUtils;
import upgrade.test.loanapp.api.requests.LoadAppRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Loan Application API Tests")
public class LoadAppApiTest extends BaseApiTest {

    private LoadAppRequest loadAppRequest;

    @BeforeEach
    void setUp() {
        endPoint = ConfigManager.getInstance().getLoanAppUrl();
        loadAppRequest = new LoadAppRequest(endPoint);
    }

    @AfterEach
    void tearDown() {
        loadAppRequest = null;
    }

    @Test
    @DisplayName("GET loan app info with a valid existing UUID returns 200 and correct payload")
    void loadAppInfoWithExistingIdTest() {
        var response = loadAppRequest.getLoadAppId(
                testData.getExistingLoanAppId(),
                true);

        assertEquals(HttpStatusCode.OK.getCode(), response.getStatusCode());
        AssertUtils.assertEqualsOfLoadAppObjects(
                testData.getStaticLoadApiInfo(),
                response.as(LoanAppInfo.class));
    }

    @Test
    @DisplayName("GET loan app info with a non-existent UUID returns 404")
    void loadAppInfoWithBadIdTest() {
        var response = loadAppRequest.getLoadAppId(
                testData.getNonExistingLoadApiId(),
                true);

        assertEquals(HttpStatusCode.NOT_FOUND.getCode(), response.getStatusCode());
    }
}
