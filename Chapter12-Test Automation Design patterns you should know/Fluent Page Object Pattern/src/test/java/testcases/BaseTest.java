package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.PropertyUtils;
import utils.ScreenshotUtility;
import utils.WaitUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Year: 2018-19
 * An abstract base for all of the Android tests within this package
 * Responsible for setting up the Appium test Driver
 *
 * @author Prat3ik on 22/11/18
 * @project POM_Automation_Framework
 */

@Listeners({ScreenshotUtility.class})
public abstract class BaseTest {
    /**
     * As driver static it will be created only once and used across all of the test classes.
     */
    public static AppiumDriver driver;
    public final static String APPIUM_SERVER_URL = PropertyUtils.getProperty("appium.server.url", "http://127.0.0.1:4723/wd/hub");
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
    public static WaitUtils waitUtils = new WaitUtils();


    /**
     * This method will run at the time of Test Suite creatopn so it will run at once through out the execution
     * <p>
     * Appium is a client - server model:
     * So we need to set up appium client in order to connect to Device Farm's appium server.
     */
    @BeforeMethod
    public void setUpAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        setDesiredCapabilitiesForAndroid(capabilities);
        driver = new AppiumDriver(new URL(APPIUM_SERVER_URL), capabilities);
    }

    /**
     * This method will be called everytime before your test runs
     */
    @BeforeTest
    public abstract void setUpPage();


    /**
     * This method will always execute after each test case, This will quit the WebDriver instance called at the last
     */
    @AfterMethod(alwaysRun = true)
    public void afterMethod(final ITestResult result) throws IOException {
        String fileName = result.getTestClass().getName() + "_" + result.getName();
        System.out.println("Test Case: [" + fileName + "] executed..!");
    }

    /**
     * This method will be called after class finishes the execution of all tests
     */
    @AfterClass
    public void afterClass() {
    }

    /**
     * At the end of the Test Suite(At last) this method would be called
     */
    @AfterSuite
    public void tearDownAppium() {
        quitDriver();
    }

    /**
     * It will set the DesiredCapabilities for the local execution
     *
     * @param desiredCapabilities
     */
    private void setDesiredCapabilitiesForAndroid(DesiredCapabilities desiredCapabilities) {
        String PLATFORM_NAME = PropertyUtils.getProperty("android.platform");
        String PLATFORM_VERSION = PropertyUtils.getProperty("android.platform.version");
        String APP_NAME = PropertyUtils.getProperty("android.app.name");
        String APP_RELATIVE_PATH = PropertyUtils.getProperty("android.app.location") + APP_NAME;
        String APP_PATH = getAbsolutePath(APP_RELATIVE_PATH);
        String DEVICE_NAME = PropertyUtils.getProperty("android.device.name");
        String APP_PACKAGE_NAME = PropertyUtils.getProperty("android.app.packageName");
        String APP_ACTIVITY_NAME = PropertyUtils.getProperty("android.app.activityName");
        String APP_FULL_RESET = PropertyUtils.getProperty("android.app.full.reset");
        String APP_NO_RESET = PropertyUtils.getProperty("android.app.no.reset");

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, APP_FULL_RESET);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, APP_NO_RESET);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
    }

    public static WebDriver getScreenshotableWebDriver() {
        final WebDriver augmentedDriver = new Augmenter().augment(driver);
        return augmentedDriver;
    }

    /**
     * This will set implicit wait
     *
     * @param driver
     */
    private static void setTimeOuts(AppiumDriver driver) {
        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    private static String getAbsolutePath(String appRelativePath) {
        File file = new File(appRelativePath);
        return file.getAbsolutePath();
    }

    /**
     * This will quite the android driver instance
     */
    private void quitDriver() {
        try {
            this.driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}