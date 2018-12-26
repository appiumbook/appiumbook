package testcases;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 22/12/18
 */
public class AndroidADBCommands extends BaseTest{

    public void checkWhichAndroidDevicesAreConnected() throws IOException {
        String line;
        Process p = Runtime.getRuntime().exec("adb shell pm list packages");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        input.close();
    }

    public void enablePointLocation() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("adb", "shell", "settings", "put", "system", "pointer_location", "1");
        Process pc = pb.start();
        pc.waitFor();
        System.out.println("Finish!");
    }

    @BeforeTest
    @Override
    public void setUpPage() throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }
}
