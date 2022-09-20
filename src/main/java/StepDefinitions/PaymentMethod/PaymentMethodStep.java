package StepDefinitions.PaymentMethod;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import repository.PaymentMethod.paymentMethod;


import static baseAction.Hook.*;

public class PaymentMethodStep extends paymentMethod {
    @Given("Buyer access website")
    public void buyerAccessWebsite() {
        System.out.println("--- Please place an order :) ---");
    }

    @When("Buyer checkout a pillow midtrans")
    public void buyerCheckoutAPillowMidtrans() {
        driver.findElement(By.xpath(Button_BuyNow)).click();

        //Fill form Personal Data Order
        driver.findElement(By.cssSelector(Name_TextBox)).clear();
        driver.findElement(By.cssSelector(Name_TextBox)).sendKeys(Name);
        driver.findElement(By.cssSelector(Email_TextBox)).clear();
        driver.findElement(By.cssSelector(Email_TextBox)).sendKeys(Email);
        driver.findElement(By.cssSelector(PhoneNo_TextBox)).clear();
        driver.findElement(By.cssSelector(PhoneNo_TextBox)).sendKeys(PhoneNo);
        driver.findElement(By.cssSelector(City_TextBox)).clear();
        driver.findElement(By.cssSelector(City_TextBox)).sendKeys(City);
        driver.findElement(By.cssSelector(Address_TextBox)).clear();
        driver.findElement(By.cssSelector(Address_TextBox)).sendKeys(Address);
        driver.findElement(By.cssSelector(PostalCode_TextBox)).clear();
        driver.findElement(By.cssSelector(PostalCode_TextBox)).sendKeys(PostalCode);
        driver.findElement(By.cssSelector(Checkout_button)).click();

    }

    @And("Buyer choose method payment credit\\/debit card")
    public void buyerChooseMethodPaymentCreditDebitCard() {
        driver.switchTo().frame(iframe1);
        driver.findElement(By.xpath(creditcard)).click();
    }

    @And("Buyer fill in credential card with the selected promo")
    public void buyerFillInCredentialCardWithTheSelectedPromo() {
        driver.findElement(By.cssSelector(CardNumber_TextBox)).sendKeys(CardNumber);
        driver.findElement(By.cssSelector(ExpirationDate_TextBox)).sendKeys(ExpirationDate);
        driver.findElement(By.cssSelector(CVV_TextBox)).sendKeys(CVV);
        driver.findElement(By.cssSelector(PayNow_Button)).click();
    }
    @And("Buyer fill OTP Bank")
    public void buyerFillOTPBank() {
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath(Password_TextBox)).sendKeys(Password_OTP);
        driver.findElement(By.cssSelector(OK_Button)).click();
    }

    @Then("Payment is successfull")
    public void paymentIsSuccessfull() {
    }

    @And("Buyer fill OTP Bank with invalid data")
    public void buyerFillOTPBankWithInvalidData() {
    }

    @Then("Payment Failed")
    public void paymentFailed() {
    }
}
