package com.scalablemind.util;

import org.junit.Test;

import static com.scalablemind.util.StringUtils.escape;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    public void escapeTest_sequences() {
        final String actual = escape("\" \\ \0 \b \f \n \r \t");
        final String expected = "\"\\\" \\\\ \\0 \\b \\f \\n \\r \\t\"";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void escapeTest_nonPrinted() {
        final String actual = escape("\001\002\003\004\005\006\007\013\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037");
        final String expected = "\"\\u0001\\u0002\\u0003\\u0004\\u0005\\u0006\\u0007\\u000b\\u000e\\u000f\\u0010\\u0011\\u0012\\u0013\\u0014\\u0015\\u0016\\u0017\\u0018\\u0019\\u001a\\u001b\\u001c\\u001d\\u001e\\u001f\"";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void escapeTest_null() {
        final String actual = escape(null);
        final String expected = "null";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void escapeTest_ascii() {
        final String actual = escape("test");
        final String expected = "\"test\"";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void escapeTest_notAscii() {
        final String actual = escape("тест");
        final String expected = "\"\\u0442\\u0435\\u0441\\u0442\"";
        assertThat(actual).isEqualTo(expected);
    }

}
