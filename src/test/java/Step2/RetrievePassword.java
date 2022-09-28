package Step2;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetrievePassword {
    WebDriver driver= null;

    @Given("user open browser and navigate to forgot page to enter email")
    public void br_email() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/forgot_password");

    }

    @And("user move to forget")
    public void move_to_login(){
     WebElement element= driver.findElement(By.id("tau@f.com"));
     element.sendKeys("dygdjh");
     element.sendKeys(Keys.ENTER);


    }


    @Then("user click on retrieve button")
    public void retrieve_click(){
        WebElement element1 = driver.findElement(By.tagName("h1"));
        String expectedMsg= "Internal Server Error";
        String actMessage= element1.getText();
        Assert.assertTrue(actMessage.contains(expectedMsg));
    }

}
