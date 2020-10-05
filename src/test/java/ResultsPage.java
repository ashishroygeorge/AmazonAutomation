import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ResultsPage {

    private WebDriver driver;
    private By searchBox = By.xpath("//*[contains(@aria-label,'Search') or contains(@id,'twotabsearchtextbox')]");
    private By goButton = By.xpath("//*[contains(@value,'Go')]");
    private By ElementOne = By.xpath("//option[contains(text(),'Watch')]");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean search(String searchItem) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(searchBox).sendKeys(searchItem);
        driver.findElement(goButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(ElementOne).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}


