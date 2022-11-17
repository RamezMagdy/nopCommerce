package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDefs {
    WebDriver driver;
    P03_HomePage p03HomePage =new P03_HomePage();
    SoftAssert anAssert =new SoftAssert();

    @When("User click on wishlist button of HTC One M8 Android L 5.0 Lollipop")
    public void htc_wishlist_click(){
        p03HomePage.htcWishlist().click();
    }
    @Then("Success MSG appears")
    public void success_MSG(){
        String expected="The product has been added to your wishlist";
        String actual= Hook.webDriver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();
        anAssert.assertTrue(actual.contains(expected),"Bug found in adding product to wishlist");
        String color= Hook.webDriver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div")).getCssValue("background-color");
        anAssert.assertEquals(color,"rgba(75, 176, 122, 1)");
        System.out.println("Background color: "+color);
        anAssert.assertAll();
    }
    int valueInt;
    @And("user get Qty value and verify that it is <0")
    public void Qty_value() throws InterruptedException {
        Thread.sleep(3000);
        String valueString= p03HomePage.qtyValue().getText();
        valueString= valueString.replaceAll("[^0-9]","");
        valueInt = Integer.parseInt(valueString);
        System.out.println(valueInt);
    }
    @Then("no. of wishlist inc.")
    public void qtaNotEqual0(){
        anAssert.assertTrue(valueInt>0);
    }
}