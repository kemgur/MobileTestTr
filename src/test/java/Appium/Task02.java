package Appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;

public class Task02 extends Base{
    /*
    Task 2 : bu ikisini yarin derse kadar yapip kanalda kodlari paylasalim
on sart (api demos telefonda ac)
apidemos tikla
prefrences tikla
preferences from code tikla
checkbox preference tikla
switch preference tikla
Edit preference tikla
yazi kutusuna "text" yaz ok tikla
list preference tikla  option3 sec
6:34
test senaryosunu anlamak icin aplikasyonda adimlari manual olarak takip edip kodlarinizi yazin
     */
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = lunchAndroid();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"5. Preferences from code\"]").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
                "FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget." +
                "LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget." +
                "RelativeLayout/android.widget.TextView[1]").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android." +
                "widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget." +
                "LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget." +
                "RelativeLayout/android.widget.TextView[1]").click();
        WebElement edit = driver.findElementById("android:id/edit");
        edit.click();
        edit.sendKeys("test");
        driver.findElementById("android:id/button1").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='List preference']").click();
        driver.findElementByXPath("//*[@text='Charlie Option 03']").click();
        driver.quit();

    }
}
