package Appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public class UiSelectorPractise extends Base {

    /*
API Demeos
Preference
fragment
check  checkbox preference if not checked
check Child checkbox preference if it is enabled
if it is not enabled check Parent checkbox preference  first
then checked Child checkbox preference
verify it is checked.
 */


    @Test
     public void Test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = lunchAndroid();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='7. Fragment']").click();
        List<WebElement> checkBox = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checked(false)");
        if(checkBox.size()>0){
            checkBox.get(0).click();
        }
        WebElement checkBox2 = driver.findElementByXPath("(//android.widget.CheckBox)[2]");
        WebElement checkBox3 = driver.findElementByXPath("(//android.widget.CheckBox)[3]");
//ucuncu check box ulasilir olup olmadigini kontrol et
        List<WebElement>  checkBox3Enabled = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").index(2).enabled(false)");
//eger ulasilabilir degilse o zaman ulasilabilir olmasi icin checkbox 2 tikla
        if (checkBox3Enabled.size() == 0) {
            checkBox2.click();
        }
//checkbox 3 yikla
        checkBox3.click();
//checkbox 3 etkinlestirildigini onayla
        Assert.assertEquals("true",checkBox3.getAttribute("checked"));
    }
}

