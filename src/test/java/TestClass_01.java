import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class TestClass_01 {

    public WebDriver newDriver;
    public WebDriver newDriver2;
    public boolean info;

    @BeforeTest
    public void setUpReport() {
        ExtendReport.beginReport();
    }

    @BeforeClass()
    public void openBrowserForTest() throws Exception {
        PropertyFiles.getBrowsingInfo();
        PropertyFiles.getAddressInfo();
        Driver.SetBrowser(PropertyFiles.browser);
        newDriver = Driver.openBrowser(PropertyFiles.url);
    }

    @AfterMethod
    public void logStatus(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtendReport.listenerPassEntryReport(newDriver, result.getName() + " PASSED");
            System.out.println(result.getName()+" Passed");
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtendReport.listenerFailEntryReport(newDriver, result.getName() + " FAILED");
            System.out.println(result.getName()+" Failed");
        }
    }

    @AfterClass
    public void closeBrowser(){
        newDriver.close();
    }

    @AfterTest
    public void teardown() {
        ExtendReport.endReport();
    }

}