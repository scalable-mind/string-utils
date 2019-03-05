package com.scalablemind.util;

public final class StringUtils {

    public static String escape(String raw) {
        if (raw == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('"');
        for (char c : raw.toCharArray()) {
            switch (c) {
                case '"':
                case '\\':
                    sb.append('\\').append(c);
                    break;
                case '\0':
                    sb.append("\\0");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    sb.append(((c < 32) || (c >= 127)) ? String.format("\\u%04x", (int) c) : c);
                    break;
            }
        }
        return sb.append('"').toString();
    }

}
