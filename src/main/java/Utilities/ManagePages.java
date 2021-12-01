package Utilities;

import Pages.DesktopPages.CalculatorPage;
import Pages.ElectronPages.ToDoHomePage;
import Pages.MobilePages.MortgagePage;
import Pages.WebPages.*;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class ManagePages extends Variables {

    // Web Pages Initialization.
    public static void initializeWebPages() {
        createDashboardPage = PageFactory.initElements(driver, CreateDashboardPage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        grafanaMenuPage = PageFactory.initElements(driver, GrafanaMenuPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        panelsPage = PageFactory.initElements(driver, PanelsPage.class);
        searchDashboardPage = PageFactory.initElements(driver, SearchDashboardPage.class);
        serverAdminUsersPage = PageFactory.initElements(driver, ServerAdminUsersPage.class);
    }

    // Electron pages Initialization
    public static void initializeElectronPages() {
        toDoHomePage = PageFactory.initElements(driver, ToDoHomePage.class);
    }

    // Desktop pages Initialization
    public static void initializeDesktopPages() {
        calculatorPage = PageFactory.initElements(driver, CalculatorPage.class);
    }

    // Appium pages Initialization
    public static void initializeAppiumPages() {
        mortgagePage = new MortgagePage(appiumDriver);
    }
}

