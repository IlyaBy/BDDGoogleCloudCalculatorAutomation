package steps;

import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        LOGGER.info("Cucumber Hook: Launching the browser...");

        DriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        LOGGER.info("Cucumber Hook: Quitting the browser...");

        DriverSingleton.closeDriver();
    }
}
