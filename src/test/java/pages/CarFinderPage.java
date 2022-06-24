package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarFinderPage {

    public CarFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "h1")
    public WebElement carShouldIGetText;

    @FindBy(css = "h3")
    public WebElement answerAFewQuestionsText;

    @FindBy(css = "a[data-qa='router-link']")
    public WebElement tryCarFinderLink;


}
