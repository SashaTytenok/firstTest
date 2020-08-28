package services;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager{
    public static <T extends BasePage> T getPage(WebDriver driver, Class<T> cl){
        return PageFactory.initElements(driver, cl);
    }
}
