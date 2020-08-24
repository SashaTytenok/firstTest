import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SentPage extends WaitClass {

    public SentPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']")
    WebElement checkBoxSentPageButton;

    @FindBy(xpath = "//div[contains(@class, 'delete')]")
    WebElement deleteEmailSentPageButton;

    @FindBy(xpath = "//a[@href='#trash']")
    WebElement deletedPageButton;

    public void gotToDeletedPage(){
        deletedPageButton.click();
        this.waitForAjaxToFinish();
    }
/*
    noPageFactory
    private By checkBoxSentPageButton = By.xpath("//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
    private By deleteEmailSentPageButton = By.xpath("//div[contains(@class, 'delete')]");
    private By deletedPageButton = By.xpath("//a[@href='#trash']");
    */
}
