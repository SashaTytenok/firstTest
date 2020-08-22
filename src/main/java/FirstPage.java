import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class FirstPage extends WaitClass {

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[@data-reactid=24]");
}
