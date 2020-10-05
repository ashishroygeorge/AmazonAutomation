import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    private By helloSignIn=By.xpath("//*[contains(text(),'Hello, Sign in')]");
    private By email=By.xpath("//*[contains(@name,'email')]");
    private By continueButton=By.xpath("//input[contains(@aria-labelledby,'continue')]");
    private By pwd=By.xpath("//input[contains(@name,'password')]");
    private By loginButton=By.xpath("//*[contains(@id,'signInSubmit')]");
    private By invalidEmailMessage=By.xpath("//*[contains(text(),'We cannot find an account with that email address')]");
    private By helloUser=By.xpath("//a[contains(@id,'accountList')]");
    private By successLogin=By.xpath("//*[contains(text(),' Your Account')] ");

    public LoginPage(WebDriver driver){

        this.driver=driver;
    }

    public boolean invalidEmail(String userName){
        driver.findElement(helloSignIn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(email).sendKeys(userName);
        driver.findElement(continueButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(invalidEmailMessage).isDisplayed();
    }
    public boolean validLogin(String userName,String password){
        driver.findElement(helloSignIn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(email).sendKeys(userName);
        driver.findElement(continueButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(pwd).sendKeys(password);
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(helloUser).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(successLogin).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
