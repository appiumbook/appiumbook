package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.imagecomparison.OccurrenceMatchingOptions;
import io.appium.java_client.imagecomparison.OccurrenceMatchingResult;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ImageUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 16/01/19
 * @project Image Comparision Appium
 */
public class ImageButtonTest extends BaseTest {
    @BeforeTest
    @Override
    public void setUpPage() throws IOException {
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }

    @Test(description = "Please set application name as: image-button.apk")
    public void verifyUserCanClickOnImageButtonUsingImageLocatorStrategy() throws IOException, URISyntaxException {
        String imageName = "icon1.png";
        String expectedText = "First Icon clicked!";
        String base64FormatOfImageFromImage = ImageUtils.getBase64StringFormatOfImage(imageName);
        WebElement iconButton = androidDriver.findElementByImage(base64FormatOfImageFromImage);
        iconButton.click();

        String actualText = androidDriver.findElement(By.id("com.example.pratik.myapp23:id/textView")).getText();
        Assert.assertEquals(expectedText, actualText, "Actual and Expected Text didn't match!");
    }
}
