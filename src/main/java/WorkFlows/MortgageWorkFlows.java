package WorkFlows;

import Extensions.UIActions;
import Extensions.Verifications;
import Utilities.CommonOps;
import Utilities.ManageDB;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

import java.sql.SQLException;

public class MortgageWorkFlows extends CommonOps {
    @Step("Enter data from DB and verify the data received is above 0")
    public static void enterDataFromDB() throws SQLException {

        amountList = ManageDB.getCredentials(getData("SelectAmountColumn"));
        termList = ManageDB.getCredentials(getData("SelectTermColumn"));
        rateList = ManageDB.getCredentials(getData("SelectRateColumn"));

        for (int i = 0; i < amountList.size(); i++) {
            enterDataInInputsAndCalculate(i);
            verifyAboveZeroValues(i);
        }
        softAssert.assertAll();
    }

    @Step("Enter data and calculate")
    public static void enterDataInInputsAndCalculate(int index) {
        UIActions.sendKeysToElement(mortgagePage.getAmountInput(), amountList.get(index));
        UIActions.sendKeysToElement(mortgagePage.getTermInput(), termList.get(index));
        UIActions.sendKeysToElement(mortgagePage.getRateInput(), rateList.get(index));
        UIActions.clickElement(mortgagePage.getCalculateBtn());
    }

    @Step("Verify values above zero")
    public static void verifyAboveZeroValues(int index) {
        Verifications.verifyValuesAboveZero(amountList.get(index), termList.get(index), rateList.get(index));
    }

    @Step("Verify last one was saved")
    public static void checkIfSaved() {
        UIActions.clickElement(mortgagePage.getSaveBtn());
        UIActions.swipeScreen(UIActions.Direction.LEFT);
    }
}