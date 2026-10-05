# Google Cloud Calculator BDD Automation Framework

This project is an automated BDD QA test framework designed to validate the Google Cloud Pricing Calculator and ensure that pricing logic, user interactions, and cross-page business flows work correctly in real browser conditions.

The framework covers the following scenario:
- Comparing and asserting calculated costs consistency between the interactive pricing form (`CalculatorPricingPage`) and the detailed breakdown view (`DetailedViewPage`).

## Key QA aspects
- **Behavior-Driven Development (BDD):** Scenarios defined in human-readable Gherkin syntax mapped to Java step definitions.
- **Test Automation Design Patterns:** Implementation of Page Object Model (POM) and data-driven Domain Modeling (`ComputeEngineInstance`).
- **Test Suite Management:** Organized execution via TestNG XML suites for progressive smoke and regression coverage.
- **Robust Architecture:** Clean separation of concerns across driver managers, hooks, page layers, and step definitions.
- **CI/CD Execution:** Fully orchestrated pipeline via Jenkins using a declarative `jenkinsfile`.
- **Advanced Reporting:** Real-time test evidence tracking, logger diagnostics (Log4j 2), and step-level traceability with Allure Reporting.

## Tech stack
- Java 17
- Maven
- Selenium WebDriver
- Cucumber 7
- TestNG
- Log4j 2
- Jenkins
- Allure Reporting

## BDD Scenario Example
```gherkin
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
```

## Example run
To execute specific test suites or feature files, use the following Maven commands:

```bash
# Run via TestNG XML Suite (Regression suite available only)
mvn clean test -DsuiteXmlFile=src/test/resources/regression-suite.xml
```
The project reflects practical experience in behavior-driven automated testing for web applications, with emphasis on test reliability, business-readable scenarios, and CI/CD readiness.
```

