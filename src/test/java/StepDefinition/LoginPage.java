package StepDefinition;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver = null ;
    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    public WebElement userNameElement(){
        By username = By.id("username");
        WebElement usernameElement= driver.findElement(username);
        return usernameElement;
    }
    public WebElement passwordElement(){
        By password = By.id("password");
        WebElement passwordElement= driver.findElement(password);
        return passwordElement;
    }
    public WebElement getFailedMessage(){
        return  driver.findElement(By.id("flash"));

    }
    public WebElement getSuccessMessage(){
        return driver.findElement(By.id("flash"));
    }
    public WebElement isDisplayed(){
        return driver.findElement(By.className("button"));
    }
    public void AllLoginSteps(String username , String password){
        userNameElement().clear();
        userNameElement().sendKeys(username);
        passwordElement().sendKeys(password);



    }

}
