package StepDefinitions.RegistrationAccount;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import repository.RegistrationAccount.registrationAccount;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static baseAction.Hook.*;
import static org.junit.Assert.assertEquals;

public class RegistrationAccountStep extends registrationAccount{


    @Given("Businessman access website")
    public void businessmanAccessWebsite() {
        System.out.println("--- Do you want to create a new account or login? ---");
    }

    //RA002
    @When("Businessman open Regisration Pages")
    public void businessmanOpenRegisrationPages() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUp_Button)));

        driver.findElement(By.xpath(SignUp_Button)).click();
        System.out.println("Parent window title: " + driver.getTitle());

        Set<String> switchWindow = driver.getWindowHandles();
        System.out.println(switchWindow);
        Iterator<String> iterator = switchWindow.iterator();
        String parentWindow = iterator.next();
        System.out.println("Parent Window : " +parentWindow);
        String childWindow = iterator.next();
        System.out.println("Child  Window : " +childWindow);
        driver.switchTo().window(childWindow);

        String RegistrationPage_Actual = driver.getCurrentUrl();
        System.out.println("Expected Registration Page : " + RegistrationPage_Expected);
        System.out.println("Actual Registration Page : " + RegistrationPage_Actual);
        assertEquals(RegistrationPage_Expected,RegistrationPage_Actual);
        System.out.println("--- The URL Page is Match ---");
    }

    @And("Businessman click button Register without fill form registration")
    public void businessmanClickButtonRegisterWithoutFillFormRegistration() {
        driver.findElement(By.cssSelector(Register_Button)).click();
    }

    @Then("Businessman can't create new account")
    public void businessmanCanTCreateNewAccount() {
        String BusinessName_Actual = driver.findElement(By.xpath(BusinessName_alert)).getText();
        String FullName_Actual = driver.findElement(By.xpath(FullName_alert)).getText();
        String BusinessEmail_Actual = driver.findElement(By.xpath(BusinessEmail_alert)).getText();
        String BusinessPhoneNumber_Actual = driver.findElement(By.xpath(BusinessPhoneNumber_alert)).getText();
        String Password_Actual = driver.findElement(By.xpath(Password_alert)).getText();
        String ConfirmPassword_Actual = driver.findElement(By.xpath(ConfirmPassword_alert)).getText();

        System.out.println("Expected Alert Business Name : " + BusinessName_Expected);
        System.out.println("Actual Alert Business Name : " + BusinessName_Actual);
        assertEquals(BusinessName_Expected,BusinessName_Actual);
        System.out.println("--- Alert Business Name is Match ---");

        System.out.println("Expected Alert Full Name : " + FullName_Expected);
        System.out.println("Actual Alert Full Name : " + FullName_Actual);
        assertEquals(FullName_Expected,FullName_Actual);
        System.out.println("--- Alert Full Name is Match ---");

        System.out.println("Expected Alert Business Email : " + BusinessEmail_Expected);
        System.out.println("Actual Alert Business Email : " + BusinessEmail_Actual);
        assertEquals(BusinessEmail_Expected,BusinessEmail_Actual);
        System.out.println("--- Alert Business Email is Match ---");


        System.out.println("Expected Alert Business Phone Number : " + BusinessPhoneNumber_Expected);
        System.out.println("Actual Alert Business Phone Number : " + BusinessPhoneNumber_Actual);
        assertEquals(BusinessPhoneNumber_Expected,BusinessPhoneNumber_Actual);
        System.out.println("--- Alert Business Phone Number is Match ---");

        System.out.println("Expected Alert Password : " + Password_Expected);
        System.out.println("Actual Alert Password : " + Password_Actual);
        assertEquals(Password_Expected,Password_Actual);
        System.out.println("--- Business Name is Match ---");

        System.out.println("Expected Alert Confirm Password : " + ConfirmPassword_Expected);
        System.out.println("Actual Alert Confirm Password : " + ConfirmPassword_Actual);
        assertEquals(ConfirmPassword_Expected,ConfirmPassword_Actual);
        System.out.println("--- Alert Confirm Password is Match ---");

        System.out.println("--- Failed to create new account ---");
    }

//---------------------------------------------------------------------------------------------------------------------//
//    @RA001
    @When("Businessman open Regisration Page")
    public void businessmanOpenRegisrationPage() throws InterruptedException{

        String PageTitle = driver.getTitle();
        System.out.println("Page Title : " +PageTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUp_Button)));

        driver.findElement(By.xpath(SignUp_Button)).click();
        System.out.println("Parent window title: " + driver.getTitle());

        Set<String> switchWindow = driver.getWindowHandles();
        System.out.println(switchWindow);
        Iterator<String> iterator = switchWindow.iterator();
        String parentWindow = iterator.next();
        System.out.println("Parent Window : " +parentWindow);
        String childWindow = iterator.next();
        System.out.println("Child  Window : " +childWindow);
        driver.switchTo().window(childWindow);
        String childWindow2 = iterator.next();
        System.out.println("Child  Window 2 : " +childWindow2);
        driver.switchTo().window(childWindow2);

        String RegistrationPage_Actual = driver.getCurrentUrl();
        System.out.println("Expected Registration Page : " + RegistrationPage_Expected);
        System.out.println("Actual Registration Page : " + RegistrationPage_Actual);
        assertEquals(RegistrationPage_Expected,RegistrationPage_Actual);
        System.out.println("--- The URL Page is Match ---");
    }

    @And("Businessman fill Form Registration")
    public void businessmanFillFormRegistration() throws InterruptedException{
        driver.findElement(By.cssSelector(BusinessName_TextBox)).sendKeys(BusinessName);
        driver.findElement(By.cssSelector(FullName_TextBox)).sendKeys(FullName);
        driver.findElement(By.cssSelector(BusinessEmail_TextBox)).sendKeys(BusinessEmail);
        driver.findElement(By.cssSelector(BusinessPhoneNumber_Textbox)).sendKeys(BusinessPhoneNumber);
        driver.findElement(By.cssSelector(Password_Textbox)).sendKeys(Password);
        driver.findElement(By.cssSelector(ConfirmPassword_TextBox)).sendKeys(ConfirmPassword);
//        driver.findElement(By.cssSelector(Register_Button)).click();
        Thread.sleep(3000);
    }

    @Then("Businessman success create account")
    public void businessmanSuccessCreateAccount() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String URLSuccess_Actual = driver.getCurrentUrl();
        System.out.println("Expected URL Success : " + URLSuccess_Expected);
        System.out.println("Actual URL Success : " + URLSuccess_Actual);
        assertEquals(URLSuccess_Expected,URLSuccess_Actual);
        System.out.println("--- The URL Success is Match ---");

        boolean box_enable = driver.findElement(By.xpath(SuccesAlert_Box)).isEnabled();
        if (box_enable){
            System.out.println("----  Alert success create account displayed -----");
        } else {
            System.out.println("---- Alert success create account not displayed -----");
        }

        if (driver.getPageSource().contains("activate your account")){
            System.out.println("----  Check your email to verify -----");
        }else {
            System.out.println("----  Failed Create Account -----");
        }
    }

}
