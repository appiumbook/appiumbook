package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 08/01/19
 * @project Android_Message_App_Appium
 */
public class NewConversationPO extends BasePO {
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
    protected NewConversationPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.google.android.apps.messaging:id/recipient_text_view")
    AndroidElement toTextField;

    public AndroidElement getToTextField() {
        return toTextField;
    }

    public ConversationPO typeAndSubmitContactNumber(String text) {
        getToTextField().sendKeys(text);
//        waitUtils.staticWait(3000);
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        return new ConversationPO(driver);
    }
}
