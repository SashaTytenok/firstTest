import lombok.Getter;
import org.openqa.selenium.*;

@Getter
public class LoginPage extends WaitClass {

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private By loginInput = By.xpath("//input[@id='passp-field-login']");
    private By passwordInput = By.xpath("//input[@id='passp-field-passwd']");
    private By submitButton = By.xpath("//button[@type='submit']");

    public LoginPage writeLoginInput(String login){
        this.driver.findElement(loginInput).sendKeys(login);
        return this;
    }

    public LoginPage writePasswordInput(String password){
        this.driver.findElement(passwordInput).sendKeys(password);
        return this;
    }
}
