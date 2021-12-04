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
        expectedGrafanaHeader = getData("ExpectedGrafanaHeader");
        userName = getData("LoginUsername");
        userPassword = getData("LoginPassword");

        UIActions.sendKeysToElement(loginPage.getUsernameInput(), userName);
        UIActions.sendKeysToElement(loginPage.getPasswordInput(), userPassword);
        UIActions.clickElement(loginPage.getLoginButton());
    }

    @Step("Validate grafana logo exists")
    public static boolean isGrafanaLogoExists() {
        // Set image repository path
        imageRepoPath = getData("ImageRepoPath");
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        return screen.exists(imageRepoPath + getData("ImageFileName")) != null;
    }

    @Step("Resize Dashboard.")
    public static void resizeDashboard() {
        // Set offset values
        xOffset = Integer.parseInt(getData("Xoffset"));
        yOffset = Integer.parseInt(getData("Yoffset"));

        // Set expected dimensions
        expectedDimensions = new HashMap<String, String>() {{
            put("width", getData("ExpectedWidth"));
            put("height", getData("ExpectedHeight"));
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

    @Step("Delete panel from dashboard")
    public static void deletePanel() {
        // Set panel name to be deleted.
        panelNameToDelete = getData("PanelNameToDelete");

        // Set dashboard to delete from
        dashBoardToDelete = getData("DashBoardToDelete");


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

    @Step("Create new Dashboard.")
    public static void createDashboard() {
        lastPanelAddedTitle = getData("LastPanelAddedTitle");

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

    @Step("Navigate to admin panel.")
    public static void goToServerAdminPage() {
        UIActions.hoverOverElement(grafanaMenuPage.getServerAdminElement());
        UIActions.clickElement(grafanaMenuPage.getServerAdminUsers());
    }

    // Helper function for panel deletion.
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
