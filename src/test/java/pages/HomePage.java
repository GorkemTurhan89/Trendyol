package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[text()='Giriş Yap']//ancestor::div[1]")
    public WebElement homepageGirisYapButton;

    @FindBy(xpath = "//button/span[text()='Üye Ol']")
    public WebElement homepageUyeOlButton;

    @FindBy(css = "input#register-email")
    public WebElement registryPageEmailBox;

    @FindBy(css = "   input#register-password-input")
    public WebElement registryPagePasswordBox;

    @FindBy(css = ".marketing-checkbox .ty-bg-beige")
    public WebElement campaignAcknowlegmentConfimationCheck;

    @FindBy(css = ".personal-checkbox .ty-bg-beige")
    public WebElement personalDataSavedCheck;

    @FindBy(css = ".recaptcha-checkbox-border")
    public WebElement captchaHome;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement UyeOlButton;

}
