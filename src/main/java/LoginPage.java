import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage extends WaitClass {

    public static LoginPage init(WebDriver driver){
        return PageFactory.initElements(driver, LoginPage.class);
    }

    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void waitAndTypeLogin(String login){
        this.waitForAjaxToFinish();
        loginInput.sendKeys(login);
    }
    public void waitAndTypePassword(String password){
        this.waitForAjaxToFinish();
        passwordInput.sendKeys(password);
    }
    public void clickSubmitAndWait(){
        submitButton.click();
        this.waitForAjaxToFinish();
    }
}
