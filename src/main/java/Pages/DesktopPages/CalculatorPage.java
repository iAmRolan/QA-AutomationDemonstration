package Pages.DesktopPages;

import Utilities.CommonOps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class CalculatorPage extends CommonOps {

    public static WebElement getNumber(String number) {
        return driver.findElement(By.name(number));
    }

    public static WebElement getMathSign(String sign) {
        return driver.findElement(By.name(sign));
    }


    public static String getResult() {
        return driver.findElement(By.xpath("//*[@AutomationId='CalculatorResults']")).getText().replace("Display is", "").trim();
    }

    public static WebElement getClean() {
        return driver.findElement(By.xpath("//*[@AutomationId='clearButton']"));
    }

}
