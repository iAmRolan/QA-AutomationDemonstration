import Extensions.Verifications;
import Utilities.CommonOps;
import WorkFlows.ToDoAppWorkFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class ToDoAppTests extends CommonOps {

    @Test(description = "Test task creation")
    @Description("Verify task created")
    public void test01_createTask() {
        ToDoAppWorkFlows.addNewTask();
        Verifications.verifyText(expectedTaskTest, toDoHomePage.getTask().getText());
    }

    @Test(description = "Test task delete")
    @Description("Verify task deleted")
    public void test02_deleteTask() {
        ToDoAppWorkFlows.deleteTask();
        Verifications.verifyText(expectedTextAfterDelete, toDoHomePage.getNoTask().getText());
    }

    @Test(description = "Test Date")
    @Description("Verify correct date")
    public void test03_Date() {
        Verifications.verifyText(ToDoAppWorkFlows.getDateToString(), dtf.format(now));
    }
}
