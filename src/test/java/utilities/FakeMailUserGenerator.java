package utilities;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.FakeMail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FakeMailUserGenerator {
    static FakeMail fakeMail;
    static Map<String, String> fakeMailInfos = new HashMap<>();

    static String windowHandleTrendyol;
    static String handle;

    public static void main(String[] args) {
        fakeMail = new FakeMail();
        //1.Go to Url
        Driver.getDriver().get("https://www.fakemail.net/");

        //2.Renew the mail adress
        fakeMail.deleteEmail.click();
        //3.close the adds
        Driver.getDriver().navigate().refresh();
        if (fakeMail.closeButton.isEnabled()) {
            fakeMail.closeButton.click();
        }
        //4. get email and password
        String fakemailEmail = fakeMail.emailFakeMail.getText();
        String fakemailPassword = fakeMail.passwordFakeMail.getText();
        fakeMailInfos.put("fakemailEmail", fakemailEmail);
        fakeMailInfos.put("fakemailPassword", fakemailPassword);
        //5.get handle and switch to case prime --Trendyol--
        handle = Driver.getDriver().getWindowHandle();

        Set<String> handlesofWindows = Driver.getDriver().getWindowHandles();
        for (String w : handlesofWindows) {
            if (!w.equalsIgnoreCase(handle)) {
                windowHandleTrendyol = w;
            }
        }

        Driver.getDriver().switchTo().window(windowHandleTrendyol);

    }

    public void getLastMail() {
        //get back to fakemail site
        Driver.getDriver().switchTo().window(handle);
        Driver.getDriver().get("https://www.fakemail.net/");
        //go to last email
        fakeMail.lastEmail.click();
        //get the text of the code
          //TODO get text
        // switch to again trendyol
        Driver.getDriver().switchTo().window(windowHandleTrendyol);

    }


    public int getRowCount() {

        List rows = Driver.getDriver().findElements(By.xpath("//div[@id='schranka']/tbody/tr"));
        return rows.size();
    }
}
