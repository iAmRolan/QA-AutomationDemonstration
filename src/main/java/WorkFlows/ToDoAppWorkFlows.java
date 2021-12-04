package WorkFlows;

import Extensions.UIActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class ToDoAppWorkFlows extends CommonOps {

    @Step("Add new task.")
    public static void addNewTask() {
        expectedTaskTest = getData("ExpectedTaskTest");
        UIActions.sendKeysToElement(toDoHomePage.getTaskInput(), expectedTaskTest);
        UIActions.sendReturnKey(toDoHomePage.getTaskInput());
    }

    @Step("Delete first task.")
    public static void deleteTask() {
        expectedTextAfterDelete = getData("ExpectedTextAfterDelete");
        UIActions.clickElement(toDoHomePage.getDeleteIcon());
    }

    @Step
    public static String getDateToString() {
        return toDoHomePage.getDate().getText();
    }
}
