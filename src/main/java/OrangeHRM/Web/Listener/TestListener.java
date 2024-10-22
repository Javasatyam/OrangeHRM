package OrangeHRM.Web.Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import OrangeHRM.Web.Base.Page;

public class TestListener implements ITestListener {
    ExtentSparkReporter sparkReporter;
    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        String reportPath = System.getProperty("user.dir") + "/test-output/extentReport.html";
        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Your Name");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getMethod().getMethodName());
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result)  {
        System.out.println("Test failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Take screenshot on failure
        WebDriver driver = getDriverInstance();
        if (driver != null) {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName(), driver);
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    private String captureScreenshot(String methodName, WebDriver driver) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String screenshotName = methodName + "_" + timestamp + ".png";
        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName;

        // Ensure the screenshots directory exists
        File screenshotDir = new File(System.getProperty("user.dir") + "/screenshots/");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs(); // Creates the directory if it doesn't exist
        }

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(destination));
            System.out.println("Screenshot saved: " + destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination; // Return the screenshot path
    }

    // Method to retrieve WebDriver instance from the Page class
    private WebDriver getDriverInstance() {
        return Page.driver;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Optional: Add any implementation for skipped tests
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: Add any implementation for tests that failed but are within success percentage
    }
}
