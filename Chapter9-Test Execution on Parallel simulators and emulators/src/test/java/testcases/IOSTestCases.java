package testcases;

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
import java.net.URL;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 29/11/18
 * @project POM_Automation_Framework
 */
public class IOSTestCases {
    protected AppiumDriverLocalService service;
    public IOSDriver<IOSElement> driver;

    @Parameters({"wda", "deviceName", "port"})
    @BeforeTest
    public void setUp(long wda, String deviceName, String port) throws MalformedURLException {
        service = new AppiumServiceBuilder().usingPort(Integer.valueOf(port)).build();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium service node not started");
        }

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wda);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
        dc.setCapability(MobileCapabilityType.APP, "/Users/pratik/Downloads/FirstAutomationTest/src/test/resources/DemoApp-iPhoneSimulator.app");

        driver = new IOSDriver<IOSElement>(service.getUrl(), dc);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"sample"})
    public void sampleTestCase() {
        int a = 5;
        int b = 10;

        driver.findElement(By.id("IntegerA")).sendKeys(a + "");
        driver.findElement(By.id("IntegerB")).sendKeys(b + "");
        driver.findElement(By.id("ComputeSumButton")).click();
        String answer = driver.findElement(By.id("Answer")).getText();
        Assert.assertEquals(answer, a + b + "", "Expected and Actual Result didn't match!");
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
