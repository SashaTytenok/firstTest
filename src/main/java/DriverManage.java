import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import services.MultitonType;
import java.util.Hashtable;

public class DriverManage {
    private static final Hashtable<MultitonType, WebDriver> instances =
            new Hashtable<MultitonType, WebDriver>();
//    private WebDriver driver;
//
//    DriverManage(WebDriver driver) {
//        this.driver = driver;
//    }

    public static synchronized WebDriver getInstance(MultitonType number) {
        // Lazy init (not thread safe as written)
        // Recommend using Double Check Locking if needing thread safety
        if (!instances.containsKey(number)) {
            instances.put(number, new ChromeDriver());
        }
        return instances.get(number);
    }
}