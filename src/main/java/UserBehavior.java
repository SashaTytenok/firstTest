import Pages.*;
import datasource.MessageClass;
import datasource.UserClass;
import org.testng.Assert;
import services.MyWebDriver;
import services.PageManager;
import services.WaitClass;

public class UserBehavior {

    public void userLogin(UserClass user) {
        FirstPage firstPage = PageManager.getPage(MyWebDriver.getInstance(), FirstPage.class);

        firstPage.getSignInButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());

        LoginPage loginPage = PageManager.getPage(MyWebDriver.getInstance(), LoginPage.class);

        loginPage.getLoginInput().sendKeys(user.getUserLogin());
        loginPage.getSubmitButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        loginPage.getPasswordInput().sendKeys(user.getUserPassword());
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        loginPage.getSubmitButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        MailPage mailPage = PageManager.getPage(MyWebDriver.getInstance(), MailPage.class);
        mailPage.getUserPicture().click();
        //проверка того, что я попал на нужную страницу
        Assert.assertEquals(mailPage.getCheckSpanUser().getText(), user.getUserLogin());
    }

    public void createNewEmail(MessageClass message){
        MailPage mailPage = PageManager.getPage(MyWebDriver.getInstance(),MailPage.class);

        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        mailPage.getWriteEmailButton().click();
        mailPage.prepareNewEmail(message);
        mailPage.getSendEmailButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        mailPage.getPopupButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
    }
    /*
    public void createNewEmail(long threadId, MessageClass message){
        MailPage mailPage = PageManager.getPage(DriverManage.getInstance(threadId),MailPage.class);

        WaitClass.waitForAjaxToFinish(DriverManage.getInstance(threadId));
        mailPage.getWriteEmailButton().click();
        mailPage.prepareNewEmail(message);
        mailPage.getSendEmailButton().click();
        WaitClass.waitForAjaxToFinish(DriverManage.getInstance(threadId));
        mailPage.getPopupButton().click();
        WaitClass.waitForAjaxToFinish(DriverManage.getInstance(threadId));
    }*/

    public void checkReceivedEmails(MessageClass message){
        MailPage mailPage = PageManager.getPage(MyWebDriver.getInstance(), MailPage.class);

        mailPage.getCheckNewEmailButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        mailPage.getSearchInput().sendKeys(message.getTopicOfMessage());
        mailPage.getFindButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());

        Assert.assertTrue(mailPage.getTopicSpan().isDisplayed());
        //из списка получаем наше письмо чтобы сравнить текст сообщения
        mailPage.getListOfEmails().click();
        Assert.assertEquals(message.getMessage(), mailPage.getTextOfEmail().getText());
    }

    public void deleteReceivedEmails(){
        InboxPage inboxPage = PageManager.getPage(MyWebDriver.getInstance(),InboxPage.class);
        inboxPage.getIncomeMailsPageButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        inboxPage.getCheckBoxIncomePageButton().click();
        inboxPage.getDeleteEmailIncomePageButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        inboxPage.getSentPageButton().click();

        SentPage sentPage =PageManager.getPage(MyWebDriver.getInstance(), SentPage.class);
        sentPage.getCheckBoxSentPageButton().click();
        sentPage.getDeleteEmailSentPageButton().click();
        sentPage.getDeletedPageButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());

        TrashPage trashPage = PageManager.getPage(MyWebDriver.getInstance(), TrashPage.class);
        trashPage.selectFirstTwoElements();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        trashPage.getDeleteCheckedEmailsTrashPageButton().click();
    }
}
