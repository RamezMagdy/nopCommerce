package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class D05_HoverCategoriesStepDefs {
    WebDriver driver;
    P03_HomePage p03HomePage =new P03_HomePage();


    @Given("user hover categories")
    public void hover(){
        Actions action = new Actions(Hook.webDriver);
        action.moveToElement(p03HomePage.aparelHover()).perform();
        action.moveToElement(p03HomePage.electronicsHover()).perform();
        action.moveToElement(p03HomePage.computerHover()).perform();


    }
    @When("user click on subcategory")
    public void click_subcategory(){
        Hook.webDriver.findElement(p03HomePage.desktopSub()).click();
    }
    @And("user go to product page")
    public void product_page(){
        String expected="Desktops";
        String actual= Hook.webDriver.findElement(p03HomePage.pageTitle()).getText();
        Assert.assertTrue(actual.contains(expected));
    }
}