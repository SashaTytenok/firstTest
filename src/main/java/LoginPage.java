import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends WaitClass {

    public LoginPage(WebDriver driver){
        this.driver=driver;
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

/*  noPageFactory
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
*/
}
