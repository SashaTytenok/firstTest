package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Hashtable;

public class DriverManage{

    private static final Hashtable<Long, WebDriver> instances =
            new Hashtable<>();

    public static WebDriver getInstance(long numb) {
        if (!instances.containsKey(numb)) {
            instances.put(numb, new ChromeDriver());
        }
        return instances.get(numb);
    }
}