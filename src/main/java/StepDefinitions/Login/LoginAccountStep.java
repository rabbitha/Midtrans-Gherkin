package StepDefinitions.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import repository.LoginAccount.loginAccount;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static baseAction.Hook.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LoginAccountStep extends loginAccount {
//    @LA002
    @When("Businessman open Login Account Page")
    public void businessmanOpenLoginAccountPage() {
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

        driver.findElement(By.cssSelector(Login_TextLink)).click();

        String URLLogin_Actual = driver.getCurrentUrl();
        System.out.println("Expected Login Page : " + URLLogin_Expected);
        System.out.println("Actual Login Page : " + URLLogin_Actual);
        assertEquals(URLLogin_Expected,URLLogin_Actual);
        System.out.println("--- The URL Login Page is Match ---");

        String TitleLogin_Actual = driver.getTitle();
        System.out.println("Expected Title Login Page : " + TitleLogin_Expected);
        System.out.println("Actual Title Login Page : " + TitleLogin_Actual);
        assertEquals(TitleLogin_Expected,TitleLogin_Actual);
        System.out.println("--- The Title Login Page is Match ---");
    }

    @And("Businessman fill password with invalid data")
    public void businessmanFillPasswordWithInvalidData() {
        driver.findElement(By.xpath(EmailAddress_Textbox)).sendKeys(EmailValid);
        driver.findElement(By.xpath(Password_Textbox)).sendKeys(PasswordInvalid);
        driver.findElement(By.cssSelector(LogMeIn_Button)).click();
    }

    @Then("Businessman can't login")
    public void businessmanCanTLogin() {
        assertNotEquals(Alert_EmailTextbox,EmailAddress_Textbox);
        assertNotEquals(Alert_PasswordTextbox,Password_Textbox);
        System.out.println("--- The Textbox Alert is Displayed ---");

        String TextAlert_Actual = driver.findElement(By.cssSelector(TextAlert)).getText();
        System.out.println("Expected Alert Text Failed Login : " + TextAlert_Expected);
        System.out.println("Actual Alert Text Failed Login : " + TextAlert_Actual);
        assertEquals(TextAlert_Expected,TextAlert_Actual);
        System.out.println("--- The Alert Text Failed Login is Match ---");

        System.out.println("--- Failed To Login Account ---");
    }

//-------------------------------------------------------------------------------------------------------------------------//
//    @RA001
    @And("Businessman fill Form Login Account")
    public void businessmanFillFormLoginAccount() {
        driver.findElement(By.xpath(EmailAddress_Textbox)).sendKeys(EmailValid);
        driver.findElement(By.xpath(Password_Textbox)).sendKeys(PasswordValid);
        driver.findElement(By.cssSelector(LogMeIn_Button)).click();
    }

    @Then("Businessman on Dashboard Account")
    public void businessmanOnDashboardAccount() {
        driver.findElement(By.cssSelector(closePopup_Button)).click();

        String URLDashboard_Actual = driver.getCurrentUrl();
        System.out.println("Expected URL Dashboard : " + URLDashboard_Expected);
        System.out.println("Actual URL Dashboard : " + URLDashboard_Actual);
        assertEquals(URLDashboard_Expected,URLDashboard_Actual);
        System.out.println("--- The URL Dashboard is Match ---");

        String User_Actual = driver.findElement(By.xpath(user)).getText();
        System.out.println("Expected User : " + EmailValid);
        System.out.println("Actual User : " + User_Actual);
        assertEquals(EmailValid,User_Actual);
        System.out.println("--- The User is Match ---");

        boolean sidebar_displayed = driver.findElement(By.xpath(sidebar)).isDisplayed();
        if(sidebar_displayed){
            System.out.println("--- Sidebar is display ---");
        }else{
            System.out.println("--- Sidebar isn't display ---");
        }

        System.out.println("--- You on Dashboard Page ---");
    }


}
