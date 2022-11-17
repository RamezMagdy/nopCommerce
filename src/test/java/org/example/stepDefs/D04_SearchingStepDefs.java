package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_SearchingStepDefs {
    P03_HomePage p03HomePage =new P03_HomePage();
    SoftAssert anAssert =new SoftAssert();

    @When("user click on search field")
    public void search_field(){
        p03HomePage.searchField.click();
    }
    @And("^user search with \"([^\"]*)\"$")
    public void product_name_search(String text){
        p03HomePage.searchField.sendKeys(text);
        p03HomePage.searchField.sendKeys(Keys.ENTER);
    }
    @Then("^user could find \"([^\"]*)\"$")
    public void product_name_result(String word){
        String text=null;
        for (int i = 0; i< p03HomePage.productData().size(); i++){
            text= p03HomePage.productData().get(i).getText().toLowerCase();
        }
        anAssert.assertTrue(text.contains(word));
        String expected="https://demo.nopcommerce.com/search?q=";
        String actual= Hook.webDriver.getCurrentUrl();
        anAssert.assertTrue(actual.contains(expected));
        anAssert.assertAll();
    }
    @Then("^user could find \"([^\"]*)\" in product details$")
    public void product_sku_result(String serial){
        p03HomePage.selectProduct().click();
        String productSerial= p03HomePage.product_serial().getText();
        Assert.assertTrue(serial.contains(productSerial));
    }
}