import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class FirstPage extends WaitClass {

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }
    public static FirstPage init(WebDriver driver){
        new FirstPage(driver);
        return PageFactory.initElements(driver, FirstPage.class);
    }

    @FindBy(xpath =  "//div[@class = 'HeadBanner-ButtonsWrapper']/a[2]")
    WebElement signInButton;
/*    noPageFactory
    private By signInButton = By.xpath("//a[@data-reactid=24]");
*/
}
