import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class SentPage extends WaitClass {

    public SentPage(WebDriver driver) {
        this.driver = driver;
    }
    private By checkBoxSentPageButton = By.xpath("//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
    private By deleteEmailSentPageButton = By.xpath("//div[contains(@class, 'delete')]");
    private By deletedPageButton = By.xpath("//a[@href='#trash']");
}
