import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class MailPage extends WaitClass{

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

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
}
