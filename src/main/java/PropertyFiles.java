import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFiles {
    static String browser;
    static String url;
    static String fullName;
    static String phoneNumber;
    static String pinCode;
    static String addressOne;
    static String addressTwo;
    static String landmark;
    static String city;
    static String state;

    public static void getBrowsingInfo() throws Exception{
        Properties prop = new Properties();
        InputStream iStr = new FileInputStream("browserConfig.properties");
        prop.load(iStr);
        browser = prop.getProperty("browser");
        url = prop.getProperty("url");
    }
    public static void getAddressInfo() throws Exception{
        Properties prop = new Properties();
        InputStream iStr = new FileInputStream("addressConfig.properties");
        prop.load(iStr);
        fullName= prop.getProperty("fullName");
        phoneNumber= prop.getProperty("phoneNumber");
        pinCode = prop.getProperty("pinCode");
        addressOne = prop.getProperty("addressOne");
        addressTwo= prop.getProperty("addressTwo");
        landmark= prop.getProperty("landmark");
        city = prop.getProperty("city");
        state = prop.getProperty("state");

    }
}
