package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Extent Report Demo");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Mohamed Numaan");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = getExtentReports().createTest(testName);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }
}
