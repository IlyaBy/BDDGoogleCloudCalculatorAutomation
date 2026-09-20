
Feature: Google Cloud Pricing Calculator Verification
Background:
  Given I am on the GoogleCloudStartPage
  When  I click on Pricing drop-down menu
  And   I accept the cookies if present
  And   I choose a Pricing calculator option to open GoogleCloudPricingCalculatorPage

  @smoke
  Scenario Outline: Compare calculator estimated cost at Pricing page with calculator cost at Detailed view page
    When I initialize the Compute Engine estimation
    And I configure the Compute Engine form with following specification:

      | numberOfInstances | operatingSystem   | provisioningModel   | machineFamily   | series   | machineType   | gpuType   | gpuNumber   | localSSD   | region   | discountOptions   |
      | <instancesCount>  | <operatingSystem> | <provisioningModel> | <machineFamily> | <series> | <machineType> | <gpuType> | <gpuNumber> | <localSSD> | <region> | <discountOptions> |
    And I save the estimated cost from the calculator Pricing page
    And I navigate to the Detailed view page using tab index <tabIndex>
    Then I verify that the estimated cost at Pricing page matches the calculator cost at Detailed view page
    Examples:

      | instancesCount | operatingSystem | provisioningModel | machineFamily   | series | machineType   | gpuType           | gpuNumber | localSSD | region      | discountOptions | tabIndex |
      | 4              | Free: Debian    | Regular           | General Purpose | n1     | n1-standard-8 | nvidia-tesla-p100 | 1         | 2x375 GB | Netherlands | 1 year          | 2        |