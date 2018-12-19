import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 19/12/18
 * @project Singleton Pattern
 */
public class IOSTestCase {

    @Test
    public void sampleTestCase1() throws MalformedURLException {
        int a = 9;
        int b = 1;

        SingletonAppiumDriver singletonAppiumDriver = SingletonAppiumDriver.getSingletonAppiumDriver();
        AppiumDriver driver = singletonAppiumDriver.getAppiumDriver();

        driver.findElement(By.id("IntegerA")).sendKeys(a + "");
        driver.findElement(By.id("IntegerB")).sendKeys(b + "");
        driver.findElement(By.id("ComputeSumButton")).click();
        String answer = driver.findElement(By.id("Answer")).getText();
        Assert.assertEquals(answer, a + b + "", "Expected and Actual Result didn't match!");
    }

    @Test
    public void sampleTestCase2() throws MalformedURLException {
        int a = 1;
        int b = 1;

        SingletonAppiumDriver singletonAppiumDriver = SingletonAppiumDriver.getSingletonAppiumDriver();
        AppiumDriver driver = singletonAppiumDriver.getAppiumDriver();

        driver.findElement(By.id("IntegerA")).sendKeys(a + "");
        driver.findElement(By.id("IntegerB")).sendKeys(b + "");
        driver.findElement(By.id("ComputeSumButton")).click();
        String answer = driver.findElement(By.id("Answer")).getText();
        Assert.assertEquals(answer, a + b + "", "Expected and Actual Result didn't match!");
    }
}
