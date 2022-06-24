package steps;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class BaseSteps {

    WebDriver driver;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
    }
}
