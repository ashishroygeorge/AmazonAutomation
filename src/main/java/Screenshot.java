import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

        public static String takeScreenshot(WebDriver driver) throws IOException {
                TakesScreenshot ss = (TakesScreenshot) driver;
                File screenshot = ss.getScreenshotAs(OutputType.FILE);

                String dateName = new SimpleDateFormat("MMddhhmmss").format(new Date());
                String fileName = System.getProperty("user.dir") + "\\report\\" + "screenshot" + dateName + ".png";
                //Random random = new Random();
                //String fileName = System.getProperty("user.dir") + "\\report\\" +"screenshot" + random.nextInt(1000) + ".png";

                File destination = new File(fileName);
                FileUtils.copyFile(screenshot, destination);
                return fileName;
        }
}
