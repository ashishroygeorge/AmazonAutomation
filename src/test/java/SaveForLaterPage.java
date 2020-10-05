import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SaveForLaterPage {

    private WebDriver driver;
    private By saveForLaterButton = By.xpath("//*[contains(@value,'Save for later')]");
    private By savedConfirmation=By.xpath("//div[contains(text(),'Saved for later')]");
    private By emptyCart=By.xpath("//*[contains(text(),'0 items')]");

    public SaveForLaterPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean saveForLater() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(saveForLaterButton).click();
        Thread.sleep(5000);
        boolean savedMsg=driver.findElement(savedConfirmation).isDisplayed();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean cartIsEmpty=driver.findElement(emptyCart).isDisplayed();
        Thread.sleep(5000);
        return savedMsg&&cartIsEmpty;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
