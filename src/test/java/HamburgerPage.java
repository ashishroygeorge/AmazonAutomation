import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HamburgerPage {

    private WebDriver driver;

    private By ham1 = By.xpath("//*[contains(@id,'hamburger-menu')]");
    private By ham2 = By.xpath("//*[contains(text(),'Mobiles, Computers')]");
    private By ham3 = By.xpath("//*[contains(text(),'Screen Protectors')]");
    private By ham4 = By.xpath("//h1[contains(text(),'Screen protectors')]");

    public HamburgerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean hamburger() {
        driver.findElement(ham1).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(ham2).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(ham3).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.findElement(ham4).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
