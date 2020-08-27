import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Hashtable;

public class DriverManage{

    private static final Hashtable<Short, WebDriver> instances =
            new Hashtable<>();
//    private WebDriver driver;
//
//    DriverManage(WebDriver driver) {
//        this.driver = driver;
//    }

    public static WebDriver getInstance(short numb) {
        // Lazy init (not thread safe as written)
        // Recommend using Double Check Locking if needing thread safety
        if (!instances.containsKey(numb)) {
            instances.put(numb, new ChromeDriver());
        }
        return instances.get(numb);
    }
}