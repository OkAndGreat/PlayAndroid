package com.example.playandroid.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtils {
    public static String escapeHtml(String str) {
        str = str.replace("<ul>", "");
        str = str.replace("</ul>", "");
        str = str.replace("</li>", "");
        str = str.replace("<br/>", "");
        str = str.replace("<p>", "");
        str = str.replace("</p>", "");
        str = str.replace("&amp;", "&");
        str = str.replace("&mdash;", "—");
        return str;
    }
}
