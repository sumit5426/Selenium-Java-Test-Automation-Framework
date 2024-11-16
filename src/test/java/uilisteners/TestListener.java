package uilisteners;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import uitest.TestBase;
import uiutility.BrowserUtility;
import uiutility.ExtentReportUtility;
import uiutility.LoggerUtility;

import java.util.Arrays;

public class TestListener implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());


    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReportUtility.setupSparkReporter("reports.html");

    }

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "PASSED");
        ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " " + "FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
        ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
        Object testclass=result.getInstance();
        BrowserUtility browserUtility=((TestBase)testclass).getInstance();
        logger.info("Capturing Screenshot for the failed test");
        String screenshotPath=browserUtility.takeScreenShot(result.getMethod().getMethodName());
        logger.info("Attaching the Screenshot to the HTML report");
        ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);

    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
        ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReportUtility.flushReport();


    }
}
