package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa='header-items']>a")
    public List<WebElement> menuHeaderLinks;

    @FindBy(css = "span.kAQuLc")
    public WebElement financing;

    @FindBy(css = ".ewpFSy>a")
    public List<WebElement> financingDropdownLinks;

    public void clickOnHeaderLink(String linkText){
        for (WebElement link : menuHeaderLinks) {
            if (link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }


    public void clickOnFinancialDropdownLinks(String linkText){
        for (WebElement link : financingDropdownLinks) {
            if (link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }

}
