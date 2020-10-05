import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass_06 extends TestClass_01 {

    @Test(timeOut = 20,dataProvider = "validPin",dataProviderClass = DataProviders.class)
    public void verifyValidPinCode(String pinCode) throws Exception {
        ExtendReport.methodEntryReport("Verify Valid Pin Code");
        PinCodePage pinCodePage1=new PinCodePage(newDriver);
        info=pinCodePage1.validPinCode(pinCode);
        Thread.sleep(5000);
        newDriver=pinCodePage1.getDriver();
        Assert.assertTrue(info);
    }
}