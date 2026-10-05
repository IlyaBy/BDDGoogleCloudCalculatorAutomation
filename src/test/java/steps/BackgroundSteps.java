package steps;

import io.cucumber.java.en.When;
import driver.DriverSingleton;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.BackgroundPage;

    public class BackgroundSteps {
        private final WebDriver driver;
        private final BackgroundPage backgroundPage;

        public BackgroundSteps() {
            this.driver = DriverSingleton.getDriver();
            this.backgroundPage = new BackgroundPage(driver);
        }

        @Given("^I am on the GoogleCloudStartPage$")
        public void iAmOnTheGoogleCloudStartPage() {

            backgroundPage.openPage();
        }

        @When("^I click on Pricing drop-down menu$")
        public void iClickOnPricingDropDownMenu() {
            backgroundPage.openPricingMenu();
        }

        @When("^I accept the cookies if present$")
        public void iAcceptTheCookiesIfPresent() {
            backgroundPage.acceptCookiesIfPresent();
        }

        @When("^I choose a Pricing calculator option to open GoogleCloudPricingCalculatorPage$")
        public void iChooseAPricingCalculatorOptionToOpenGoogleCloudPricingCalculatorPage() {

            backgroundPage.openCalculatorPricingPage();

            /*String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("calculator"),
                    "ERROR: Google Cloud Pricing Calculator page was not opened! Current URL: " + currentUrl);*/
        }
    }
