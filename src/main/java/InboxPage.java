import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class InboxPage{

    public InboxPage init(WebDriver driver){
        return PageFactory.initElements(driver, InboxPage.class);
    }
    @FindBy(xpath = "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']")
    private WebElement checkBoxIncomePageButton;

    @FindBy(xpath = "//div[contains(@class, 'delete')]")
    private WebElement deleteEmailIncomePageButton;

    @FindBy(xpath = "//a[@href='#sent']")
    private WebElement sentPageButton;
}
