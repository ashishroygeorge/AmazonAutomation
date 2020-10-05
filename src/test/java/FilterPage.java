import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FilterPage {

    private WebDriver driver;
    private By searchCount = By.xpath("//*[contains(text(),'results for')]");
    private By filteringElement = By.xpath("//*[contains(@aria-label,'Prime Eligible') and contains(@class,'icon')]");
    private By filterCount = By.xpath("//*[contains(text(),'of over')]");

    public FilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean filter() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String sCount = driver.findElement(searchCount).getText();
        Thread.sleep(3000);
        driver.findElement(filteringElement).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
        String fCount = driver.findElement(filterCount).getText();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean b = sCount.equals(fCount);
        return !b;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

