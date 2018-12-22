package utils;

import org.testng.Assert;

import java.util.List;

/**
 * Year: 2018-19
 * <p>
 * This class contains different custom asserts commonly used in medium tests
 *
 * @author Prat3ik on 25/09/18
 * @project cloudtimer.ios.automation
 */
public class AssertUtils {

    public static void assertListEquals(List actualList, List expectedList, String listName) {
        assertListContains(actualList, expectedList, listName);
        Assert.assertEquals(actualList.size(), expectedList.size(),
                "Value count in list" + listName + "  didn't match. \nExpected list values:  " + expectedList + ", \nActual List values:  " + actualList);
    }

    public static void assertListEqualsWithOrder(List actualList, List expectedList, String listName) {
        assertListEquals(actualList, expectedList, listName);
        Assert.assertEquals(actualList, expectedList,
                "List order didn't match, \nExpected: " + expectedList + "\nActual: " + actualList);
    }

    public static void assertListContains(List actualList, List expectedList, String listName) {
        for (Object expectedValue : expectedList) {
            Assert.assertTrue(actualList.contains(expectedValue),
                    "Value (" + expectedValue + ") is not present in List '" + listName + "'. \nActual list values: "
                            + actualList + "\nExpected list values: " + expectedList);
        }
    }

    public static void assertListNotContains(List actualList, List expectedList, String listName) {
        for (Object expectedValue : expectedList) {
            Assert.assertTrue(!actualList.contains(expectedValue), "Value (" + expectedValue + ") is present in List '"
                    + listName + "'. \nActual list values: " + actualList + "\nExpected list values: " + expectedList);
        }
    }

}
