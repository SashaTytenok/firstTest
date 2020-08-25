import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class InboxPage extends WaitClass {

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }
    public static InboxPage init(WebDriver driver){
        new InboxPage(driver);
        return PageFactory.initElements(driver, InboxPage.class);
    }
    @FindBy(xpath = "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']")
    private WebElement checkBoxIncomePageButton;

    @FindBy(xpath = "//div[contains(@class, 'delete')]")
    private WebElement deleteEmailIncomePageButton;

    @FindBy(xpath = "//a[@href='#sent']")
    private WebElement sentPageButton;

    public void goToSentPage(){
        this.waitForAjaxToFinish();
        sentPageButton.click();
    }
/*
    noPageFactory
    private By checkBoxIncomePageButton = By.xpath("//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
    private By deleteEmailIncomePageButton = By.xpath("//div[contains(@class, 'delete')]");
    private By sentPageButton = By.xpath("//a[@href='#sent']");
    private By elementToBeDisappearInboxPage = By.xpath("//span[contains(@class, 'title-spam')]/..");
    */
}
