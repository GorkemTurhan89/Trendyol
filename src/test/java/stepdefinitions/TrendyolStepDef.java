package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.Driver;

import static utilities.FakeMailUserGenerator.fakeMailInfos;
import static utilities.FakeMailUserGenerator.getMailInfo;

public class TrendyolStepDef {

    HomePage homePage;


    @Given("User goes to the <{string}>")
    public void user_goes_to_the(String url) {
        Driver.getDriver().get(url);
        Driver.getDriver().navigate().refresh();
    }

    @Given("User clicks to <{string}>")
    public void user_clicks_to(String clickToWhat) {
        homePage = new HomePage();
        switch (clickToWhat) {
            case "Giriş Yap":
                homePage.homepageGirisYapButton.click();
                break;
            case "Üye Ol":
                homePage.homepageUyeOlButton.click();
                break;
            case "campaignAcknowlegmentConfimationCheck":
                jsclickElement(homePage.campaignAcknowlegmentConfimationCheck);
                break;
            case "personalDataSavedCheck":
                jsclickElement(  homePage.personalDataSavedCheck);
                break;
            case "captchaHome":
                scrollJSDown(1);

                System.out.println("working");
                Driver.getDriver().switchTo().frame(0);
                System.out.println("*****");
                jsclickElement(homePage.captchaHome);
                System.out.println("*****");
               Driver.getDriver().switchTo().parentFrame();
                break;
            case "Üye Ol Submit":
                homePage.UyeOlButton.click();
                break;
        }
    }



    @Given("User enters fakeMail<{string}>")
    public void user_enters_fake_mail(String whatToGetAndEnter) {

        switch (whatToGetAndEnter) {
            case "mail":
                getMailInfo();
                String email = fakeMailInfos.get("fakemailEmail");
                homePage.registryPageEmailBox.sendKeys(email);

                case "password":
                String password = fakeMailInfos.get("fakemailPassword");
                homePage.registryPagePasswordBox.sendKeys(password);
        }
    }

    private void jsclickElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",element  );
    }
    private void scrollJSDown(int num){
        int number =250*num;
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,"+number+")", "");
    }
}
