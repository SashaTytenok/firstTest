import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class FirstPage extends WaitClass {

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath =  "//a[@data-reactid=24]")
    WebElement signInButton;

    public void waitAndClick(){
        this.signInButton.click();
    }
/*    noPageFactory
    private By signInButton = By.xpath("//a[@data-reactid=24]");
*/
}
