package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 17/12/18
 * @project appiumbook
 */
public class DriverFactory {

    public AppiumDriver getDriver(String platformType) throws MalformedURLException {
        if (platformType == "Android") {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "John's iPhone");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/abc/projectA/src/test/resources/sampleApp.ipa");
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } else if (platformType == "iOS") {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "John's iPhone");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/abc/projectA/src/test/resources/sampleApp.ipa");
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            return new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } else
            return null;
    }

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = new DriverFactory().getDriver("Android");
        driver.findElement(By.id("username")).sendKeys("john");
        driver.findElement(By.id("password")).sendKeys("abc123");
        driver.findElement(By.id("login")).click();
        MobileElement profileIcon = (MobileElement) driver.findElement(By.id("profileIcon"));
        Assert.assertTrue(profileIcon.isDisplayed(), "Login did not successful.");
    }
}
