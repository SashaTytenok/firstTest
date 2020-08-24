import com.gargoylesoftware.htmlunit.Page;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MailPage mailPage;
    private FirstPage firstPage;
    private InboxPage inboxPage;
    private SentPage sentPage;
    private TrashPage trashPage;

    @Before
    public void setUp(){

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

        System.setProperty("webdriver.chrome.driver", "D:\\TMP\\tests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://mail.yandex.ru/?noretpath=1");
        //loginPage = new LoginPage(driver);
    }

    @Test
    public void testPageFactory(){
        firstPage = PageFactory.initElements(driver, FirstPage.class);
        firstPage.waitAndClick();

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.waitAndTypeLogin("locatortest@yandex.by");
        loginPage.clickSubmitAndWait();
        loginPage.waitAndTypePassword("testlocator");
        loginPage.clickSubmitAndWait();

        mailPage = PageFactory.initElements(driver, MailPage.class);
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

        inboxPage = PageFactory.initElements(driver, InboxPage.class);
        inboxPage.checkBoxIncomePageButton.click();
        inboxPage.deleteEmailIncomePageButton.click();
        inboxPage.goToSentPage();

        sentPage = PageFactory.initElements(driver, SentPage.class);
        sentPage.checkBoxSentPageButton.click();
        sentPage.deleteEmailSentPageButton.click();
        sentPage.gotToDeletedPage();

        trashPage = PageFactory.initElements(driver, TrashPage.class);
        trashPage.selectFirstTwoElements();
        trashPage.deleteCheckedEmailsTrashPageButton.click();
    }

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
