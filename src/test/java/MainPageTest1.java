import datasource.MessageClass;
import datasource.UserClass;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//@RunWith(ConcurrentTestRunner.class)
public class MainPageTest1 {
    //private static final Logger logger =  Logger.getLogger(String.valueOf(MainPageTest.class));
    UserBehavior userBehavior;

    @BeforeMethod
    public void setUp(){
        userBehavior = new UserBehavior((short) Thread.currentThread().getId());
        System.setProperty("webdriver.chrome.driver", "D:\\TMP\\tests\\drivers\\chromedriver.exe");

        userBehavior.driver = DriverManage.getInstance(userBehavior.threadId);

        userBehavior.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        userBehavior.driver.manage().deleteAllCookies();
        userBehavior.driver.get("https://mail.yandex.ru/?noretpath=1");
        //logger.info(String.valueOf(Thread.currentThread().getId()));
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

        MessageClass messFromOne = new MessageClass();
        userBehavior.createNewEmail(messFromOne);
        userBehavior.checkReceivedEmails(messFromOne);

        userBehavior.deleteReceivedEmails();
    }
    @Test
    public void test(){
        UserClass userOne = new UserClass();
        userBehavior.userLogin(userOne);

        MessageClass messFromOne = new MessageClass();
        userBehavior.createNewEmail(messFromOne);
        userBehavior.checkReceivedEmails(messFromOne);

        userBehavior.deleteReceivedEmails();
    }
//    @After
//    public void tearDown(){
//        UserBehavior.driver.quit();
//    }
}
