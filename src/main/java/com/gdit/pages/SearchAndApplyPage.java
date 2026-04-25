package com.gdit.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAndApplyPage {
	
	WebDriver driver;
    WebDriverWait wait;

    //By searchBtn = By.cssSelector("button[data-automation-id='navigationItem-Search and Apply']");
    
    //Locator
    
    private By SearchandApply = By.cssSelector("button[data-automation-id='navigationItem-Search and Apply']");
	private By jobSearchRoot = By.cssSelector("input.search-input");
	private By searchInput = By.className("search-input");
	private By submitButton = By.id("submit-button");
	private By jobtitle = (By.xpath("//a[contains(@href,'/careers/job') and contains(@href,'engineer')]"));

    public SearchAndApplyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
 // wait for Click on apply and search button and click on it
    
    
    public void waitForSearchPage() {
 		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchandApply));
 		   
    }
    
 	public void clickonSearchAndApplyButton() {
 		WebElement searchandapply = wait.until(ExpectedConditions.visibilityOfElementLocated(SearchandApply));
 		searchandapply.click();
 	}

 	


	public void searchForJob(String jobTitle) {
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchInput));
		searchBox.clear();
		searchBox.sendKeys(jobTitle);
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}

	// find title element for the first job card
	// WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
	public void clickOnJobTitle() {
		WebElement titleEl = wait.until(ExpectedConditions.elementToBeClickable(jobtitle));
		titleEl.click();
	}
    
    
}


