package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.DashboardPO;
import utils.AppiumUtils;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 23/11/18
 */
public class AndroidTest extends BaseTest {

    @Test(description = "Please set application name as: imageApp.apk")
    public void verifyImageIsBeingAppearedCorrectlyFromURLOnApp() throws IOException, URISyntaxException {
        String imageURL = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6009/6009665_sd.jpg;maxHeight=640;maxWidth=550";

        DashboardPO dashboardPO = new DashboardPO(androidDriver);
        dashboardPO.typeInURL(imageURL);
        dashboardPO.tapOnSubmitButton();

        String base64FormatOfImageFromURL = dashboardPO.getBase64FormatOfImageFromURL(imageURL);
        waitUtils.staticWait(5000);
        Assert.assertTrue(AppiumUtils.isElementDisplayed((AndroidElement) androidDriver.findElementByImage(base64FormatOfImageFromURL)), "Expected Image is not appear on app!");
    }


    @BeforeTest
    @Override
    public void setUpPage() throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }
}
