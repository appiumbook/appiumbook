/*
 * (C) Copyright 2018 by Pratik Patel (https://github.com/prat3ik/)
 */
package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidMessageAppPO extends BasePO {

    @AndroidFindBy(id = "next")
    AndroidElement nextButton;

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
    public AndroidMessageAppPO(AppiumDriver driver) {
        super(driver);
    }
//
//    public void clickOnNextButton() {
//        nextButton.click();
//    }
//
//    @AndroidFindBy(id = "android:id/button1")
//    AndroidElement messageDialogOKButton;
//
//    public void clickOnMessageDialogOKButton() {
//        messageDialogOKButton.click();
//    }
//
//
}
