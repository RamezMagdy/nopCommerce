package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_RegistrationPgae;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D01_RegisterationStepDefs {
    WebDriver driver;
    P01_RegistrationPgae register=new P01_RegistrationPgae();

    @Given("user go to register page")
    public void goRegisterPage(){
        register.registerlink().click();
    }
    @When("user select gender type")
    public void gender_type(){
        register.gender().click();
    }
    @And("user enter first name \"automation\" and last name \"tester\"")
    public void enterName(){
        register.nameInput(driver,"automation","tester");
    }
    @And("user enter date of birth")
    public void date_of_brith(){
        Hook.webDriver.findElement(register.brithDay()).click();
        Hook.webDriver.findElement(register.brithMonth()).click();
        Hook.webDriver.findElement(register.brithYear()).click();
    }
    @And("user enter email \"test@example.com\" field")
    public void enter_email(){
        register.enterEmail(driver,"rightone1@gmail.com");
    }
    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void fills_password(){
        register.enterPassword(driver,"P@ssw0rd","P@ssw0rd");
    }
    @And("user clicks on register button")
    public void register_button(){
        Hook.webDriver.findElement(register.registerBtn()).click();
    }
    @Then("success message is displayed")
    public void success_message(){
        SoftAssert soft=new SoftAssert();
        String expectedResult="Your registration is complete";
        String actualResult= Hook.webDriver.findElement(register.successMSG()).getText();
        soft.assertTrue(actualResult.contains(expectedResult));
        String color= Hook.webDriver.findElement(By.className("result")).getCssValue("color");
        System.out.println("Color: "+color);
        soft.assertAll();
    }
}