package services;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Predicate;

public class WaitClass {
    static WebDriverWait wait;
    //переделал в статик метод, чтобы независимо ото всех вставать в ожидание, передавая только поточный драйвер
    public static void waitForAjaxToFinish(WebDriver driver) {
        Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return (typeof(jQuery) != 'undefined')");
        if(isJqueryUsed){
            wait = new WebDriverWait(driver, 5);
            wait.until((ExpectedCondition<Boolean>) tmp ->
                    ((JavascriptExecutor) tmp).executeScript("return jQuery.active == 0").equals(true));
        }
    }
    public static WebElement waitUntilElementIsDisplayed(WebElement webElement, WebDriver driver){
        wait = new WebDriverWait(driver, 6);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void waitUntilToBeClickable(WebElement webElement,WebDriver driver) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
