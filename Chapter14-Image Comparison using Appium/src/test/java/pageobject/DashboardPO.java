package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utils.AppiumUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;


/**
 * Year: 2018-19
 *
 * @author Prat3ik on 23/11/18
 */
public class DashboardPO extends BasePO {
    /**
     * A base constructor that sets the page's androidDriver
     * <p>
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     * <p>
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium androidDriver created in the beforesuite method.
     */
    public DashboardPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "etURL")
    AndroidElement urlTextView;

    public void typeInURL(String imageURL) {
        urlTextView.sendKeys(imageURL);
    }


    @AndroidFindBy(id = "button")
    AndroidElement submitButton;

    /**
     * This method will click on Logout textview.
     */
    public void tapOnSubmitButton() {
        submitButton.click();
    }

    public String getBase64FormatOfImageFromURL(String URL) throws IOException, URISyntaxException {
        URL url = new URL(URL);
        try {
            InputStream is = url.openStream();
            //Base64.getEncoder().encodeToString(Files.readAllBytes("tes".toPath()));

            byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(is);
            return org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            throw new RuntimeException("Please check the network on your server! It seems disconnected.");
        }
    }

}
