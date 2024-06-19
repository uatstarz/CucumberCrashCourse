package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on OpenCart login page")
    public void i_am_on_open_cart_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(), true);
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String string, String string2) {
        loginPage.enterEmail("username");
        loginPage.enterPassword("password");
    }

   // @When("I click on the login button")
   // public void i_click_on_the_login_button() {
    //  loginPage.clickLoginButton();
    // }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String string) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(),  true);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String string) {
        loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password page")
    public void i_should_be_redirected_to_the_password_page() {
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
    }




}
