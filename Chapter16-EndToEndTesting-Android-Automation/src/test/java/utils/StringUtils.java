package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Year: 2018-19
 *
 * This class contains String Utility methods that can be used by other class.
 *
 * @author Prat3ik on 27/09/18
 */
public class StringUtils {

    public String getFirstWordFromString(final String s) {
        String firstWord = null;

        if (s.contains(" ")) {
            firstWord = s.substring(0, s.indexOf(" "));
        } else {
            firstWord = s;
        }
        return firstWord;
    }

    public String getLastWordFromString(final String s) {
        final String lastWord = s.substring(s.lastIndexOf(" ") + 1);

        return lastWord;
    }

    public String getTimeStamp() {
        final String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public String trimParenthesisValues(final String s) {

        String str = s.substring(0, s.indexOf("(")).trim();
        return str;
    }

    public List<String> trimParenthesisValues(final List<String> str) {

        List<String> string = new ArrayList<String>();
        for (int i = 0; i < str.size(); i++) {
            string.add(trimParenthesisValues(str.get(i)));
        }
        return string;
    }
}