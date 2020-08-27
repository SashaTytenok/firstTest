import datasource.MessageClass;
import datasource.UserClass;

public class UserBehavior extends WaitClass{

    private LoginPage loginPage;
    private MailPage mailPage;
    private FirstPage firstPage;
    private InboxPage inboxPage;
    private SentPage sentPage;
    private TrashPage trashPage;

    public UserBehavior(Short threadId) {
        super(threadId);
    }

    public void userLogin(UserClass user){
        firstPage = new FirstPage().init(DriverManage.getInstance(threadId));
        firstPage.getSignInButton().click();
        loginPage = new LoginPage().init(DriverManage.getInstance(threadId));
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
        loginPage.getLoginInput().sendKeys(user.getUserLogin());
        loginPage.getSubmitButton().click();
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
        loginPage.getPasswordInput().sendKeys(user.getUserPassword());
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
        loginPage.getSubmitButton().click();
    }
    public void createNewEmail(MessageClass message){
        mailPage = new MailPage().init(DriverManage.getInstance(threadId));
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
        mailPage.getWriteEmailButton().click();
        mailPage.prepareNewEmail(message);
        mailPage.getSendEmailButton().click();
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
        mailPage.getPopupButton().click();
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
    }
    public void checkReceivedEmails(MessageClass message){
        mailPage.getCheckNewEmailButton().click();
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
        mailPage.getSearchInput().sendKeys(message.getTopicOfMessage());
        mailPage.getFindButton().click();
        waitForAjaxToFinish(DriverManage.getInstance(threadId));


        //Assert.assertTrue(mailPage.getTopicSpan().isDisplayed());
        //из списка получаем наше письмо чтобы сравнить текст сообщения
        mailPage.getListOfEmails().click();
        //Assert.assertEquals(message.getMessage(), mailPage.getTextOfEmail().getText());
    }
    public void deleteReceivedEmails(){
        mailPage.getIncomeMailsPageButton().click();
        inboxPage = new InboxPage().init(DriverManage.getInstance(threadId));

        inboxPage.getCheckBoxIncomePageButton().click();
        inboxPage.getDeleteEmailIncomePageButton().click();
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
        inboxPage.getSentPageButton().click();

        sentPage = new SentPage().init(DriverManage.getInstance(threadId));
        sentPage.getCheckBoxSentPageButton().click();
        sentPage.getDeleteEmailSentPageButton().click();
        sentPage.getDeletedPageButton().click();
        waitForAjaxToFinish(DriverManage.getInstance(threadId));

        trashPage = new TrashPage().init(DriverManage.getInstance(threadId));
        trashPage.selectFirstTwoElements();
        waitForAjaxToFinish(DriverManage.getInstance(threadId));
        trashPage.getDeleteCheckedEmailsTrashPageButton().click();
    }
}
