package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TrashPage extends MailPage{

    //private ArrayList<WebElement> lst = new ArrayList<>();
    @FindBy(xpath = "//label[@class]/span[contains(@class, 'flag')]")
    private List<WebElement> listOfEmailsToBeDeleted;

    @FindBy(xpath = "//div[contains(@class, 'delete')]")
    private WebElement deleteCheckedEmailsTrashPageButton;
    public void selectFirstTwoElements() {
        listOfEmailsToBeDeleted.get(0).click();
        listOfEmailsToBeDeleted.get(1).click();
    }
}
