import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage {

    private WebDriver driver;
    private By aboutUs = By.xpath("//*[contains(text(),'About Us')]");

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean footer() {
        driver.findElement(aboutUs).click();
        String s=driver.getCurrentUrl();
        return s.contains("aboutamazon.in");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
