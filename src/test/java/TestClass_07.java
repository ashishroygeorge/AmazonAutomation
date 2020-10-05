import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass_07 extends TestClass_01 {

    @Test(timeOut = 20,dataProvider = "inValidPin",dataProviderClass = DataProviders.class)
    public void verifyInvalidPinCode(String pinCode) throws Exception {
        ExtendReport.methodEntryReport("Verify Invalid Pin Code");
        PinCodePage pinCodePage2=new PinCodePage(newDriver);
        info=pinCodePage2.inValidPinCode(pinCode);
        Thread.sleep(5000);
        newDriver=pinCodePage2.getDriver();
        Assert.assertTrue(info);
    }
}
