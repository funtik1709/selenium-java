package common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.testUtils;

import java.io.IOException;

public class Listeners extends testUtils implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("Listener Info. OnTestStart");
    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Listener Info. OnTestFailure");
        try {
            getScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }


}
