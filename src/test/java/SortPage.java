import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SortPage {


    private WebDriver driver;
    private By sortingElement = By.xpath("//span[contains(text(),'Sort by:')]");
    private By highToLow = By.xpath("//a[contains(text(),'High to Low')]");
    private By highToLowVerify = By.xpath("//span[contains(text(),'Price: High to Low')]");


    public SortPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean sort() {
        driver.findElement(sortingElement).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(highToLow).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(highToLowVerify).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}


