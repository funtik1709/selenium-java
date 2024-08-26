package common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilities.testUtils;

import java.io.IOException;

public class Listeners extends testUtils implements ITestListener {
    public void onTestStart(ITestResult result) {
        Reporter.log("Method name is "+result.getName());
        System.out.println("Listener Info. OnTestStart - "+result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        Reporter.log("Status of run is "+result.getStatus());
        System.out.println("Status of run is - "+result.getStatus());
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
