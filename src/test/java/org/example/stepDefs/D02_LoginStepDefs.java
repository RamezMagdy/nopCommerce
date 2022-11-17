package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_LoginPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D02_LoginStepDefs {
    WebDriver driver;
    P02_LoginPart login=new P02_LoginPart();
    SoftAssert softAssert =new SoftAssert();

    @Given("user go to login page")
    public void login_page(){
        login.loginlink().click();
    }
    @When("user login with \"valid\" \"fast@gmail.com\" and \"P@ssw0rd\"")
    public void valid_login_data(){
        login.loginData(driver,"rightone1@gmail.com","P@ssw0rd");
    }
    @When("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void invalid_login_data(){
        login.loginData(driver,"wrong@gmail.com","P@ssw0rd");
    }
    @And("user press on login button")
    public void login_button(){
        Hook.webDriver.findElement(login.loginBtn()).click();
    }
    @Then("user login to the system successfully")
    public void success_login(){
        softAssert.assertTrue(Hook.webDriver.findElement(login.tab()).isDisplayed());
        softAssert.assertEquals(Hook.webDriver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }
    @Then("user could not login to the system")
    public void failed_login(){
        String expectedResult="Login was unsuccessful";
        String actualResult= Hook.webDriver.findElement(login.failedMSG()).getText();
        softAssert.assertTrue(actualResult.contains(expectedResult));
        String color= Hook.webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getCssValue("color");
        System.out.println("Color: "+color);
        softAssert.assertAll();
    }
}