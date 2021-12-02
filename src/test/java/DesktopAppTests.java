import Extensions.Verifications;
import Utilities.CommonOps;
import WorkFlows.DesktopWorkFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class DesktopAppTests extends CommonOps {

    @Test(description = "Test addition")
    @Description("Verify result after addition")
    public void test01_addition() {
        DesktopWorkFlows.addition();
        Verifications.verifyText(calculatorPage.getResult(), getData("ExpectedAdditionResult"));
    }

    @Test(description = "Test Multiplication function")
    @Description("Verify Multiplication function result")
    public void test2_multiplication() {
        DesktopWorkFlows.mul();
        Verifications.verifyText(calculatorPage.getResult(), getData("ExpectedMulResult"));
    }
}
