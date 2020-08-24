import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public void waitForAjaxToFinish() {
        Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return (typeof(jQuery) != 'undefined')");
        //System.out.println(isJqueryUsed);
        if(isJqueryUsed){
            wait = new WebDriverWait(this.driver, 4);
            wait.until((ExpectedCondition<Boolean>) driver ->
                    ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0").equals(true));
        }

    }
    /*      //noPageFactory
    public void waitPresentAndClick(By clickElement){
        wait = new WebDriverWait(this.driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(clickElement)).click();
        this.waitForAjaxToFinish();
    }
    public void waitVisibleAndClick(By clickElement){
        wait = new WebDriverWait(this.driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickElement)).click();
        this.waitForAjaxToFinish();
    }
    public void waitVisibleAndClick(WebElement webElement){
        wait = new WebDriverWait(this.driver, 2);
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
        this.waitForAjaxToFinish();
    }
    public void waitClickableAndClick(By clickElement){
        wait = new WebDriverWait(this.driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(clickElement)).click();
        this.waitForAjaxToFinish();
    }*/
}
