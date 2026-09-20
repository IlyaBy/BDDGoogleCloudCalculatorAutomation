Feature: Google Cloud Pricing Calculator Verification

  @smoke
  Scenario: Compare calculator estimated cost at Pricing page with calculator cost at Detailed view page
    Given I am on the Google Cloud Pricing Calculator page
    When I initialize the Compute Engine estimation
    And I configure the Compute Engine form with following specification:

      | numberOfInstances | operatingSystem | provisioningModel | machineFamily   | series | machineType   | gpuType           | gpuNumber | localSSD | region      | discountOptions |
      | 4                 | Free: Debian    | Regular           | General Purpose | n1     | n1-standard-8 | nvidia-tesla-p100 | 1         | 2x375 GB | Netherlands | 1 year          |

    And I save the estimated cost from the calculator Pricing page
    And I navigate to the Detailed view page
    Then I verify that the estimated cost at Pricing page matches the calculator cost at Detailed view page
