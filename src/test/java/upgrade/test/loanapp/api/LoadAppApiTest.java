package upgrade.test.loanapp.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upgrade.test.framework.api.BaseApiTest;
import upgrade.test.framework.core.Enums.HttpStatusCode;
import upgrade.test.framework.models.LoanAppInfo;
import upgrade.test.framework.utils.AssertUtils;
import upgrade.test.loanapp.api.requests.LoadAppRequest;

public class LoadAppApiTest extends BaseApiTest {

    private LoadAppRequest loadAppRequest;
    private final String LOANAPP_URL = "https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret";

    @BeforeEach
    private void setUp() {
        endPoint = LOANAPP_URL;
        loadAppRequest = new LoadAppRequest(endPoint);
    }

    @AfterEach
    private void tearDown() {
        if (loadAppRequest != null) {
            loadAppRequest = null;
        }
    }

    @Test
    public void loadAppInfoWithExistingIdTest() {
        var response = loadAppRequest.getLoadAppId(
                testData.getExistingLoanAppId(),
                true);

        Assertions.assertEquals(HttpStatusCode.OK.getCode(), response.getStatusCode());
        AssertUtils.assertEqualsOfLoadAppObjects(
                testData.getStaticLoadApiInfo(),
                response.as(LoanAppInfo.class));
    }

    @Test
    public void loadAppInfoWithBadIdTest() {
        var response = loadAppRequest.getLoadAppId(
                testData.getNonExistingLoadApiId(),
                true);
        Assertions.assertEquals(HttpStatusCode.NOT_FOUND.getCode(), response.getStatusCode());
    }
}
