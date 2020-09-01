import Pages.*;
import datasource.MessageClass;
import datasource.UserClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import services.FileManager;
import services.MyWebDriver;
import services.PageManager;
import services.WaitClass;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        MailPage mailPage = PageManager.getPage(MyWebDriver.getInstance(), MailPage.class);
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
/*        mailPage.getUserPicture().click();
        //проверка того, что я попал на нужную страницу
        Assert.assertEquals(mailPage.getCheckSpanUser().getText(), user.getUserLogin());
        //remove my visible container
        ((JavascriptExecutor) MyWebDriver.getInstance())
                .executeScript("window.scrollBy(0,200);");
        ((JavascriptExecutor) MyWebDriver.getInstance())
                .executeScript("window.scrollBy(0,-200);");*/
    }

    public void createNewEmail(MessageClass message) {
        MailPage mailPage = PageManager.getPage(MyWebDriver.getInstance(), MailPage.class);

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

    public void checkReceivedEmails(MessageClass message) {
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

    public void deleteReceivedEmails() {
        InboxPage inboxPage = PageManager.getPage(MyWebDriver.getInstance(), InboxPage.class);
        inboxPage.getIncomeMailsPageButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        inboxPage.getCheckBoxIncomePageButton().click();
        inboxPage.getDeleteEmailIncomePageButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        inboxPage.getSentPageButton().click();

        SentPage sentPage = PageManager.getPage(MyWebDriver.getInstance(), SentPage.class);
        sentPage.getCheckBoxSentPageButton().click();
        sentPage.getDeleteEmailSentPageButton().click();
        sentPage.getDeletedPageButton().click();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());

        TrashPage trashPage = PageManager.getPage(MyWebDriver.getInstance(), TrashPage.class);
        trashPage.selectFirstTwoElements();
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        trashPage.getDeleteCheckedEmailsTrashPageButton().click();
    }

    public void goToStoragePage(){
        //go to StoragePage
        MailPage mailPage = PageManager.getPage(MyWebDriver.getInstance(), MailPage.class);
        mailPage.getShowAllServices().click();
        WaitClass.waitUntilElementIsDisplayed(mailPage.getStoragePageButton(), MyWebDriver.getInstance());
        mailPage.getStoragePageButton().click();
        StoragePage storagePage = PageManager.getPage(MyWebDriver.getInstance(), StoragePage.class);
        ArrayList<String> windowHandles = new ArrayList<>(MyWebDriver.getInstance().getWindowHandles());
        MyWebDriver.getInstance().switchTo().window(windowHandles.get(1));
        WaitClass.waitForAjaxToFinish(MyWebDriver.getInstance());
        //check if there is a useless Popup
        //спросить как проверять не укладывая весь тест
/*        if(storagePage.getCloseUselessPopUp().isDisplayed()){
            storagePage.getCloseUselessPopUp().click();
        }*/
        Assert.assertTrue(storagePage.getUploadButton().isDisplayed());
    }
    public ArrayList<File> prepareAndSendFiles() throws IOException{
        StoragePage storagePage = PageManager.getPage(MyWebDriver.getInstance(), StoragePage.class);
        //prepare files for sending
        ArrayList<String> filesFromCreate=new ArrayList<>();
        ArrayList<File> createdFiles=new ArrayList<>();
        String forSendKeys="";
        for (File f : FileManager.createAndWrite(3)){
            filesFromCreate.add(f.getName());
            createdFiles.add(f);
            forSendKeys+=f.getPath()+"\n";
        }
        forSendKeys=forSendKeys.substring(0, forSendKeys.length()-1);
        //sending files to storage
        storagePage.getInputForFile().sendKeys(forSendKeys);
        WaitClass.waitUntilElementIsDisplayed(storagePage.getIsFilesUpload(), MyWebDriver.getInstance());
        storagePage.getCloseUploadContainer().click();
        //check if these files are the same
        List<String> webFilesFromPage=new ArrayList<>();
        for (WebElement webElement :storagePage.getListOfUploadedFiles()){
            webFilesFromPage.add(webElement.getText());
        }
        Assert.assertTrue(webFilesFromPage.containsAll(filesFromCreate));
        return createdFiles;
    }
    public void selectAndDelete(ArrayList<File> fileToDelete){
        StoragePage storagePage = PageManager.getPage(MyWebDriver.getInstance(), StoragePage.class);
        Actions actions = new Actions(MyWebDriver.getInstance());
        ArrayList<WebElement> temp;
        temp = storagePage.getNeededElements(storagePage.getListOfUploadedFiles(), fileToDelete);
        actions.keyDown(Keys.CONTROL).build().perform();
        for (WebElement tmp: temp) {
            tmp.click();
        }
        actions.keyUp(Keys.CONTROL).build().perform();
        actions.clickAndHold(temp.get(0)).moveToElement(storagePage.getTrashIcon()).release().perform();
        WaitClass.waitUntilElementIsDisplayed(storagePage.getHaveDeletedContainer(), MyWebDriver.getInstance());
        actions.doubleClick(storagePage.getTrashIcon()).perform();
        //go into Trash and select file to delete
        storagePage.getCleanTrash().click();
        WaitClass.waitUntilToBeClickable(storagePage.getCompletelyDeleteButton(), MyWebDriver.getInstance());
        //WaitClass.waitUntilElementIsDisplayed(storagePage.getCompletelyDeleteButton(), MyWebDriver.getInstance());
        storagePage.getCompletelyDeleteButton().click();
        Assert.assertTrue(storagePage.getSuccess().isDisplayed());
    }
}

