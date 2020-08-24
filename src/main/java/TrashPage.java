import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class TrashPage extends WaitClass{
    private ArrayList<WebElement> lst = new ArrayList<>();
    public TrashPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//label[@class]/span[contains(@class, 'flag')]")
    List<WebElement> listOfEmailsToBeDeleted;

    @FindBy(xpath = "//div[contains(@class, 'delete')]")
    WebElement deleteCheckedEmailsTrashPageButton;
    public void selectFirstTwoElements() {
        listOfEmailsToBeDeleted.get(0).click();
        listOfEmailsToBeDeleted.get(1).click();
//        lst.addAll(listOfEmailsToBeDeleted);
//        lst.get(0).click();
//        lst.get(1).click();
        this.waitForAjaxToFinish();
    }
/*
    noPageFactory
    private By listOfEmailsToBeDeleted = By.xpath("//label[@class]/span[contains(@class, 'flag')]");
    private By deleteCheckedEmailsTrashPageButton = By.xpath("//div[contains(@class, 'delete')]");

    public void selectFirstTwoElements(){
        lst.addAll(this.driver.findElements(listOfEmailsToBeDeleted));
        lst.get(0).click();
        lst.get(1).click();
        this.waitForAjaxToFinish();
    }
 */
}
