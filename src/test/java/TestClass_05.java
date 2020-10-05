import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass_05 extends TestClass_01 {

    @Test
    public void verifyHamburger() {
        ExtendReport.methodEntryReport("Verify Hamburger Icon");
        HamburgerPage hamburgerPage=new HamburgerPage(newDriver);
        info=hamburgerPage.hamburger();
        newDriver=hamburgerPage.getDriver();
        Assert.assertTrue(info);
    }
}
