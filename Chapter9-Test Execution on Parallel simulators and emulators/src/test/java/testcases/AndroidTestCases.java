package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 29/11/18
 * @project POM_Automation_Framework
 */
public class AndroidTestCases {
    protected AppiumDriverLocalService service;
    public AndroidDriver<AndroidElement> driver;

    @Parameters({"platformVersion", "deviceName", "port"})
    @BeforeTest
    public void setUp(String platformVersion, String deviceName, String port) throws MalformedURLException {
        service = new AppiumServiceBuilder().usingPort(Integer.valueOf(port)).build();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium service node not started");
        }

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        dc.setCapability(MobileCapabilityType.APP, "/Users/pratik/Downloads/FirstAutomationTest/src/test/resources/DemoApp.apk");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver<AndroidElement>(service.getUrl(), dc);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"sample"})
    public void sampleTestCase() {
        driver.findElementByAccessibilityId(("Login Screen")).click();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null)
            service.stop();
    }
}
