package Pages.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class ServerAdminUsersPage {

    @FindBy(css = "table > tbody > tr")
    private static List<WebElement> usersList;

    @FindBy(css = "div.page-action-bar > a > span")
    private static WebElement newUserBtn;

    @FindBy(css = "div:nth-child(1) > div:nth-child(2) > div > div > input")
    private static WebElement nameTxt;

    @FindBy(css = "div:nth-child(2) > div:nth-child(2) > div > div > input")
    private static WebElement emailTxt;

    @FindBy(css = "div:nth-child(3) > div:nth-child(2) > div > div > input")
    private static WebElement usernameTxt;

    @FindBy(css = "div:nth-child(4) > div:nth-child(2) > div > div > input")
    private static WebElement passwordTxt;

    @FindBy(css = "form > button")
    private static WebElement createUserBtn;

    @FindBy(css = "div.css-17jy1b > button > div > svg")
    private static WebElement alertPopupClose;


    // Getters
    public List<WebElement> getUsersList(){
        return usersList;
    }

    public  WebElement getNewUserBtn(){
        return newUserBtn;
    }

    public  WebElement getNameTxt(){
        return nameTxt;
    }

    public  WebElement getEmailTxt(){
        return emailTxt;
    }

    public  WebElement getUsernameTxt(){
        return usernameTxt;
    }

    public  WebElement getPasswordTxt(){
        return passwordTxt;
    }

    public  WebElement getCreateUserBtn(){
        return createUserBtn;
    }

    public  WebElement getAlertPopupClose(){
        return alertPopupClose;
    }
}
