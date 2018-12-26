package testcases;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 26/12/18
 * @project POM_Automation_Framework
 */
public class AppiumServiceBuilderTest extends BaseTest {

    AppiumServiceBuilder builder;
    AppiumDriverLocalService appiumDriverLocalService;

    @BeforeTest
    @Override
    public void setUpPage() throws IOException {
        DesiredCapabilities desiredCapabilities = getDesiredCapabilities();
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4729);
        builder.withCapabilities(desiredCapabilities);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        appiumDriverLocalService = AppiumDriverLocalService.buildService(builder);
        appiumDriverLocalService.start();
    }

    @Test
    public void test1() {
        System.out.println("Test-1");
    }

    @Test
    public void test2() {
        System.out.println("Test-2");
    }

    @AfterSuite
    @Override
    public void tearDownAppium() {
        super.tearDownAppium();
        appiumDriverLocalService.stop();
    }

    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        return desiredCapabilities;
    }
}
