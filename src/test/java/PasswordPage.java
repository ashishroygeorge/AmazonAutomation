import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {

    private WebDriver driver;
    private By loginAndSecurityBox = By.xpath("//*[contains(text(),'Login') and contains(text(),'security')] ");
    private By editPasswordButton = By.xpath("//*[contains(@id,'password') and contains(@id,'edit')] ");
    private By currentPasswordBox=By.xpath("//*[contains(@name,'password') and contains(@tabindex,'1')]");
    private By newPasswordBox=By.xpath("//*[contains(@name,'password') and contains(@tabindex,'2')]");
    private By reEnterPasswordBox=By.xpath("//*[contains(@name,'password') and contains(@tabindex,'3')]");
    private By saveChangesButton=By.xpath("//*[contains(@type,'submit') and contains(@tabindex,'5')]");
    private By successMessage=By.xpath("//*[contains(text(),'Success') and contains(@class,'heading')]");


    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean changePassword(String oldPassword,String newPassword) {
        driver.findElement(loginAndSecurityBox).click();
        driver.findElement(editPasswordButton).click();
        driver.findElement(currentPasswordBox).sendKeys(oldPassword);
        driver.findElement(newPasswordBox).sendKeys(newPassword);
        driver.findElement(reEnterPasswordBox).sendKeys(newPassword);
        driver.findElement(saveChangesButton).click();

        return driver.findElement(successMessage).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

