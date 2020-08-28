package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {
    static private ThreadLocal<WebDriver> driverSafe = new ThreadLocal<>();
    public static WebDriver getInstance() {
        if (driverSafe.get()==null) {
            driverSafe.set(new ChromeDriver());
        }
        return driverSafe.get();
    }

}
