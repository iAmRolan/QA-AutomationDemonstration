package WorkFlows;

import Extensions.UIActions;
import Extensions.Verifications;
import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.python.antlr.ast.Str;
import org.sikuli.script.FindFailed;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class GrafanaWorkFlows extends CommonOps {

    @Step("Login to grafana dashboard.")
    public static void loginToGrafana() {
        // Set userName, userPassword and Header.
        expectedGrafanaHeader = "Welcome to Grafana";
        userName = "admin";
        userPassword = "HazakPo";
        UIActions.sendKeysToElement(loginPage.getUsernameInput(), userName);
        UIActions.sendKeysToElement(loginPage.getPasswordInput(), userPassword);
        UIActions.clickElement(loginPage.getLoginButton());
    }

    @Step("Validate grafana logo exists")
    public static boolean isGrafanaLogoExists() {
        // Set image repository path
        imageRepoPath = "C:\\Automation\\QA-AutomationDemonstration\\Files\\";
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        return screen.exists(imageRepoPath + "Grafana.png") != null;
    }

    @Step("Resize Dashboard.")
    public static void resizeDashboard() {
        // Set offset values
        xOffset = 400;
        yOffset = 250;

        // Set expected dimensions
        expectedDimensions = new HashMap<String, String>() {{
            put("width", "1275px");
            put("height", "550px");
        }};

        // Resize element
        UIActions.clickElement(grafanaMenuPage.getGeneralButton());
        UIActions.clickElement(dashboardPage.getCurrentDashboard());
        UIActions.resizeElement(dashboardPage.getResizeElement());
    }

    @Step("Add users")
    public static void enterUsersValues(String name, String email, String username, String password) {
        goToServerAdminPage();
        wait.until(ExpectedConditions.visibilityOf(serverAdminUsersPage.getNewUserBtn()));
        UIActions.clickElement(serverAdminUsersPage.getNewUserBtn());
        UIActions.sendKeysToElement(serverAdminUsersPage.getNameTxt(), name);
        UIActions.sendKeysToElement(serverAdminUsersPage.getEmailTxt(), email);
        UIActions.sendKeysToElement(serverAdminUsersPage.getUsernameTxt(), username);
        UIActions.sendKeysToElement(serverAdminUsersPage.getPasswordTxt(), password);
        UIActions.clickElement(serverAdminUsersPage.getCreateUserBtn());
        if (serverAdminUsersPage.getAlertPopupClose().isDisplayed()) {
            UIActions.clickElement(serverAdminUsersPage.getAlertPopupClose());
        }
    }

    public static void deletePanel() {
        // Set panel name to be deleted.
        panelNameToDelete = "New Panel";

        // Set dashboard to delete from
        dashBoardToDelete = "New dashboard1";

        UIActions.hoverOverElement(grafanaMenuPage.getSearchDashboards());
        UIActions.clickElement(grafanaMenuPage.getSearchDashboardsLabel());
        UIActions.sendKeysToElement(searchDashboardPage.getSearchInput(), dashBoardToDelete);
        UIActions.sendReturnKey(searchDashboardPage.getSearchInput());

        UIActions.clickElement(searchDashboardPage.getDashboardFound());

        WebElement panelElem = searchPanel(panelNameToDelete);
        Verifications.verifyPanelFound(panelElem);

        UIActions.clickElement(panelElem);
        UIActions.clickElement(panelsPage.getRemovePanelOption());
        UIActions.clickElement(panelsPage.getAcceptRemoveAlert());
    }

    @Step
    public static void createDashboard() {
        lastPanelAddedTitle = "Test Panel";

        UIActions.clickElement(grafanaMenuPage.getPlusElement());
        UIActions.clickElement(grafanaMenuPage.getAddDashboardElement());
        createDashboardPage.getTitle().clear();
        UIActions.sendKeysToElement(createDashboardPage.getTitle(), lastPanelAddedTitle);
        UIActions.sendKeysToElement(createDashboardPage.getDescription(), "This is a test panel");
        UIActions.clickElement(createDashboardPage.getBarsStyle());
        UIActions.clickElement(createDashboardPage.getUnitPicker());
        UIActions.scrollToElement(createDashboardPage.getDateAndTimePicker());
        UIActions.clickElement(createDashboardPage.getDateAndTimePicker());
        UIActions.clickElement(createDashboardPage.getDateTimeISO());
        UIActions.clickElement(createDashboardPage.getApplyButton());
    }

    // Helper function.
    public static void goToServerAdminPage() {
        UIActions.hoverOverElement(grafanaMenuPage.getServerAdminElement());
        UIActions.clickElement(grafanaMenuPage.getServerAdminUsers());
    }

    private static WebElement searchPanel(String panelName) {
        for (WebElement elem : panelsPage.getAllPanelsTitleList()
        ) {
            if (elem.getText().equals(panelName)) {
                return elem;
            }
        }
        return null;
    }
}
