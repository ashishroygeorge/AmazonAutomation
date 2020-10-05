import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass_02 extends TestClass_01 {
    @Test(dataProvider = "inValidCredentials", dataProviderClass = DataProviders.class)
    public void verifyInvalidLogin(String username) {
        ExtendReport.methodEntryReport("Invalid Login Test");
        LoginPage loginPage1 = new LoginPage(newDriver);
        info = loginPage1.invalidEmail(username);
        newDriver = loginPage1.getDriver();
        Assert.assertTrue(info);
    }
}

