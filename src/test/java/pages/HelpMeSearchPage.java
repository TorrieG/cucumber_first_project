package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HelpMeSearchPage {

    public HelpMeSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[data-qa=\"headline\"]")
    public WebElement whatsImportantHeadingText;

    @FindBy(css = "[data-qa=\"sub-heading\"]")
    public WebElement select4SubHeadingText;


}

