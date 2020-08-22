import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class InboxPage extends WaitClass{

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }
    private By checkBoxIncomePageButton = By.xpath("//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
    private By deleteEmailIncomePageButton = By.xpath("//div[contains(@class, 'delete')]");
    private By sentPageButton = By.xpath("//a[@href='#sent']");
    private By elementToBeDisappearInboxPage = By.xpath("//span[contains(@class, 'title-spam')]/..");
}
