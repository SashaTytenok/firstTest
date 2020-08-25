import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SentPage extends WaitClass {

    public SentPage(WebDriver driver) {
        this.driver = driver;
    }
    public static SentPage init(WebDriver driver){
        new SentPage(driver);
        return PageFactory.initElements(driver, SentPage.class);
    }
    @FindBy(xpath = "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']")
    private WebElement checkBoxSentPageButton;

    @FindBy(xpath = "//div[contains(@class, 'delete')]")
    private WebElement deleteEmailSentPageButton;

    @FindBy(xpath = "//a[@href='#trash']")
    private WebElement deletedPageButton;

    public void gotToDeletedPage(){
        deletedPageButton.click();
        this.waitForAjaxToFinish();
    }
/*
    noPageFactory
    private By checkBoxSentPageButton = By.xpath("//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
    private By deleteEmailSentPageButton = By.xpath("//div[contains(@class, 'delete')]");
    private By deletedPageButton = By.xpath("//a[@href='#trash']");
    */
}
