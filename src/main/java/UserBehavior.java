import datasource.MessageClass;
import datasource.UserClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class UserBehavior extends WaitClass {
    public UserBehavior(WebDriver driver){
        this.driver =  driver;
    }
    protected static WebDriver driver;
    private static LoginPage loginPage;
    private static MailPage mailPage;
    private static FirstPage firstPage;
    private static InboxPage inboxPage;
    private static SentPage sentPage;
    private static TrashPage trashPage;

    public static void userLogin(UserClass user){
        firstPage = FirstPage.init(driver);
        firstPage.signInButton.click();
        loginPage = LoginPage.init(driver);
        loginPage.waitForAjaxToFinish();
        loginPage.getLoginInput().sendKeys(user.getUserLogin());
        loginPage.getSubmitButton().click();
        loginPage.waitForAjaxToFinish();
        loginPage.getPasswordInput().sendKeys(user.getUserPassword());
        loginPage.waitForAjaxToFinish();
        loginPage.getSubmitButton().click();
    }
    public static void createNewEmail(MessageClass message){
        mailPage = MailPage.init(driver);
        mailPage.waitForAjaxToFinish();
        mailPage.getWriteEmailButton().click();
        mailPage.prepareNewEmail(message);
        mailPage.getSendEmailButton().click();
        mailPage.waitForAjaxToFinish();
        mailPage.getPopupButton().click();
        mailPage.waitForAjaxToFinish();
    }
    public static void checkReceivedEmails(MessageClass message){
        mailPage.getCheckNewEmailButton();
        mailPage.waitForAjaxToFinish();
        mailPage.getSearchInput().sendKeys(message.getTopicOfMessage());
        mailPage.getFindButton().click();
        mailPage.waitForAjaxToFinish();
        Assert.assertTrue(mailPage.getTopicSpan().isDisplayed());
        //из списка получаем наше письмо чтобы сравнить текст сообщения
        mailPage.getListOfEmails().click();
        Assert.assertEquals(message.getMessage(), mailPage.getTextOfEmail().getText());
    }
    public static void deleteReceivedEmails(){
        mailPage.getIncomeMailsPageButton().click();
        inboxPage = InboxPage.init(driver);

        inboxPage.getCheckBoxIncomePageButton().click();
        inboxPage.getDeleteEmailIncomePageButton().click();
        inboxPage.goToSentPage();

        sentPage = SentPage.init(driver);
        sentPage.getCheckBoxSentPageButton().click();
        sentPage.getDeleteEmailSentPageButton().click();
        sentPage.gotToDeletedPage();

        trashPage = TrashPage.init(driver);
        trashPage.selectFirstTwoElements();
        trashPage.getDeleteCheckedEmailsTrashPageButton().click();
    }
}
