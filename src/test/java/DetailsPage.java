import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DetailsPage {

    private WebDriver driver;
    private By productElement = By.xpath("//*[@data-image-index='2']");

    public DetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkDetails() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String clickedName = driver.findElement(productElement).getAttribute("alt");
        System.out.println(clickedName);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(productElement).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Switch Tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean b = driver.findElement(By.xpath("//*[contains(text(),\"" + clickedName + "\")]")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return b;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

