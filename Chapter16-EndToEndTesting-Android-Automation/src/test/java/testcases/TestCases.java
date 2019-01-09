/*
 * (C) Copyright 2018 by Pratik Patel (https://github.com/prat3ik/)
 */
package testcases;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.ConversationPO;
import pageobject.MessagesPO;
import pageobject.NewConversationPO;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCases extends BaseTest {

    @Test
    public void verifyUserCanSendMessage() {
        final String phoneNo = "00011122233";
        final String timestamp = System.currentTimeMillis() + "";
        final String messageText = "Hello, there. Current time is: " + timestamp;

        MessagesPO messagesPO = new MessagesPO(androidDriver);

        NewConversationPO newConversationPO = messagesPO.clickOnStartNewConversationButton();

        ConversationPO conversationPO = newConversationPO.typeAndSubmitContactNumber(phoneNo);
        Assert.assertTrue(conversationPO.isConversationScreenDisplayed(), "Conversation screen didn't appear!");
        conversationPO.typeInSMSTextField(messageText);
        conversationPO.tapOnSMSButton();

        Assert.assertTrue(conversationPO.isMessageSent(), "Message:'" + messageText + "' is not being sent!");
        Assert.assertTrue(conversationPO.isLastSentMessageContains(timestamp), "Last sent message is different than expected!, Original message is: '" + conversationPO.getLastSentMessageText() + "', while the expected substing is: " + timestamp + "'");
    }

    @BeforeTest
    @Override
    public void setUpPage() throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }

}