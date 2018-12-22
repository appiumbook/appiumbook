package testcases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 22/12/18
 * @project POM_Automation_Framework
 */
public class AndroidADBCommands {

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
}
