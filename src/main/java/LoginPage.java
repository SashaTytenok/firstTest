import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage{
    public LoginPage init(WebDriver driver){
        return PageFactory.initElements(driver, LoginPage.class);
    }

    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
}
