import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class iOSSampleTest {
    public IOSDriver<IOSElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String appiumServerURL = "http://127.0.0.1:4723/wd/hub";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "iOS");
        dc.setCapability("platformVersion", "11.4");
        dc.setCapability("app", "/Users/pratik/Downloads/FirstAutomationTest/src/test/resources/DemoApp-iPhoneSimulator.app");
        dc.setCapability("deviceName", "iPhone X");
//        dc.setCapability("noReset", true);
//        dc.setCapability("fullReset", true);

        driver = new IOSDriver<IOSElement>(new URL(appiumServerURL), dc);
    }

    @Test
    public void secondTest() throws InterruptedException {
        int a = 5;
        int b = 10;

        driver.findElementByName("");
        driver.findElement(By.id("TextField1")).sendKeys(a + "");
        driver.findElement(By.id("IntegerB")).sendKeys(b + "");
        driver.findElement(By.id("ComputeSumButton")).click();
        String answer = driver.findElement(By.id("Answer")).getText();
        Assert.assertEquals(answer, a + b + "", "Expected and Actual Result didn't match!");
    }
}
