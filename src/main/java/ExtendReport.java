import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ExtendReport {
    static ExtentReports extentReports;
    static ExtentSparkReporter extentSparkReporter;
    static ExtentTest extentTest;

    public static void beginReport() {

        String path = System.getProperty("user.dir");
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(path + "\\report\\report.html");
        extentSparkReporter.config().setDocumentTitle("Amazon Report - Ashish");
        extentSparkReporter.config().setReportName("Amazon Test Report");
        extentReports.setSystemInfo("Machine Name", "Ashish");
        extentReports.attachReporter(extentSparkReporter);

    }

    public static void methodEntryReport(String testName) {
        extentTest = extentReports.createTest(testName);
    }

    public static void listenerPassEntryReport(WebDriver driver,String passInfo) throws IOException {

        extentTest.log(Status.PASS, passInfo);
        extentTest.addScreenCaptureFromPath(Screenshot.takeScreenshot(driver));
    }
    public static void listenerFailEntryReport(WebDriver driver,String failInfo) throws IOException {

        extentTest.log(Status.FAIL, failInfo);
        extentTest.addScreenCaptureFromPath(Screenshot.takeScreenshot(driver));
    }

    public static void endReport() {
        extentReports.flush();
    }
}
