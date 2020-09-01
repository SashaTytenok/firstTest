package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
public class StoragePage extends BasePage{
    //кнопка попапа
    @FindBy(xpath = "//div[@class='dialog__wrap']/button[contains(@class, dialog__close)]")
    private WebElement closeUselessPopUp;

    @FindBy(xpath = "//span[contains(@class, 'upload-button')]")
    private WebElement uploadButton;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement inputForFile;

    @FindBy(xpath = "//div[@style='width: 100%;']")
    private WebElement isFilesUpload;

    @FindBy(xpath = "//button[contains(@class, 'uploader-progress__close-button')]")
    private WebElement closeUploadContainer;

    @FindBy(xpath = "//div[@class='listing__items']/div[not(contains(@class , 'listing-item_theme_tile-empty'))]")
    private List<WebElement> listOfUploadedFiles;

    @FindBy(xpath = "//div[contains(@class, 'js-prevent-drag')]")
    private WebElement trashIcon;

    @FindBy(xpath = "//div[contains(@class , 'nb-island')]")
    private WebElement haveDeletedContainer;

    @FindBy(xpath = "//button[contains(@class, 'client-listing__clean-trash-button')]")
    private WebElement cleanTrash;

    @FindBy(xpath = "//button[contains(@class, 'confirmation-dialog__button_submit')]")
    private WebElement completelyDeleteButton;

    @FindBy(xpath = "//div[contains(@class, 'notifications__item_moved')]")
    private WebElement Success;

    public ArrayList<WebElement> getNeededElements(List<WebElement> listFrom, ArrayList<File> filesList){
        //getting names from income list of Files
        ArrayList<String> namesOfFiles = new ArrayList<>();
        for (File tmp: filesList) {
            namesOfFiles.add(tmp.getName());
        }
        //make list of WebElements, that we need
        ArrayList<WebElement> tmp=new ArrayList<>();
        for (WebElement e: listFrom) {
            if(namesOfFiles.contains(e.getText())){
                tmp.add(e);
            }
        }
        return tmp;
    }
}
