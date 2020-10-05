import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PinCodePage {
    private WebDriver driver;
    //private By selectAddressHeader = By.xpath("//*[contains(@id,'line1') and contains(text(),'Hello')]");
    private By selectAddressHeader = By.xpath("//*[contains(text(),'Select your address')]");
    private By pinBox = By.xpath("//*[contains(@maxlength,'6') or contains(@aria-label,'or enter a pincode')]");
    private By applyButton = By.xpath("//*[contains(@aria-labelledby,'Update-announce')]");
    private By inValidMessage = By.xpath("//*[contains(text(),'Please enter a valid pincode')]");

    public PinCodePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validPinCode(String pin) {
        driver.findElement(selectAddressHeader).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(pinBox).sendKeys(pin);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(applyButton).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//*[contains(text(),'" + pin + "')]")).isDisplayed();
    }

    public boolean inValidPinCode(String pin) {
        driver.findElement(selectAddressHeader).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(pinBox).sendKeys(pin);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(applyButton).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(inValidMessage).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
