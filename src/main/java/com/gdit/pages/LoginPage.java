package com.gdit.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	By email = By.cssSelector("input[data-automation-id='email']");
	By password = By.cssSelector("input[data-automation-id='password']");
	By signIn = By.cssSelector("div[aria-label='Sign In']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void waitForLoginPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
	}

	public void enterEmailAddress(String val) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(val);
	}

	public void enterPassword(String val) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(val);
	}

	/*
	 * public void clickOnSignInButton() { WebElement btn =
	 * wait.until(ExpectedConditions.elementToBeClickable(signIn));
	 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn); }
	 */

	public void clickOnSignInButton() {
		WebElement signInBtn = wait.until(driver -> {
			WebElement el = driver.findElement(signIn);
			return (el.isDisplayed() && el.isEnabled() && el.getSize().getHeight() > 0 && el.getSize().getWidth() > 0)
					? el
					: null;
		});

		// Optional tiny sleep for React rendering
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
		}

		// JS click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInBtn);

	}
}