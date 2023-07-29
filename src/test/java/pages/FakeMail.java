package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FakeMail {
    public FakeMail() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "span#email.animace")
    public WebElement emailFakeMail;

    @FindBy(xpath = "//p/span[@id='hesloGen']")
    public WebElement passwordFakeMail;

    @FindBy(xpath = "(//tbody[@id='schranka' ]/tr)[1]")
    public WebElement lastEmail;

    @FindBy(css = "div#dismiss-button")
    public WebElement closeButton;

    @FindBy(xpath = "//a[@title='Delete this email address']")
    public WebElement deleteEmail;




}
