package Extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class Verifications extends CommonOps {

    @Step("Verify given strings.")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify image exists.")
    public static void verifyImage(boolean result) {
        assertTrue(result);
    }

    @Step("Verify element resize")
    public static void verifyDimensions(Map<String, String> actualDimensions, Map<String, String> expectedDimensions) {
        assertEquals(actualDimensions, expectedDimensions);
    }

    @Step("Verify all users added.")
    public static void verifyUsersAdded(List<WebElement> webElements) {
        assertEquals(expectedAddedUsers, webElements.size());
    }

    @Step("Verify there is no such panel")
    public static void verifyPanelFound(WebElement elem) {
        Assert.assertNotNull(elem, "The panel with this name does not exists.");
    }

    @Step("Verify panel was removed")
    public static void verifyPanelIsRemoved(List<WebElement> list, String panelName) {
        for (WebElement elem : list)
            Assert.assertNotEquals(elem.getText(), panelName, "Panel was not deleted!");
    }

    @Step("Verify Api response code")
    public static void verifyResponseCode(int response, int code) {
        assertEquals(response, code);
    }

    @Step("Verify values are above zero")
    public static void verifyValuesAboveZero(String amount, String term, String rate) {
        softAssert = new SoftAssert();
        softAssert.assertTrue(Integer.parseInt(amount) > 0, "Amount must be above 0.");
        softAssert.assertTrue(Integer.parseInt(term) > 0, "Term must be above 0.");
        softAssert.assertTrue(Integer.parseInt(rate) > 0, "Rate must be above 0.");
    }

    @Step("Verify last object is saved")
    public static void verifyLastObjSaved(String expected, String actual) {
        Assert.assertEquals(expected, actual, "Last calculation wasn't saved");
    }
}
