package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.DashboardPO;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 23/11/18
 */
public class AndroidTest extends BaseTest {

    @Test
    public void verifyImageIsBeingAppearedCorrectlyFromURLOnApp() {
        String imageURL = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6009/6009665_sd.jpg;maxHeight=640;maxWidth=550";

        DashboardPO dashboardPO = new DashboardPO(androidDriver);
        dashboardPO.typeInURL(imageURL);
        dashboardPO.tapOnSubmitButton();

        waitUtils.staticWait(5000);
    }



    @BeforeTest
    @Override
    public void setUpPage() throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }
}
