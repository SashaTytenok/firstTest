import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

@Getter
public class TrashPage extends WaitClass{
    private ArrayList<WebElement> lst = new ArrayList<>();
    public TrashPage(WebDriver driver) {
        this.driver = driver;
    }

    private By listOfEmailsToBeDeleted = By.xpath("//label[@class]/span[contains(@class, 'flag')]");
    private By deleteCheckedEmailsTrashPageButton = By.xpath("//div[contains(@class, 'delete')]");

    public void selectFirstTwoElements(){
        lst.addAll(this.driver.findElements(listOfEmailsToBeDeleted));
        lst.get(0).click();
        lst.get(1).click();
        this.waitForAjaxToFinish();
    }
}
