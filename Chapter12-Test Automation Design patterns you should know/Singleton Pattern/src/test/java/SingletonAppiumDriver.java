import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 19/12/18
 * @project Singleton Pattern
 */
public class SingletonAppiumDriver {

    public static SingletonAppiumDriver singletonAppiumDriver;
    private AppiumDriver appiumDriver;

    private SingletonAppiumDriver() throws MalformedURLException {
        appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), getDesiredCapabilitiesForIOS());
    }

    /**
     * It will set the DesiredCapabilities for the local execution
     */
    private DesiredCapabilities getDesiredCapabilitiesForIOS() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Volumes/Disk2/AppiumBook/Chapter12-Test Automation Design patterns you should know/Singleton Pattern/src/test/resources/DemoApp.app");
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        return desiredCapabilities;
    }

    public static SingletonAppiumDriver getSingletonAppiumDriver() throws MalformedURLException {
        if (singletonAppiumDriver == null)
            singletonAppiumDriver = new SingletonAppiumDriver();
        return singletonAppiumDriver;
    }

    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

}
