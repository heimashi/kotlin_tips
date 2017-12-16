package com.sw.kotlin.tip1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaExample1 {

    public void testString1() {
        String str1 = "abc";
        String str2 = "line1\n" +
                "line2\n" +
                "line3";
        String js = "function myFunction()\n" +
                "{\n" +
                "    document.getElementById(\"demo\").innerHTML=\"My First JavaScript Function\";\n" +
                "}";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(js);
    }

    public void testString2() {
        List<String> strings = new ArrayList<>(Arrays.asList("abc", "def", "ghj"));
        System.out.print("First content is " + strings.get(0));
    }

}
