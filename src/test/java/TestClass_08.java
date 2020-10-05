import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass_08 extends TestClass_01 {

    @Test(dataProvider = "searchItem",dataProviderClass = DataProviders.class)
    public void verifySearch(String searchItem) {
        ExtendReport.methodEntryReport("Verify Search");
        ResultsPage resultsPage=new ResultsPage(newDriver);
        info=resultsPage.search(searchItem);
        newDriver=resultsPage.getDriver();
        Assert.assertTrue(info);
    }
    @Test(dependsOnMethods = {"verifySearch"} )
    public void verifyFilter() throws Exception {
        ExtendReport.methodEntryReport("Verify Filter : \"Prime\" filter");
        FilterPage filterPage=new FilterPage(newDriver);
        info=filterPage.filter();
        newDriver=filterPage.getDriver();
        Assert.assertTrue(info);
    }

    @Test(dependsOnMethods = {"verifyFilter"} )
    public void verifySorting() {
        ExtendReport.methodEntryReport("Verify Sorting");
        SortPage sortPage=new SortPage(newDriver);
        info=sortPage.sort();
        newDriver=sortPage.getDriver();
        Assert.assertTrue(info);
    }
}
