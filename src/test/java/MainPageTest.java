import datasource.MessageClass;
import datasource.UserClass;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//@RunWith(ConcurrentTestRunner.class)
public class MainPageTest {
    private static final Logger logger =  Logger.getLogger(String.valueOf(MainPageTest.class));
    UserBehavior userBehavior;
    UserBehavior userBehavior1;

    @BeforeMethod
    public void setUp(){
        UserBehavior tmp;
        tmp = new UserBehavior((short) Thread.currentThread().getId());
        System.setProperty("webdriver.chrome.driver", "D:\\TMP\\tests\\drivers\\chromedriver.exe");

        tmp.driver = DriverManage.getInstance(tmp.threadId);

        tmp.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        tmp.driver.manage().deleteAllCookies();
        tmp.driver.get("https://mail.yandex.ru/?noretpath=1");
         if (userBehavior==null)
             userBehavior=tmp;
         else userBehavior1=tmp;

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
    public void test1(){
        UserClass userOne = new UserClass();
        userBehavior.userLogin(userOne);

        MessageClass messFromOne = new MessageClass("topicFrom0","locatortest1@yandex.by",  "sometext");
        userBehavior.createNewEmail(messFromOne);
        userBehavior.checkReceivedEmails(messFromOne);

        userBehavior.deleteReceivedEmails();
    }
    @Test
    public void test(){
        UserClass userOne1 = new UserClass("locatortest1@yandex.by", "testlocator");
        userBehavior1.userLogin(userOne1);

        MessageClass messFromOne = new MessageClass("topicFrom1", "locatortest@yandex.by", "sometext");
        userBehavior1.createNewEmail(messFromOne);
        userBehavior1.checkReceivedEmails(messFromOne);

        userBehavior1.deleteReceivedEmails();
    }
//    @After
//    public void tearDown(){
//        UserBehavior.driver.quit();
//    }
}
