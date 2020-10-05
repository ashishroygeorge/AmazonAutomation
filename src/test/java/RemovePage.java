import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RemovePage {
    private WebDriver driver;
    private By deleteButton = By.xpath("//input[contains(@value,'Delete')]");
    private By emptiedMsg=By.xpath("//*[contains(text(),'Your Amazon Basket is empty')]");

    public RemovePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean removeItem() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(deleteButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(emptiedMsg).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
