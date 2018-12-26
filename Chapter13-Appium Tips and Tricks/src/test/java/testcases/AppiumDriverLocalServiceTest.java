package testcases;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 26/12/18
 */
public class AppiumDriverLocalServiceTest extends BaseTest {
    AppiumDriverLocalService appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();

    @BeforeTest
    @Override
    public void setUpPage() throws IOException {
        AppiumDriverLocalService appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
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
}
