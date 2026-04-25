package com.gdit.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.gdit.base.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

//Cucumber Lifecycle + Screenshot
public class Hooks {

    @Before
    public void setup() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        	DriverFactory.quitDriver();
    }
	/* USE THIS FOR NULL SAFETY
	 * if (DriverFactory.getDriver() != null) { ScreenshotUtil.capture(driver); }
	 */

}