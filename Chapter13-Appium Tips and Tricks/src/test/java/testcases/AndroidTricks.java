package testcases;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.DashboardPO;
import pageobject.LoginPO;

import java.util.List;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 23/11/18
 * @project POM_Automation_Framework
 */
public class AndroidTricks extends BaseTest {

    @Test
    public void getTextContentsFromNotifications() {
        driver.openNotifications();

        List<AndroidElement> titleElement = driver.findElements(By.id("android:id/title"));
        List<AndroidElement> contentElement = driver.findElements(By.id("android:id/text"));

        for (int i = 0; i < titleElement.size(); i++) {
            System.out.println(titleElement.get(i).getText() + " : " + contentElement.get(i).getText());
        }

    }

    @BeforeTest
    @Override
    public void setUpPage() {
    }
}
