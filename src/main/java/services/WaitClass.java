package services;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass {
    //переделал в статик метод, чтобы независимо ото всех вставать в ожидание, передавая только поточный драйвер
    public static void waitForAjaxToFinish(WebDriver driver) {
        Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return (typeof(jQuery) != 'undefined')");
        if(isJqueryUsed){
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until((ExpectedCondition<Boolean>) tmp ->
                    ((JavascriptExecutor) tmp).executeScript("return jQuery.active == 0").equals(true));
        }
    }
}
