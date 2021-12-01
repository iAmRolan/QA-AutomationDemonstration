package Utilities;

import Pages.DesktopPages.CalculatorPage;
import Pages.ElectronPages.ToDoHomePage;
import Pages.MobilePages.MortgagePage;
import Pages.WebPages.*;
import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.stringtemplate.v4.ST;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class Variables {

    // General
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static String url;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static ChromeOptions chromeOptions;
    protected static DateTimeFormatter dtf;
    protected static LocalDateTime now;
    protected static String timeout;
    protected static String platform;
    protected static String browserName;
    protected static String ddtFile;
    protected static File fXmlFile;

    // Web
    protected static WebDriver driver;
    protected static String userName;
    protected static String userPassword;
    protected static String lastPanelAddedTitle;
    protected static String expectedGrafanaHeader;
    protected static String dashBoardToDelete;
    protected static String panelNameToDelete;
    protected static int xOffset;
    protected static int yOffset;
    protected static int expectedAddedUsers;
    protected static Map<String, String> expectedDimensions;

    // APPIUM
    protected static AppiumDriver appiumDriver;;
    protected static String reportDirectory;
    protected static String reportFormat;
    protected static String testName;

    // Electron
    protected static String electronAppPath;
    protected static String expectedTaskTest;
    protected static String expectedTextAfterDelete;

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static String adminApiURL;
    protected static String usersApiUrl;
    protected static String apiUserName;
    protected static String apiPassword;

    // Database
    protected static Connection connection;
    protected static String activeDB;
    protected static Statement statement;
    protected static ResultSet resultSet;
    protected static String dbUserName;
    protected static String dbPassword;
    protected static String dbURL;
    protected static List<String> amountList;
    protected static List<String> termList;
    protected static List<String> rateList;

    // Sikuli
    protected static Screen screen;
    protected static String imageRepoPath;

    // Page Objects - Web
    protected static CreateDashboardPage createDashboardPage;
    protected static DashboardPage dashboardPage;
    protected static GrafanaMenuPage grafanaMenuPage;
    protected static LoginPage loginPage;
    protected static PanelsPage panelsPage;
    protected static SearchDashboardPage searchDashboardPage;
    protected static ServerAdminUsersPage serverAdminUsersPage;

    // Page Objects - Mobile
   protected static MortgagePage mortgagePage;

    // Page Objects Electron
    protected static ToDoHomePage toDoHomePage;

    // Page Objects - Desktop
    protected static CalculatorPage calculatorPage;

    // Files
    protected static String newUsersFilePath;

}
