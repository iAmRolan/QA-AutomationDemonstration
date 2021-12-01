package Extensions;

import Utilities.CommonOps;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class UIActions extends CommonOps {

    @Step("Click web element.")
    public static void clickElement(WebElement webElement) {
        webElement.click();
    }

    @Step("Hover over web element.")
    public static void hoverOverElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    @Step("Send keys to element.")
    public static void sendKeysToElement(WebElement webElement, String keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Step("Resize element")
    public static void resizeElement(WebElement element) {
        actions.dragAndDropBy(element, xOffset, yOffset).perform();
    }

    @Step("Scroll to web element.")
    public static void scrollToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    @Step("Send RETURN Key.")
    public static void sendReturnKey(WebElement webElement) {
        webElement.sendKeys(Keys.RETURN);
    }

    @Step("Swipe screen to a certain direction on Android.")
    public static void swipeScreen(Direction dir){
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions


        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionStart = PointOption.point(dims.width - 10, dims.height / 2);
                pointOptionEnd = PointOption.point(10, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionStart = PointOption.point(10, dims.height / 2);
                pointOptionEnd = PointOption.point(dims.width - 10, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
