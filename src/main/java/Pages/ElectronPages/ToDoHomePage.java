package Pages.ElectronPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Rolan Abdualiev , Nov 2021
 * @project JavaHackathon
 */
public class ToDoHomePage {

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/input")
    private static WebElement taskInput;

    @FindBy(css = "body > div > div.transition_1AwoP > div.wrapper_DtvJU > div:nth-child(2) > div > div > div > div > svg")
    private static WebElement deleteIcon;

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/div/div/div/div/div/label")
    private static WebElement task;

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/h2")
    private static WebElement noTask;

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/header/div/span")
    private static WebElement date;


    public WebElement getTaskInput() {
        return taskInput;
    }

    public WebElement getDeleteIcon() {
        return deleteIcon;
    }

    public WebElement getTask() {
        return task;
    }

    public WebElement getNoTask(){
        return noTask;
    }

    public WebElement getDate(){
        return date;
    }

}
