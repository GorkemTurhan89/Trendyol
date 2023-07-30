package stepdefinitions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;



public class Deneme {
    @Test
    public void deneme(){
        Driver.getDriver().get("https://www.trendyol.com/uyelik?cb=https%3A%2F%2Fwww.trendyol.com%2F");
       int number=250;
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js1.executeScript("window.scrollBy(0,"+number+")", "");
        Driver.getDriver().switchTo().frame(0);


        WebElement element = Driver.getDriver().findElement(By.cssSelector("#recaptcha-accessible-status.rc-anchor-aria-status"));

                JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",element );
        System.out.println(element.getText());
    }
}
