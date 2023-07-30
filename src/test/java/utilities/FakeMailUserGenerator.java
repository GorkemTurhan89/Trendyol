package utilities;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import pages.FakeMail;

import java.util.*;

public class FakeMailUserGenerator {
    static FakeMail fakeMail;
    public static Map<String, String> fakeMailInfos = new HashMap<>();

    static String windowHandleFakemail;
    static String handle;

    public static void getMailInfo () {
        fakeMail = new FakeMail();
        handle = Driver.getDriver().getWindowHandle();
        //1.Go to Url
        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        Driver.getDriver().get("https://www.fakemail.net/");
        windowHandleFakemail =Driver.getDriver().getWindowHandle();
        /*List <String> tumWindowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        for (String w : tumWindowList) {
            if (!w.equalsIgnoreCase(handle)) {
                windowHandleFakemail = w;
            }*/
 // Driver.getDriver().switchTo().window(windowHandleFakemail);


        //2.Renew the mail adress
       // fakeMail.deleteEmail.click();  Driver.getDriver().navigate().refresh();

        //3.close the adds
       /* try {if(fakeMail.closeButton.isEnabled()){fakeMail.closeButton.click();}
        }
        catch(Exception e) {

        }*/



        //4. get email and password

        String fakemailEmail = fakeMail.emailFakeMail.getText();
        System.out.println(fakemailEmail);
        String fakemailPassword = fakeMail.passwordFakeMail.getText();
        System.out.println(fakemailPassword);
        fakeMailInfos.put("fakemailEmail", fakemailEmail);//added to hashmap
        fakeMailInfos.put("fakemailPassword", fakemailPassword);//added to hashmap
        //5.get handle and switch to case prime --Trendyol--

            Driver.getDriver().switchTo().window(handle);

        }





    public static void getLastMail() {
        //get back to fakemail site
        Driver.getDriver().switchTo().window(windowHandleFakemail);
        Driver.getDriver().get("https://www.fakemail.net/");
        //go to last email
        fakeMail.lastEmail.click();
        //get the text of the code
       String mailCode=fakeMail.subjectRowOfLastFakeMail.getText().split(":")[1].trim();
        System.out.println(mailCode);
        // switch to again trendyol
        Driver.getDriver().switchTo().window(handle);
        fakeMailInfos.put("mailCode",mailCode);

    }

    public int getRowCount() {

        List rows = Driver.getDriver().findElements(By.xpath("//div[@id='schranka']/tbody/tr"));
        return rows.size();
    }
}
