package WorkFlows;

import Extensions.UIActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class ToDoAppWorkFlows extends CommonOps {

    @Step
    public static void addNewTask() {
        expectedTaskTest = "Test";
        UIActions.sendKeysToElement(toDoHomePage.getTaskInput(), expectedTaskTest);
        UIActions.sendReturnKey(toDoHomePage.getTaskInput());
    }

    @Step
    public static void deleteTask() {
        expectedTextAfterDelete = "There's no task";
        UIActions.clickElement(toDoHomePage.getDeleteIcon());
    }

    @Step
    public static String getDateToString() {
        return toDoHomePage.getDate().getText();
    }
}
