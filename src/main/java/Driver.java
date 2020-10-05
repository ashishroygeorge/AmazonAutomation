import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    private static WebDriver driver = null;

    public static void SetBrowser(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
                //disabled popup
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);//launch browser
                break;

            case "ie":
                System.setProperty("webdriver.ie.driver", "src//main//resources//IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                InternetExplorerOptions ieoptions = new InternetExplorerOptions(capabilities);
                driver = new InternetExplorerDriver(ieoptions);
                break;
        }
    }
    public static WebDriver openBrowser(String url){
        driver.manage().window().maximize();//maximize window
        driver.navigate().to(url);//navigate to url
        return driver;
    }

}

