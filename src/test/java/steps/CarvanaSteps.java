package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.Driver;
import utilities.Waiter;


public class CarvanaSteps {

    WebDriver driver;
    HomePage homePage;
    HelpMeSearchPage helpMeSearchPage;
    CarFinderPage carFinderPage;
    SellMyCarPage sellMyCarPage;
    AutoLoanCalculator autoLoanCalculator;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        homePage = new HomePage();
        helpMeSearchPage = new HelpMeSearchPage();
        carFinderPage = new CarFinderPage();
        sellMyCarPage = new SellMyCarPage();
        autoLoanCalculator = new AutoLoanCalculator();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuLinks) {
        switch (menuLinks){
            case "SELL/TRADE":
            case "CAR FINDER":
                homePage.clickOnHeaderLink(menuLinks);
                break;
            case "AUTO LOAN CALCULATOR":
                homePage.clickOnFinancialDropdownLinks(menuLinks);
                break;
            default:
                throw new NotFoundException("The menu item link is not defined properly in the feature file!!!");

        }

    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Waiter.pause(1);
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String headingText) {
        switch (headingText) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carFinderPage.carShouldIGetText.isDisplayed());
                Assert.assertEquals(headingText, carFinderPage.carShouldIGetText.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carFinderPage.answerAFewQuestionsText.isDisplayed());
                Assert.assertEquals(headingText, carFinderPage.answerAFewQuestionsText.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(helpMeSearchPage.whatsImportantHeadingText.isDisplayed());
                Assert.assertEquals(headingText, helpMeSearchPage.whatsImportantHeadingText.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(helpMeSearchPage.select4SubHeadingText.isDisplayed());
                Assert.assertEquals(headingText, helpMeSearchPage.select4SubHeadingText.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(sellMyCarPage.offerInMinutesHeadingText.isDisplayed());
                Assert.assertEquals(headingText, sellMyCarPage.offerInMinutesHeadingText.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(sellMyCarPage.getPaidSubHeadingText.isDisplayed());
                Assert.assertEquals(headingText, sellMyCarPage.getPaidSubHeadingText.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Waiter.waitForVisibilityOfElement(driver, sellMyCarPage.noVINText, 8);
                Assert.assertTrue(sellMyCarPage.noVINText.isDisplayed());
                Assert.assertEquals(headingText, sellMyCarPage.noVINText.getText());
                break;

            default:
                throw new NotFoundException("The heading3 text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String link) {
        Assert.assertTrue(carFinderPage.tryCarFinderLink.isDisplayed());
        Assert.assertEquals(link, carFinderPage.tryCarFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
        switch (link){
            case "TRY CAR FINDER":
            carFinderPage.tryCarFinderLink.click();
            break;
            default:
                throw new NotFoundException("The heading3 text is not defined properly in the feature file!!!");
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button){
            case "VIN":
                sellMyCarPage.vinButton.click();
                break;
            case "GET MY OFFER":
                Waiter.pause(3);
                sellMyCarPage.getMyOfferButton.click();
                break;
            default:
                throw new NotFoundException("The button is not defined properly in the feature file!!!");
        }

    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String vinNumber) {
        sellMyCarPage.vinInputBox.sendKeys(vinNumber);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String menuItem) {
        Actions actions = new Actions(driver);
        switch (menuItem){
            case "FINANCING":
                actions.moveToElement(homePage.financing).perform();
                break;
            default:
                throw new NotFoundException("The link is not defined properly in the feature file!!!");
        }


    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String calculatorFormOption, String text) {
        switch (calculatorFormOption){
            case "Cost of Car I want":
                autoLoanCalculator.vehiclePrice.sendKeys(text);
                break;
            case "What is Your Down Payment?":
                autoLoanCalculator.downPayment.sendKeys(text);
                break;
            default:
                throw new NotFoundException("The text is not defined properly in the feature file!!!");
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String calculatorFormOption, String text) {
        switch (calculatorFormOption){
            case "What’s Your credit Score?":
                autoLoanCalculator.clickOnCreditScoreOption(text);
                break;
            case "Choose Your Loan Terms":
                autoLoanCalculator.clickOnLoanTermOption(text);
                break;
            default:
                throw new NotFoundException("The link is not defined properly in the feature file!!!");
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String monthlyPayment) {
        switch (monthlyPayment){
            case "154.00":
                Waiter.waitForVisibilityOfElement(driver, autoLoanCalculator.monthlyPaymentAmount, 8);
                Assert.assertEquals(monthlyPayment, autoLoanCalculator.monthlyPaymentAmount.getText());
                break;
            default:
                throw new NotFoundException("The text is not defined properly in the feature file!!!");
        }
    }
}
