import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import datasource.MessageClass;
import datasource.UserClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import services.MultitonType;
import java.util.concurrent.TimeUnit;

@RunWith(ConcurrentTestRunner.class)
public class MainPageTest1 {
    @Before
    public void setUp(){
        UserBehavior.tmp=MultitonType.ONE;
        System.setProperty("webdriver.chrome.driver", "D:\\TMP\\tests\\drivers\\chromedriver.exe");
        UserBehavior.driver = DriverManage.getInstance(UserBehavior.tmp);
        UserBehavior.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        UserBehavior.driver.manage().deleteAllCookies();
        UserBehavior.driver.get("https://mail.yandex.ru/?noretpath=1");
        //UserBehavior.driver = new ChromeDriver();
        //UserBehavior.driver.manage().window().maximize();


/*        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("83.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        RemoteWebDriver driverR = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
        UserBehavior.driver = driverR;
        UserBehavior.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        UserBehavior.driver.manage().deleteAllCookies();
        UserBehavior.driver.get("https://mail.yandex.ru/?noretpath=1");*/
    }
    @Test
    public void test3(){
        UserClass userOne = new UserClass();
        UserBehavior.userLogin(userOne);

        MessageClass messFromOne = new MessageClass();
        UserBehavior.createNewEmail(messFromOne);
        UserBehavior.checkReceivedEmails(messFromOne);

        UserBehavior.deleteReceivedEmails();
    }
//    @After
//    public void tearDown(){
//        UserBehavior.driver.quit();
//    }
}
