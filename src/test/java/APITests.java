import Extensions.APIActions;
import Extensions.Verifications;
import Utilities.CommonOps;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class APITests extends CommonOps {

    @Test(description = "Get users data from server")
    @Description("Verify server response code")
    public void test01_verifyResponseCode() {
        Verifications.verifyResponseCode(APIActions.getResponse(usersApiUrl), Integer.parseInt(getData("OKCode")));
    }

    @Test(description = "Get user by id")
    @Description("Verify user name")
    public void test02_verifyName() {
        Verifications.verifyText(APIActions.getUserDataByName(usersApiUrl, getData("UserID")), getData("UserName"));
    }

    @Test(description = "Update User name")
    @Description("Verify user name is updated")
    public void test03_updateUser() {
        params.put("email", getData("NewEmail"));
        APIActions.put(params, usersApiUrl + getData("UserIDToUpdate"));
        Verifications.verifyResponseCode(response.getStatusCode(), Integer.parseInt(getData("OKCode")));
    }

    @Test(description = "Add new admin use")
    @Description("Verify new admin user is added")
    public void test4() {
        params.put("name", getData("NewNameToAdd"));
        params.put("email", getData("NewEmailToAdd"));
        params.put("login", getData("NewUserLogin"));
        params.put("password", getData("NewUserPassword"));
        APIActions.post(params);
        Verifications.verifyResponseCode(response.getStatusCode(), Integer.parseInt(getData("OKCode")));
    }
}
