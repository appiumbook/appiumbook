package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AssertUtils;

import java.util.List;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 08/01/19
 * @project Android_Message_App_Appium
 */
public class ConversationPO extends BasePO {
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
    protected ConversationPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.google.android.apps.messaging:id/compose_message_text")
    AndroidElement smsTextField;

    public void typeInSMSTextField(String text) {
        smsTextField.sendKeys(text);
    }

    @AndroidFindBy(id = "com.google.android.apps.messaging:id/send_message_button_container")
    AndroidElement smsButton;

    public void tapOnSMSButton() {
        smsButton.click();
    }

    @AndroidFindBy(id = "com.google.android.apps.messaging:id/tombstone_message")
    AndroidElement conversationWithMobileNumberTextView;

    public boolean isConversationScreenDisplayed() {
        return smsTextField.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.FrameLayout")
    List<AndroidElement> sentMessageLayout;

    public AndroidElement getLastSentMessage(){
        return sentMessageLayout.get(sentMessageLayout.size() - 1);
    }

    public String getLastSentMessageText(){
        return getLastSentMessage().getAttribute("name");
    }

    public boolean isMessageSent() {
        return AssertUtils.isElementDisplayed(getLastSentMessage());
    }

    public boolean isLastSentMessageContains(String text) {
        return getLastSentMessageText().contains(text);
    }
}
