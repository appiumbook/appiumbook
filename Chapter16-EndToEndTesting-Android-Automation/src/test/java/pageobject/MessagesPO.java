package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 08/01/19
 * @project Android_Message_App_Appium
 */
public class MessagesPO extends BasePO {

    @AndroidFindBy(id = "com.google.android.apps.messaging:id/start_new_conversation_button")
    AndroidElement startNewConversationButton;

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
    public MessagesPO(AppiumDriver driver) {
        super(driver);
    }

    public NewConversationPO clickOnStartNewConversationButton() {
        startNewConversationButton.click();
        return new NewConversationPO(driver);
    }


}
