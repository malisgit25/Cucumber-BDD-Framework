package com.gdit.stepdefinitions;

import com.gdit.base.DriverFactory;
import com.gdit.pages.LoginPage;
import com.gdit.pages.SearchAndApplyPage;

import io.cucumber.java.en.*;

public class LoginSteps {

    LoginPage login = new LoginPage(DriverFactory.getDriver());
    SearchAndApplyPage search = new SearchAndApplyPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_on_login_page() {
        login.waitForLoginPage();
    }

    @When("user logs in with email {string} and password {string}")
    public void login_user(String email, String password) {
        login.enterEmailAddress(email);
        login.enterPassword(password);
        login.clickOnSignInButton();
    }

    @Then("user should be on the search page")
    public void verify_navigation() {
        search.waitForSearchPage();
    }

    @When("user searches for {string}")
    public void search_job(String jobTitle) {
        search.clickonSearchAndApplyButton();
        search.searchForJob(jobTitle);
    }

    @When("user selects a job from results")
    public void select_job() {
        search.clickOnJobTitle();
    }

	/*
	 * @When("user clicks apply") public void click_apply() { search.clickApply(); }
	 * 
	 * @Then("application form should open") public void verify_application_form() {
	 * search.verifyApplicationForm(); }
	 */
}