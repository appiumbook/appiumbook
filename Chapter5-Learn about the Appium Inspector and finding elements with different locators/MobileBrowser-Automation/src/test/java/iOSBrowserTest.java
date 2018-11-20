import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class iOSBrowserTest {
    public IOSDriver<IOSElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String appiumServerURL = "http://127.0.0.1:4723/wd/hub";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");

        driver = new IOSDriver<IOSElement>(new URL(appiumServerURL), dc);
    }

    @Test
    public void verifyValidUserCanLoginToFaceBook() throws InterruptedException {
        String username = ""; // Enter your valid facebook username
        String password = ""; // Enter your valid facebook password

        driver.get("https://m.facebook.com/");
        driver.findElement(By.id("m_login_email")).sendKeys(username);
        driver.findElement(By.id("m_login_password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }
}
