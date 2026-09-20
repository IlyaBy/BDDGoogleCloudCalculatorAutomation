package steps;
import driver.DriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.ComputeEngineInstance;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CalculatorPricingPage;
import pages.DetailedViewPage;

public class CostVerificationSteps {

    private final CalculatorPricingPage calculatorPricingPage;
    private DetailedViewPage detailedViewPage;

    private String calculatorEstimatedCost;
    private String detailedViewEstimatedCost;


    public CostVerificationSteps() {
        WebDriver driver = DriverSingleton.getDriver();
        this.calculatorPricingPage = new CalculatorPricingPage(driver);
    }
    @Given("^I am on the Google Cloud Pricing Calculator page$")
    public void iAmOnTheGoogleCloudPricingCalculatorPage() {

        calculatorPricingPage.openPage();
    }
    @When("^I initialize the Compute Engine estimation$")
    public void iInitializeTheComputeEngineEstimation() {

        calculatorPricingPage.startEstimation();
    }

    @And("^I configure the Compute Engine form with following specification:$")
    public void iConfigureTheFormWithFollowingSpecification(ComputeEngineInstance testInstance) {

        calculatorPricingPage.setNumberOfInstances(testInstance.getNumberOfInstances())
                .selectOperatingSystem(testInstance.getOperatingSystem())
                .selectProvisioningModel(testInstance.getProvisioningModel())
                .selectMachineFamily(testInstance.getMachineFamily())
                .selectSeries(testInstance.getSeries())
                .selectMachineType(testInstance.getMachineType())
                .selectGPUType(testInstance.getGpuType())
                .selectGPUNumber(testInstance.getGpuNumber())
                .selectLocalSSD(testInstance.getLocalSSD())
                .selectRegion(testInstance.getRegion())
                .selectDiscountOptions(testInstance.getDiscountOptions());
    }

    @And("^I save the estimated cost from the calculator Pricing page$")
    public void iSaveTheEstimatedCostFromTheCalculator() {

        calculatorEstimatedCost = calculatorPricingPage.getCalculatorCost();
    }

    @And("^I navigate to the Detailed view page(?: using tab index (\\d+))?$")
    public void iNavigateToTheDetailedViewReportTab(String tabIndexStr) {
        calculatorPricingPage.openDetailedView();

        int tabIndex = (tabIndexStr != null) ? Integer.parseInt(tabIndexStr) : 2;

        detailedViewPage = calculatorPricingPage.switchToDetailedViewPage(tabIndex);
    }

    @Then("^I verify that the estimated cost at Pricing page matches the calculator cost at Detailed view page$")
    public void iVerifyThatTheTotalCostMatchesTheSavedCalculatorCost() {

        detailedViewEstimatedCost = detailedViewPage.getDetailedViewCost();

        Assert.assertEquals(calculatorEstimatedCost, detailedViewEstimatedCost,
                "ERROR: Estimated cost on Calculator Page doesn't match Detailed View Page cost!");
    }
}
