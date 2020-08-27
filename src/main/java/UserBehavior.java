import datasource.MessageClass;
import datasource.UserClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import services.MultitonType;

import java.util.concurrent.TimeUnit;

public class UserBehavior extends WaitClass {
    public UserBehavior(){
        //this.driver = DriverManage.getInstance(type);
    }
    //protected  WebDriver driver;
    private static LoginPage loginPage;
    private static MailPage mailPage;
    private static FirstPage firstPage;
    private static InboxPage inboxPage;
    private static SentPage sentPage;
    private static TrashPage trashPage;
    public static MultitonType tmp;

    public static void userLogin(UserClass user){
        firstPage = FirstPage.init(DriverManage.getInstance(tmp));
        firstPage.signInButton.click();
        loginPage = LoginPage.init(DriverManage.getInstance(tmp));
        loginPage.waitForAjaxToFinish();
        loginPage.getLoginInput().sendKeys(user.getUserLogin());
        loginPage.getSubmitButton().click();
        loginPage.waitForAjaxToFinish();
        loginPage.getPasswordInput().sendKeys(user.getUserPassword());
        loginPage.waitForAjaxToFinish();
        loginPage.getSubmitButton().click();
    }
    public static void createNewEmail(MessageClass message){
        mailPage = MailPage.init(DriverManage.getInstance(tmp));
        mailPage.waitForAjaxToFinish();
        mailPage.getWriteEmailButton().click();
        mailPage.prepareNewEmail(message);
        mailPage.getSendEmailButton().click();
        mailPage.waitForAjaxToFinish();
        mailPage.getPopupButton().click();
        mailPage.waitForAjaxToFinish();
    }
    public static void checkReceivedEmails(MessageClass message){
        mailPage.getCheckNewEmailButton().click();
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
        inboxPage = InboxPage.init(DriverManage.getInstance(tmp));

        inboxPage.getCheckBoxIncomePageButton().click();
        inboxPage.getDeleteEmailIncomePageButton().click();
        inboxPage.goToSentPage();

        sentPage = SentPage.init(DriverManage.getInstance(tmp));
        sentPage.getCheckBoxSentPageButton().click();
        sentPage.getDeleteEmailSentPageButton().click();
        sentPage.gotToDeletedPage();

        trashPage = TrashPage.init(DriverManage.getInstance(tmp));
        trashPage.selectFirstTwoElements();
        trashPage.getDeleteCheckedEmailsTrashPageButton().click();
    }
}
