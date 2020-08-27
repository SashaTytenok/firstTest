import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public Short threadId;
    public WaitClass() {
        this.threadId =(short) Thread.currentThread().getId();
    }
    public WaitClass(Short threadId) {
        this.threadId = threadId;
    }

    public void waitForAjaxToFinish(WebDriver driver) {
        Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return (typeof(jQuery) != 'undefined')");
        if(isJqueryUsed){
            wait = new WebDriverWait(driver, 5);
            wait.until((ExpectedCondition<Boolean>) tmp ->
                    ((JavascriptExecutor) tmp).executeScript("return jQuery.active == 0").equals(true));
        }
    }
}
