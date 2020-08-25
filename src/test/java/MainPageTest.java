import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.gargoylesoftware.htmlunit.Page;
import datasource.MessageClass;
import datasource.UserClass;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.jws.soap.SOAPBinding;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

@RunWith(ConcurrentTestRunner.class)
public class MainPageTest {


    @Before
    public void setUp() throws MalformedURLException {

/*        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings.popups", 0);
        options.addArguments("disable-extensions");
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("chrome.switches","--disable-extensions");
        options.addArguments("--test-type");
        options.addArguments("disable-infobars");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        System.setProperty("webdriver.chrome.driver", "D:\\TMP\\tests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(cap);*/

/*        System.setProperty("webdriver.chrome.driver", "D:\\TMP\\tests\\drivers\\chromedriver.exe");
        UserBehavior.driver = new ChromeDriver();
        //UserBehavior.driver.manage().window().maximize();
        UserBehavior.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        UserBehavior.driver.manage().deleteAllCookies();
        UserBehavior.driver.get("https://mail.yandex.ru/?noretpath=1");*/

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
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
        UserBehavior.driver.get("https://mail.yandex.ru/?noretpath=1");
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


/*  noUserBehaviorClass
    @Test
    public void testPageFactory(){
        firstPage = FirstPage.init(driver);
        firstPage.waitAndClick();

        loginPage = LoginPage.init(driver);
        loginPage.waitAndTypeLogin("locatortest@yandex.by");
        loginPage.clickSubmitAndWait();
        loginPage.waitAndTypePassword("testlocator");
        loginPage.clickSubmitAndWait();

        mailPage = MailPage.init(driver);
        mailPage.clickWriteNewEmailButtonAndWait();
        mailPage.prepareNewEmail("locatortest@yandex.by", "topic", "sometext");
        mailPage.clickSendNewEmailAndWait();
        mailPage.popupButton.click();
        mailPage.clickCheckNewEmailsButtonAndWait();
        mailPage.searchOurMessageAndWait("topic");
        mailPage.clickFindButtonAndWait();
        Assert.assertTrue(mailPage.topicSpan.isDisplayed());
        //из списка получаем наше письмо чтобы сравнить текст сообщения
        mailPage.listOfEmails.click();
        Assert.assertEquals("sometext", mailPage.textOfEmail.getText());
        //идем во воходящие
        mailPage.goToSentMailAndWait();

        inboxPage = InboxPage.init(driver);
        inboxPage.checkBoxIncomePageButton.click();
        inboxPage.deleteEmailIncomePageButton.click();
        inboxPage.goToSentPage();

        sentPage = SentPage.init(driver);
        sentPage.checkBoxSentPageButton.click();
        sentPage.deleteEmailSentPageButton.click();
        sentPage.gotToDeletedPage();

        trashPage = TrashPage.init(driver);
        trashPage.selectFirstTwoElements();
        trashPage.deleteCheckedEmailsTrashPageButton.click();
    }*/

    /*@Test
    public void testDeleting(){

        //страница входа
        firstPage = new FirstPage(driver);
        firstPage.waitPresentAndClick(firstPage.getSignInButton());

        //Страница Логина, логинимся
        loginPage = new LoginPage(driver);
        loginPage.waitAndType(loginPage);
        loginPage.writeLoginInput("locatortest");
        loginPage.waitPresentAndClick(loginPage.getSubmitButton());
        loginPage.writePasswordInput("testlocator");
        loginPage.waitPresentAndClick(loginPage.getSubmitButton());

        //Основная страница почтового ящика
        //отправляем письмо
        mailPage = new MailPage(driver);
        mailPage.waitPresentAndClick(mailPage.getWriteEmailButton());
        mailPage.prepareEmail("locatortest@yandex.by", "topic", "sometext");
        mailPage.waitPresentAndClick(mailPage.getSendEmailButton());
        mailPage.waitPresentAndClick(mailPage.getPopupButton());
        mailPage.waitVisibleAndClick(mailPage.getCheckNewEmailButton());
        //чекаем это письмо
        mailPage.searchTopic("topic");
        mailPage.waitVisibleAndClick(mailPage.getFindButton());
        //проверяем совпадает ли с тема сообщения с нашим
        Assert.assertTrue(mailPage.checkMailsOnTopic());
        //проходим в наше сообщение и проверяем тескт
        mailPage.waitPresentAndClick(mailPage.getListOfEmails());
        Assert.assertEquals("sometext", mailPage.checkMail());

        //идем во входящие
        mailPage.waitPresentAndClick(mailPage.getIncomeMailsPageButton());
        inboxPage = new InboxPage(driver);
        inboxPage.waitPresentAndClick(inboxPage.getCheckBoxIncomePageButton());
        inboxPage.waitClickableAndClick(inboxPage.getDeleteEmailIncomePageButton());
        inboxPage.waitPresentAndClick(inboxPage.getSentPageButton());

        //идем в исходящие
        sentPage = new SentPage(driver);
        sentPage.waitPresentAndClick(sentPage.getCheckBoxSentPageButton());
        sentPage.waitClickableAndClick(sentPage.getDeleteEmailSentPageButton());
        sentPage.waitPresentAndClick(sentPage.getDeletedPageButton());

        //идем в удаленное
        trashPage = new TrashPage(driver);
        trashPage.selectFirstTwoElements();
        trashPage.waitClickableAndClick(trashPage.getDeleteCheckedEmailsTrashPageButton());
    }*/
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}
