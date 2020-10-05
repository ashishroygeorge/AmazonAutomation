import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AddressPage {

    private WebDriver driver;
    private By yourAddressBox = By.xpath("//*[contains(text(),'Your Address')]");
    private By addAddressBox = By.xpath("//*[contains(text(),'Add address')]");
    private By fullNameBox = By.xpath("//*[contains(@id,'AddressFullName')]");
    private By mobileNumberBox = By.xpath("//*[contains(@id,'AddressPhoneNumber')]");
    private By pinCodeBox = By.xpath("//*[contains(@id,'AddressPostalCode')]");
    private By addressLineOneBox = By.xpath("//*[contains(@id,'AddressLine1')]");
    private By addressLineTwoBox = By.xpath("//*[contains(@id,'AddressLine2')]");
    private By landMarkBox = By.xpath("//*[contains(@id,'landmark')]");
    private By cityBox = By.xpath("//*[contains(@id,'AddressCity')]");
    private By stateDropDown = By.xpath("//span[contains(text(),'Select state')]");
    private By state = By.xpath("//*[contains(@data-value,'" + PropertyFiles.state + "')]");
    private By addressTypeDropDown = By.xpath("//span[contains(text(),'Select an Address Type')]");
    private By addressType = By.xpath("//*[contains(text(),'Home') and contains(@data-value,'RES')]");
    private By submitAddress = By.xpath("//input[contains(@type,'submit') and contains(@class,'button')]");
    private By saveSuccess = By.xpath("//*[contains(text(),'Address saved')]");

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean changeAddress() throws Exception {
        PropertyFiles.getAddressInfo();
        driver.findElement(yourAddressBox).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(addAddressBox).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(fullNameBox).sendKeys(PropertyFiles.fullName);
        driver.findElement(mobileNumberBox).sendKeys(PropertyFiles.phoneNumber);
        driver.findElement(pinCodeBox).sendKeys(PropertyFiles.pinCode);
        driver.findElement(addressLineOneBox).sendKeys(PropertyFiles.addressOne);
        driver.findElement(addressLineTwoBox).sendKeys(PropertyFiles.addressTwo);
        driver.findElement(landMarkBox).sendKeys(PropertyFiles.landmark);
        driver.findElement(cityBox).sendKeys(PropertyFiles.city);
        driver.findElement(stateDropDown).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(state).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(addressTypeDropDown).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(addressType).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(submitAddress).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        return driver.findElement(saveSuccess).isDisplayed();

    }

    public WebDriver getDriver() {
        return driver;
    }
}


