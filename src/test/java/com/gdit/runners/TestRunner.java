package com.gdit.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber + ExtentAdapter
@CucumberOptions(
		features = "src/test/resources/features", 
		glue = { "com.gdit.stepdefinitions","com.gdit.hooks" },
		plugin = { 
				"pretty",
				"html:target/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
				}, 
		monochrome = true,
		dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

}