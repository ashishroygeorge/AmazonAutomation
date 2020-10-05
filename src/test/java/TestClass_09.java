import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass_09 extends TestClass_01 {

    @Test(dataProvider = "searchItem",dataProviderClass = DataProviders.class)
    public void verifySearch(String searchItem) {
        ExtendReport.methodEntryReport("Verify Search");
        ResultsPage resultsPage=new ResultsPage(newDriver);
        info=resultsPage.search(searchItem);
        newDriver=resultsPage.getDriver();
        Assert.assertTrue(info);
    }
    @Test(dependsOnMethods = {"verifySearch"} )
    public void verifyProductDetails() {
        ExtendReport.methodEntryReport("Verify Product Details");
        DetailsPage detailsPage=new DetailsPage(newDriver);
        info=detailsPage.checkDetails();
        newDriver=detailsPage.getDriver();
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods = "verifyProductDetails")
    public void verifyAddToCart() {
        ExtendReport.methodEntryReport("Verify Add To Cart");
        CartPage cartPage=new CartPage(newDriver);
        info=cartPage.addToCart();
        newDriver=cartPage.getDriver();
        newDriver2=cartPage.getDriver();
        Assert.assertTrue(info);
    }
    @Test(dependsOnMethods = {"verifyAddToCart"} )
    public void verifySaveForLater() throws Exception {
        ExtendReport.methodEntryReport("Verify Save for Later");
        SaveForLaterPage saveForLaterPage=new SaveForLaterPage(newDriver);
        info=saveForLaterPage.saveForLater();
        newDriver=saveForLaterPage.getDriver();
        Assert.assertTrue(info);
    }
   @Test(dependsOnMethods = {"verifyAddToCart","verifySaveForLater"} )
    public void verifyRemoveFromCart() throws Exception {
        ExtendReport.methodEntryReport("Verify Remove From Cart");
        RemovePage removePage=new RemovePage(newDriver);
        info=removePage.removeItem();
        Thread.sleep(5000);
        newDriver=removePage.getDriver();
        Assert.assertTrue(info);
    }

}
