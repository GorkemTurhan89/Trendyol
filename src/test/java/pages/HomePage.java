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

    @FindBy(xpath = "//p[text()='Giriş Yap']")
    public WebElement homepageGirisYapButton;

    @FindBy(xpath = "//button/span[text()='Üye Ol']")
    public WebElement homepageUyeOlButton;

    @FindBy(css = "input#register-email")
    public WebDriver registryPageEmailBox;

    @FindBy(css = "   input#register-password-input")
    public WebDriver registryPagePasswordBox;

}
