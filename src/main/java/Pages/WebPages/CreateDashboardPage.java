package Pages.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class CreateDashboardPage {
    @FindBy(css = "#PanelFrameTitle")
    private static WebElement title;

    @FindBy(css = "div:nth-child(2) > textarea")
    private static WebElement description;

    @FindBy(css = "div:nth-child(4) > div.css-zer0lh > div:nth-child(1) > div:nth-child(2) > div > label:nth-child(4)")
    private static WebElement barsStyle;

    @FindBy(css = "div:nth-child(4) > div.css-zer0lh > div:nth-child(3) > div:nth-child(2) > div > label > div.css-fvkifa-input-wrapper > div > input")
    private static WebElement lineWidthTextBox;

    @FindBy(css = " div.css-zer0lh > div:nth-child(1) > div:nth-child(2) > div > div > div > div > input")
    private static WebElement unitPicker;

    @FindBy(css = "body > div:nth-child(13) > div > div > div > ul")
    private static WebElement unitUl;

    @FindBy(xpath = "//*[@class='rc-cascader-menu']//*[10]")
    private static WebElement dateAndTimePicker;

    @FindBy(xpath = "/html/body/div[4]/div/div/div/ul[2]//*[@title='Datetime ISO']")
    private static WebElement dateTimeISO;

    @FindBy(xpath = "//*[@id=\"reactRoot\"]/div/main/div[3]/div[2]/div[1]/div[6]/button/div")
    private static WebElement applyButton;


    // Getters
    public WebElement getTitle() {
        return title;
    }

    public WebElement getUnitUl() {
        return unitUl;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getBarsStyle() {
        return barsStyle;
    }

    public WebElement getLineWidthTextBox() {
        return lineWidthTextBox;
    }

    public WebElement getUnitPicker() {
        return unitPicker;
    }

    public WebElement getDateAndTimePicker() {
        return dateAndTimePicker;
    }

    public WebElement getDateTimeISO() {
        return dateTimeISO;
    }

    public WebElement getApplyButton() {
        return applyButton;
    }
}
