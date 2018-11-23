package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.HomeScreenPO;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 23/11/18
 * @project POM_Automation_Framework
 */
public class TestCases extends BaseTest{

    @Test
    public void test() {
        HomeScreenPO homeScreenPO = new HomeScreenPO(driver);
        homeScreenPO.tapOnLoginScreenTextView();
    }

    @BeforeTest
    @Override
    public void setUpPage() {

    }
}
