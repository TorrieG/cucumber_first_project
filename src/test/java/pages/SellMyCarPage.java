package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellMyCarPage {

    public SellMyCarPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".sc-4ef54ea5-6")
    public WebElement offerInMinutesHeadingText;

    @FindBy(css = ".sc-4ef54ea5-17")
    public WebElement getPaidSubHeadingText;

    @FindBy(css = ".SecondOption-bos1o7-3")
    public WebElement vinButton;

    @FindBy(css = ".sc-24849329-1 input")
    public WebElement vinInputBox;

    @FindBy(css = ".sc-efc18c8f-7")
    public WebElement getMyOfferButton;

    @FindBy(css = ".sc-fTFLOO")
    public WebElement noVINText;
}
