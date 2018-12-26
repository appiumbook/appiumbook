package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.windows.PressesKeyCode;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 26/12/18
 */
public class IOSTricks extends BaseTest {
    @BeforeTest
    @Override
    public void setUpPage() throws MalformedURLException {
        iosDriver = new IOSDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForIOS());
    }

    public void changeDriverContextToWebView(AppiumDriver driver) {
        Set<String> contextHandles = driver.getContextHandles();
        for (String name: contextHandles) {
            if (name.equals("WEBVIEW"))
                driver.context(name);
        }
    }
}
