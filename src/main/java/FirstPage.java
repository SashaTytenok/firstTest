import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class FirstPage{
    public FirstPage init(WebDriver driver){
        return PageFactory.initElements(driver, FirstPage.class);
    }

    @FindBy(xpath =  "//div[@class = 'HeadBanner-ButtonsWrapper']/a[2]")
    private WebElement signInButton;
}
