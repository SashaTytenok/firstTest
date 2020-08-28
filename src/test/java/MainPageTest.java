import datasource.MessageClass;
import datasource.UserClass;
import org.testng.annotations.*;
import services.MyWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MainPageTest {
    private static final Logger logger =  Logger.getLogger(String.valueOf(MainPageTest.class));
    UserBehavior userBehavior = new UserBehavior();
    MessageClass messFromTwo;
    MessageClass messFromOne;
    UserClass userOne;
    UserClass userTwo;

    @BeforeTest
    public void setUpTest(){
        messFromOne = new MessageClass("topicFrom0","locatortest1@yandex.ru",  "sometext");
        messFromTwo = new MessageClass("topicFrom1","locatortest@yandex.by",  "sometext1");
        userOne = new UserClass();
        userTwo = new UserClass("locatortest1@yandex.ru", "testlocator");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println(Thread.currentThread().getId());
        System.setProperty("webdriver.chrome.driver", "D:\\TMP\\tests\\drivers\\chromedriver.exe");

        MyWebDriver.getInstance().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        MyWebDriver.getInstance().manage().deleteAllCookies();
        MyWebDriver.getInstance().get("https://mail.yandex.ru/?noretpath=1");
        //UserBehavior.driver.manage().window().maximize();


//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("83.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);
//
//        RemoteWebDriver driverR = new RemoteWebDriver(
//                URI.create("http://localhost:4444/wd/hub").toURL(),
//                capabilities
//        );
//        UserBehavior.driver = driverR;
//        UserBehavior.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//        UserBehavior.driver.manage().deleteAllCookies();
//        UserBehavior.driver.get("https://mail.yandex.ru/?noretpath=1");
    }
    @Test
    public void test1(){
        userBehavior.userLogin(userOne);
//        userBehavior.createNewEmail(messFromOne);
//        userBehavior.checkReceivedEmails(messFromTwo);
//        userBehavior.deleteReceivedEmails();
    }
    @Test
    public void test(){
        userBehavior.userLogin(userTwo);
//        userBehavior.createNewEmail(messFromTwo);
//        userBehavior.checkReceivedEmails(messFromOne);
//        userBehavior.deleteReceivedEmails();
    }
//    @After
//    public void tearDown(){
//        UserBehavior.driver.quit();
//    }
}
