package Pages;

import datasource.MessageClass;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MailPage extends BasePage{

    @FindBy(xpath = "//a[contains(@class, 'mail-ComposeButton')]")
    private WebElement writeEmailButton;

    @FindBy(xpath = "//span[text()='Кому']/parent::label/parent::div//div[@class='composeYabbles']")
    private WebElement addresseeInput;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement topicInput;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement messageInput;

    @FindBy(xpath = "//div[@class='ComposeSendButton-Text']/../..")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//a[@data-lego and @href='#inbox']")
    private WebElement popupButton;

    @FindBy(xpath = "//span[@data-click-action]")
    private WebElement checkNewEmailButton;

    @FindBy(xpath = "//input[@class='textinput__control']")
    private WebElement searchInput;

    @FindBy(xpath = "//form/button")
    private WebElement findButton;

    @FindBy(xpath = "//span[@title='topic' and text()='topic']")
    private WebElement topicSpan;

    @FindBy(xpath = "//a[contains(@href,'message')]")
    private WebElement listOfEmails;

    @FindBy(xpath = "//div[text()='sometext']")
    private WebElement textOfEmail;

    @FindBy(xpath = "//a[@href='#inbox']")
    private WebElement incomeMailsPageButton;

    @FindBy(xpath = "//a/div[contains(@class, 'user-pic')]")
    private WebElement userPicture;

    @FindBy(xpath = "//div[@class='legouser__menu-header']//span[@class='user-account__subname']")
    private WebElement checkSpanUser;

    public void prepareNewEmail(MessageClass message){
        addresseeInput.sendKeys(message.getAddressee());
        topicInput.sendKeys(message.getTopicOfMessage());
        messageInput.sendKeys(message.getMessage());
    }
}
