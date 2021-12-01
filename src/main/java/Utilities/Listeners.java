package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

/**
 * @author Rolan Abdualiev , Nov 2021
 * @project JavaHackathon
 */
public class Listeners implements ITestListener {

    public void onStart(ITestContext execution) {
        // TODO Auto-generated method stub
    }

    public void onFinish(ITestContext execution) {
        // TODO Auto-generated method stub
    }

    public void onTestStart(ITestResult test) {
        try {
            Utilities.MonteScreenRecorder.startRecord(test.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult test) {
        // TODO Auto-generated method stub
        try {
            Utilities.MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File("./test-recordings/" + test.getName() + ".avi");
        if (file.delete()) {
            System.out.println("Record deleted.");
        } else {
            System.out.println("Test success but record wasn't deleted.");
        }
        System.out.println("From listener: " + test.getName() + " success");
    }

    public void onTestFailure(ITestResult test) {
        // TODO Auto-generated method stub
        try {
            Utilities.MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("From listener: Test failed");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        // TODO Auto-generated method stub
    }
}
