package com.example.Steps;

import java.util.concurrent.TimeUnit;

import com.example.Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.PageObjects.A_LoginPage;
import com.example.PageObjects.B_OrganizationPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class participatingSiteSearchPA extends BaseClass {
    static WebDriver driver;
    //A_LoginPage loginPage=new A_LoginPage(driver);
    //B_AcceptPage acceptPage=new B_AcceptPage(driver);


    @Before
    public void setup() throws Throwable{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Given("^Open Chrome and launch application$")
    public void open_chrome_and_launch_application() throws Throwable{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
         driver=new ChromeDriver();
        driver.get("https://trials-int.nci.nih.gov/");
        Thread.sleep(3000);
    }
    @When("^I enter Username and password$")
    public void i_enter_username_and_password() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        //objLoginPage=new A_LoginPage(driver);
        Thread.sleep(3000);
        loginPage.setUserName();
        loginPage.setPassword();
    }

    @When("^the website opens$")
    public void the_website_opens() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickSigninSubmit();
        Thread.sleep(4000);
    }

    @When("^I click on Protocol Abstraction$")
    public void i_click_on_protocol_abstraction() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickProtocolAbstraction();
        loginPage.clickAccept();
        Thread.sleep(4500);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

    }


    @Given("^I click on Organizations menu option$")
    public void iClickOnOrganizationsMenuOption() {
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.clickOrganizationsMenu();
    }

    @When("^I type OH029 into CTEP ID$")
    public void iTypeOHIntoCTEPID() {
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.typeIntoCTEPID();
    }

    @Then("^I select Healthcare Facility from Organization Type$")
    public void iSelectHealthcareFacilityFromOrganizationType() {
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.selectOrganizationType();
    }

    @Then("^I click on Search$")
    public void iClickOnSearch() {
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.clickSearch();
    }

    @Then("^I Assert Case Western Reserve University matches$")
    public void iAssertCaseWesternReserveUniversityMatches() {
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.assertion_method();
    }

    @Then("^I click on Logout$")
    public void iClickOnLogout() {
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.clickLogout();
    }
}
