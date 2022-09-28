package Step2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetrieveFunctions {
    WebDriver driver;
    RetrieveFunctions(WebDriver driver){
        this.driver= driver;
    }
//    @FindBy(id = "form_submit")
//    WebElement emailElement;
    @FindBy(tagName = "h1")
    WebElement msg;
    public WebElement enterEmail(){
        By emailEl = By.id("form_submit");
       driver.findElement(By.id("form_submit")).sendKeys("a@g.com");
       WebElement element = driver.findElement(emailEl);

       return element;
    }
    public void click_retrieve(){
        enterEmail().sendKeys("tau@f.com");
        enterEmail().sendKeys(Keys.ENTER);

       // element.sendKeys(Keys.ENTER);
    }

    public String getMsg(){
      return   msg.getText();

    }
}
