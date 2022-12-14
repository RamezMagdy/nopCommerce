package org.example.pages;

import org.example.stepDefs.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_LoginPart {
    public WebElement loginlink(){
        return Hook.webDriver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }
    public WebElement emailLoginPOM(WebDriver driver){
        return Hook.webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[1]/input"));
    }
    public WebElement passwordLoginPOM(WebDriver driver){
        return Hook.webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[2]/input"));
    }
    public void loginData(WebDriver driver, String email, String pass){
        emailLoginPOM(driver).clear();
        emailLoginPOM(driver).sendKeys(email);
        passwordLoginPOM(driver).clear();
        passwordLoginPOM(driver).sendKeys(pass);
    }
    public By loginBtn(){
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
    }
    public By tab(){
        return By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    }
    public By failedMSG(){
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");
    }

}