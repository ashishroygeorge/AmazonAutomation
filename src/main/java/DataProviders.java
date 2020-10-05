import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "validCredentials")
    public Object[][] validLoginData() {
        return new String[][]{{"ashishroy93@gmail.com", "jungleebillee"}};
    }

    @DataProvider(name = "inValidCredentials")
    public Object[]inValidEmail() {
        return new String[]{"%$#&^%@gmail.com"};
    }

    @DataProvider(name = "validPin")
    public Object[] validPinCode() {
        return new String[]{"689645"};
    }

    @DataProvider(name = "inValidPin")
    public Object[] inValidPinCode() {
        return new String[]{"120098"};
    }

    @DataProvider(name = "searchItem")
    public Object[] searchItem() {
        return new String[]{"Watches"};
    }

    @DataProvider(name = "newPassword")
    public Object[][] passwordChange() {
        return new String[][]{{"jungleebillee", "123shopper"}};
    }

}