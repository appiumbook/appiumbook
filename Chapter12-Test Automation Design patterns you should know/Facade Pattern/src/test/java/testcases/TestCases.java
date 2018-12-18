package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import facade.LoginFacade;
import pageobject.LoginPO;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 23/11/18
 * @project POM_Automation_Framework
 */
public class TestCases extends BaseTest {

    @Test
    public void testUserCanLoginAndLogout() {
        String username = "pratik";
        String password = "test123";

        LoginFacade loginFacade = new LoginFacade(driver);
        loginFacade.loginAndLogout(username, password);

        Assert.assertTrue(new LoginPO(driver).isLoginPageDisplayed(), "Login Page did not appear after logout");
    }

    @BeforeTest
    @Override
    public void setUpPage() {

    }
}
