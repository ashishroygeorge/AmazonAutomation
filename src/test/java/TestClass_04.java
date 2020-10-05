import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass_04 extends TestClass_01 {

    @Test(timeOut = 20)
    public void verifyAboutFooter() {
        ExtendReport.methodEntryReport("Verify 'About' Field");
        AboutPage aboutPage=new AboutPage(newDriver);
        info=aboutPage.footer();
        newDriver=aboutPage.getDriver();
        Assert.assertTrue(info);
    }
}
