import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CartPage {

    private WebDriver driver;
    private By productTitle = By.xpath("//*[@id='productTitle']");
    private By addToCartElement = By.xpath("//input[contains(@value,'Add to Cart')]");
    private By goToCartButton = By.xpath("//*[contains(@id,'cart') and contains(text(),'Cart')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean addToCart() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String loadedName = driver.findElement(productTitle).getText();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(addToCartElement).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(goToCartButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//*[contains(@alt,\"" + loadedName + "\")]")).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

