package testcases;

import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 22/12/18
 * @project POM_Automation_Framework
 */
public class AndroidNeworkConnections extends BaseTest {
    @BeforeTest
    @Override
    public void setUpPage() {

    }

    @Test
    public void enableOnlyWifi() {
        ConnectionState state = driver.setConnection(new ConnectionStateBuilder()
                .withWiFiEnabled()
                .build());

        assertTrue(state.isWiFiEnabled());
        assertFalse(state.isDataEnabled());
        assertFalse(state.isAirplaneModeEnabled());
    }

    @Test
    public void enableOnlyMobileData() {
        ConnectionState state = driver.setConnection(new ConnectionStateBuilder()
                .withDataEnabled()
                .build());

        assertTrue(state.isDataEnabled());
        assertFalse(state.isWiFiEnabled());
        assertFalse(state.isAirplaneModeEnabled());
    }

    @Test
    public void enableOnlyAirplaneMode() {
        ConnectionState state = driver.setConnection(new ConnectionStateBuilder()
                .withAirplaneModeEnabled()
                .build());

        assertTrue(state.isAirplaneModeEnabled());
        assertFalse(state.isDataEnabled());
        assertFalse(state.isWiFiEnabled());
    }

}
