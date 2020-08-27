import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass {
    protected static WebDriver driver;
    protected WebDriverWait wait;

    public void waitForAjaxToFinish() {
        Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return (typeof(jQuery) != 'undefined')");
        if(isJqueryUsed){
            wait = new WebDriverWait(this.driver, 5);
            wait.until((ExpectedCondition<Boolean>) driver ->
                    ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0").equals(true));
        }
    }
}
