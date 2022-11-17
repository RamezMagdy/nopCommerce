package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_FollowUsStepDefs {
    WebDriver driver;
    P03_HomePage p03HomePage =new P03_HomePage();

    @When("user opens facebook link")
    public void facebook_link(){
        p03HomePage.facbookLink().click();
    }
    @Then("Facebook URL is opened in new tab")
    public void facebook_tab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(Hook.webDriver.getWindowHandles());
        Hook.webDriver.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hook.webDriver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
        Hook.webDriver.close();
        Hook.webDriver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
    }
    @When("user opens twitter link")
    public void twitterlink() throws InterruptedException {
        p03HomePage.twitterLink().click();
    }
    @Then("Twitter URL is opened in new tab")
    public void twitter_tab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(Hook.webDriver.getWindowHandles());
        Hook.webDriver.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hook.webDriver.getCurrentUrl(), "https://twitter.com/nopCommerce");
        Hook.webDriver.close();
        Hook.webDriver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
    }
    @When("user opens rss link")
    public void rss_link(){
        p03HomePage.rssLink().click();
    }
    @Then("RSS URL is opened in new tab")
    public void rss_tab() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(Hook.webDriver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open","Bug found ");
        Thread.sleep(3000);
    }
    @When("user opens youtube link")
    public void youtube_link(){
        p03HomePage.youtubeLink().click();
    }
    @Then("YouTube URL is opened in new tab")
    public void youtube_tab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(Hook.webDriver.getWindowHandles());
        Hook.webDriver.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hook.webDriver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce");
        Hook.webDriver.close();
        Hook.webDriver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
    }
}