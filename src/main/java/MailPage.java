import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MailPage extends WaitClass{

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//a[contains(@class, 'mail-ComposeButton')]")
    WebElement writeEmailButton;

    @FindBy(xpath = "//span[text()='Кому']/parent::label/parent::div//div[@class='composeYabbles']")
    WebElement addresseeInput;

    @FindBy(xpath = "//input[@name='subject']")
    WebElement topicInput;

    @FindBy(xpath = "//div[@role='textbox']")
    WebElement messageInput;

    @FindBy(xpath = "//div[@class='ComposeSendButton-Text']/../..")
    WebElement sendEmailButton;

    @FindBy(xpath = "//a[@data-lego and @href='#inbox']")
    WebElement popupButton;

    @FindBy(xpath = "//span[@data-click-action]")
    WebElement checkNewEmailButton;

    @FindBy(xpath = "//input[@class='textinput__control']")
    WebElement searchInput;

    @FindBy(xpath = "//form/button")
    WebElement findButton;

    @FindBy(xpath = "//span[@title='topic' and text()='topic']")
    WebElement topicSpan;

    @FindBy(xpath = "//a[contains(@href,'message')]")
    WebElement listOfEmails;

    @FindBy(xpath = "//div[text()='sometext']")
    WebElement textOfEmail;

    @FindBy(xpath = "//a[@href='#inbox']")
    WebElement incomeMailsPageButton;

    public void clickWriteNewEmailButtonAndWait(){
        writeEmailButton.click();
        this.waitForAjaxToFinish();
    }
    public void prepareNewEmail(String addressee, String topic, String message){
        addresseeInput.sendKeys(addressee);
        topicInput.sendKeys(topic);
        messageInput.sendKeys(message);
    }
    public void clickSendNewEmailAndWait(){
        sendEmailButton.click();
        this.waitForAjaxToFinish();
    }
    public void clickCheckNewEmailsButtonAndWait(){
        checkNewEmailButton.click();
        this.waitForAjaxToFinish();
    }

    public void searchOurMessageAndWait(String topicOfMessage){
        searchInput.click();
        this.waitForAjaxToFinish();
        searchInput.sendKeys(topicOfMessage);
    }
    public void clickFindButtonAndWait(){
        findButton.click();
        this.waitForAjaxToFinish();
    }
    public void goToSentMailAndWait(){
        incomeMailsPageButton.click();
        this.waitForAjaxToFinish();
    }

/*
    noPageFactory
    private By writeEmailButton = By.xpath("//a[contains(@class, 'mail-ComposeButton')]");
    private By addresseeInput = By.xpath("//span[text()='Кому']/parent::label/parent::div//div[@class='composeYabbles']");
    private By topicInput = By.xpath("//input[@name='subject']");
    private By messageInput = By.xpath("//div[@role='textbox']");
    private By sendEmailButton = By.xpath("//div[@class='ComposeSendButton-Text']/../..");
    private By popupButton = By.xpath("//a[@data-lego and @href='#inbox']");
    private By checkNewEmailButton = By.xpath("//span[@data-click-action]");
    private By searchInput = By.xpath("//input[@class='textinput__control']");
    private By findButton = By.xpath("//form/button");
    private By topicSpan = By.xpath("//span[@title='topic' and text()='topic']");
    private By listOfEmails = By.xpath("//a[contains(@href,'message')]");
    private By textOfEmail = By.xpath("//div[text()='sometext']");
    private By incomeMailsPageButton = By.xpath("//a[@href='#inbox']");

    public MailPage searchTopic(String topic){
        this.waitForAjaxToFinish();
        this.driver.findElement(searchInput).sendKeys(topic);
        return this;
    }
    public MailPage prepareEmail(String addressee, String topic, String text) {
        this.driver.findElement(addresseeInput).sendKeys(addressee);
        this.driver.findElement(topicInput).sendKeys(topic);
        this.driver.findElement(messageInput).sendKeys(text);
        return this;
    }
    public String checkMail(){
        return this.driver.findElement(textOfEmail).getText();
    }
    public boolean checkMailsOnTopic() {
        return this.driver.findElement(topicSpan).isDisplayed();
    }
    */
}
