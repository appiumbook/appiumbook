package facade;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pageobject.DashboardPO;
import pageobject.LoginPO;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 18/12/18
 * @project POM_Automation_Framework
 */
public class LoginFacade {

    private AppiumDriver driver;
    private LoginPO loginPO;
    private DashboardPO dashboardPO;


    public LoginFacade(AppiumDriver driver) {
        this.driver = driver;
    }

    public LoginPO getLoginPO() {
        if (loginPO == null) {
            loginPO = new LoginPO(driver);
            return loginPO;
        } else
            return loginPO;
    }


    public DashboardPO getDashboardPO() {
        if (dashboardPO == null) {
            dashboardPO = new DashboardPO(driver);
            return dashboardPO;
        } else
            return dashboardPO;
    }


    public void loginAndLogout(String username, String password) {
        getLoginPO().setUsernameTextField(username);
        getLoginPO().setPasswordTextField(password);
        getLoginPO().tapOnLoginButton();
        getDashboardPO().tapOnLogoutTextView();
    }
}
