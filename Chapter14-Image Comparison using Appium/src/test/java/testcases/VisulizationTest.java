package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.imagecomparison.OccurrenceMatchingOptions;
import io.appium.java_client.imagecomparison.OccurrenceMatchingResult;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ImageUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 17/01/19
 * @project Image Comparision Appium
 */
public class VisulizationTest extends BaseTest{
    @BeforeTest
    @Override
    public void setUpPage() throws IOException {
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }

    @Test
    public void testVisulization() throws IOException, URISyntaxException {
        byte[] fullImage = Base64.encodeBase64(ImageUtils.getBase64ByteFormatOfImage("abstractFullImage.jpg"));
        byte[] partialImage = Base64.encodeBase64(ImageUtils.getBase64ByteFormatOfImage("abstractPartialImage.png"));

        OccurrenceMatchingResult imageOccurrence = androidDriver.findImageOccurrence(fullImage, partialImage, new OccurrenceMatchingOptions()
                .withThreshold(0.1).withEnabledVisualization());

        System.out.println(imageOccurrence.getRect().getDimension());
        System.out.println("X:"+imageOccurrence.getRect().getX());
        System.out.println("Y:"+imageOccurrence.getRect().getY());
        System.out.println("Height:"+imageOccurrence.getRect().getHeight());
        System.out.println("Width:"+imageOccurrence.getRect().getWidth());
        System.out.println(imageOccurrence.getVisualization().length);
        Assert.assertTrue(imageOccurrence.getVisualization().length > 0 , "Partial image is not present!");
    }
}
