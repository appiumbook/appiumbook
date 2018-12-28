package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


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

}
