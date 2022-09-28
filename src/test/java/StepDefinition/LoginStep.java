package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginStep {
    WebDriver driver = null;
    LoginPage login ;
    @Given("user open browser")
    public void open_browser() throws InterruptedException {
        String path = System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);
        login = new LoginPage(driver);
        Thread.sleep(3000);

    }
    @And("user can navigate to login page")
    public void navigate(){
        driver.navigate().to("https://the-internet.herokuapp.com/login");

    }

//    @When("^user enter \"(.*)\" and \"(.*)\"$")
//    public void enter_valid_data(String username , String password) throws InterruptedException {
//        login.AllLoginSteps(username,password);
//     Thread.sleep(3000);
//    }
@When("user enter valid username and password")
public void enter_valid_data() throws InterruptedException {
    login.AllLoginSteps("tomsmith","SuperSecretPassword!");
    Thread.sleep(3000);
}
    @When("user enter invalid username and password")
    public void enter_invalid_data() throws InterruptedException {
        login.AllLoginSteps("tom","Super");
        Thread.sleep(3000);
    }

    @And("user click on login button")
    public void user_click_on_login_button() throws InterruptedException {
        login.passwordElement().sendKeys(Keys.ENTER);


    }

    @Then("user login successfully")
    public void user_login_successfully(){
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = login.getSuccessMessage().getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        Assert.assertEquals(actualMessage.contains(expectedMessage),true);
    }
    @Then("user Not login")
    public void Wrong_login(){
        String expectedMessage = "Your username is invalid!";
        String actualMessage = login.getSuccessMessage().getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        //Assert.assertEquals(actualMessage.contains(expectedMessage),true);
    }

    @And("user go to home page")
    public void user_can_navigate_to_home_page(){
        Assert.assertEquals("https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());


    }
    @After    // this tell driver to close browser after any failure happened
    public void close_browser(){
        driver.quit();
    }
    @After
    public void close1_browser(){
        driver.close();
    }


}
