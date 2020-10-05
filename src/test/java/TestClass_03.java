import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass_03 extends TestClass_01 {
    @Test(dataProvider = "validCredentials", dataProviderClass = DataProviders.class)
    public void verifyValidLogin(String username, String password) {
        ExtendReport.methodEntryReport("Login Test");
        LoginPage loginPage2 = new LoginPage(newDriver);
        info = loginPage2.validLogin(username, password);
        newDriver = loginPage2.getDriver();
        newDriver2 = loginPage2.getDriver();
        Assert.assertTrue(info);
    }
    @Test(dependsOnMethods = "verifyValidLogin")
    public void verifyAddNewAddress() throws Exception {
        ExtendReport.methodEntryReport("Add New Address");
        AddressPage addressPage=new AddressPage(newDriver);
        info=addressPage.changeAddress();
        newDriver=addressPage.getDriver();
        Assert.assertTrue(info);
    }

   /* @Test(dependsOnMethods = {"verifyValidLogin"}, dataProvider = "newPassword", dataProviderClass = DataProviders.class)
    public void verifyChangePassword(String oldPassword, String newPassword) throws Exception {
        ExtendReport.methodEntryReport("Change Password");
        PasswordPage passwordPage = new PasswordPage(newDriver2);
        info = passwordPage.changePassword(oldPassword, newPassword);
        newDriver = passwordPage.getDriver();
        Assert.assertTrue(info);
    }*/
}