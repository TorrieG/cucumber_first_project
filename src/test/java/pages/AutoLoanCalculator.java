package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutoLoanCalculator {

    public AutoLoanCalculator(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#creditBlock>option")
    public List<WebElement> creditScoreOptions;

    @FindBy(css = "[name='vehiclePrice']")
    public WebElement vehiclePrice;

    @FindBy(css = "[name='downPayment']")
    public WebElement downPayment;

    @FindBy(css = "[name='loanTerm']>option")
    public List<WebElement> loanTerms;

    @FindBy(css = ".loan-calculator-display-value")
    public WebElement monthlyPaymentAmount;

    public void clickOnCreditScoreOption(String linkText){
        for (WebElement link : creditScoreOptions) {
            if (link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }

    public void clickOnLoanTermOption(String linkText){
        for (WebElement link : loanTerms) {
            if (link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }


}
