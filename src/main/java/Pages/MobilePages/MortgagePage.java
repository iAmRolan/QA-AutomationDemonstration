package Pages.MobilePages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MortgagePage {
    @FindBy(xpath = "//*[@id='etAmount']")
    private static AndroidElement amountInput;

    @FindBy(xpath = "//*[@id='etTerm']")
    private static AndroidElement termInput;

    @FindBy(xpath = "//*[@id='etRate']")
    private static AndroidElement rateInput;

    @FindBy(xpath = "//*[@id='add_schedule_text']")
    private static AndroidElement calculateBtn;

    @FindBy(xpath = "//*[@id='btnSave']")
    private static AndroidElement saveBtn;

    @FindBy(xpath = "//*[@id='tvRepayment']")
    private static AndroidElement lastSavedRepayment;

    public MortgagePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(3)), this);
    }

    public AndroidElement getAmountInput() {
        return amountInput;
    }

    public AndroidElement getTermInput() {
        return termInput;
    }

    public AndroidElement getRateInput() {
        return rateInput;
    }

    public AndroidElement getCalculateBtn() {
        return calculateBtn;
    }

    public AndroidElement getSaveBtn() {
        return saveBtn;
    }

    public AndroidElement getLastSavedRepayment() {
        return lastSavedRepayment;
    }
}