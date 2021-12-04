import Extensions.Verifications;
import Utilities.CommonOps;
import Utilities.ManageDDT;
import WorkFlows.GrafanaWorkFlows;
import io.qameta.allure.Description;
import org.python.antlr.ast.Str;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */

public class GrafanaTests extends CommonOps {

    @Test(description = "Test user logged in.")
    @Description("Verify user logged in to grafana.")
    public void test01_loginToGrafana() {
        GrafanaWorkFlows.loginToGrafana();
        Verifications.verifyText(grafanaMenuPage.getGrafanaHeaderText(), expectedGrafanaHeader);
    }

    @Test(description = "Test grafana logo")
    @Description("Verify grafana logo found")
    public void test02_grafanaLogo() {
        Verifications.verifyImage(GrafanaWorkFlows.isGrafanaLogoExists());
    }

    @Test(description = "Test dashboard resize")
    @Description("Verify dashboard dimensions after resize")
    public void test03_resizeDashboard() {
        GrafanaWorkFlows.resizeDashboard();
        Verifications.verifyDimensions(dashboardPage.getDimensions(), expectedDimensions);
    }

    @Test(dataProvider = "NewUsers", dataProviderClass = ManageDDT.class)
    @Description("Add users")
    public void test0401_addNewUsers(String name, String email, String username, String password) {
        GrafanaWorkFlows.enterUsersValues(name, email, username, password);
    }

    @Test(description = "Test all users added")
    @Description("Verify all users added.")
    public void test0402_verifyAllUserAdded() {
        // Set amount of users to appear after adding all users.
        expectedAddedUsers = Integer.parseInt(getData("ExpectedUsers"));

        GrafanaWorkFlows.goToServerAdminPage();
        Verifications.verifyUsersAdded(serverAdminUsersPage.getUsersList());
    }

    @Test(description = "Test panel deleted")
    @Description("Verify panel deleted from dashboard")
    public void test05_deletePanel() {
        GrafanaWorkFlows.deletePanel();
        Verifications.verifyPanelIsRemoved(panelsPage.getAllPanelsTitleList(), panelNameToDelete);
    }

    @Test(description = "Test add panel")
    @Description("Verify panel added to dashboard")
    public void test06_addPanel() {
        GrafanaWorkFlows.createDashboard();
        Verifications.verifyText(dashboardPage.getDashboardHeaderText(), lastPanelAddedTitle);
    }

}
