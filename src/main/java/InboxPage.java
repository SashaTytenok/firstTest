import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class InboxPage extends WaitClass{

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']")
    WebElement checkBoxIncomePageButton;

    @FindBy(xpath = "//div[contains(@class, 'delete')]")
    WebElement deleteEmailIncomePageButton;

    @FindBy(xpath = "//a[@href='#sent']")
    WebElement sentPageButton;

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
