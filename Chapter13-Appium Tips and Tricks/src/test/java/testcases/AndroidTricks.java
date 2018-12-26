package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 23/11/18
 */
public class AndroidTricks extends BaseTest {

    @Test
    public void getTextContentsFromNotifications() {
        androidDriver.openNotifications();

        List<AndroidElement> titleElement = androidDriver.findElements(By.id("android:id/title"));
        List<AndroidElement> contentElement = androidDriver.findElements(By.id("android:id/text"));

        for (int i = 0; i < titleElement.size(); i++) {
            System.out.println(titleElement.get(i).getText() + " : " + contentElement.get(i).getText());
        }
    }

    @Test
    public void androidScreenVideoRecording() {
        try {
            androidDriver.startRecordingScreen(new AndroidStartScreenRecordingOptions().withTimeLimit(Duration.ofSeconds(5)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitUtils.staticWait(7000);
        String s = androidDriver.stopRecordingScreen();

        System.out.println(s);
    }



    @BeforeTest
    @Override
    public void setUpPage() throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }
}
