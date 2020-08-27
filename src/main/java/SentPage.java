import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SentPage{

    public SentPage init(WebDriver driver){
        return PageFactory.initElements(driver, SentPage.class);
    }
    @FindBy(xpath = "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']")
    private WebElement checkBoxSentPageButton;

    @FindBy(xpath = "//div[contains(@class, 'delete')]")
    private WebElement deleteEmailSentPageButton;

    @FindBy(xpath = "//a[@href='#trash']")
    private WebElement deletedPageButton;
}
