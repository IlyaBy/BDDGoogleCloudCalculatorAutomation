package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class BackgroundPage extends AbstractPage{
    private final Logger logger = LogManager.getLogger(BackgroundPage.class);
    private final String pageUrl = "https://cloud.google.com/";
    private final By calculatorCookieAcceptButton = By.xpath("//button[@class='glue-cookie-notification-bar__accept']");
    private final By pricingMenu = By.xpath("//a[contains(text(),'Pricing')]");
    private final By CalculatorPricingLink = By.xpath("//div[contains(text(),'Pricing calculator')]");

    public BackgroundPage(WebDriver driver) { super (driver);

    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(pageUrl);
        logger.info("GoogleCloudStartPage page opened"+ pageUrl);
        return this;
    }

    public void acceptCookiesIfPresent() {
        try {
            waitAndClick(calculatorCookieAcceptButton);
        } catch (TimeoutException e) {
            logger.info("Cookie snackbar did not appear, continuing execution");
        }
    }

    public BackgroundPage openPricingMenu (){
        waitAndClick(pricingMenu);
        return this;
    }

    public CalculatorPricingPage openCalculatorPricingPage (){
        waitAndClick(CalculatorPricingLink);
        logger.info("CalculatorPricingPage page opened");
        return new CalculatorPricingPage(driver);
    }
}
