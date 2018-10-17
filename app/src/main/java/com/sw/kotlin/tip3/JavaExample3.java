package com.sw.kotlin.tip3;

import static com.sw.kotlin.tip3.KotlinTip3Kt.joinToString2;
import static com.sw.kotlin.tip3.KotlinTip3Kt.joinToString2New;

import java.util.ArrayList;
import java.util.List;

public class JavaExample3 {

    public void test01() {
        List<Integer> arr = new ArrayList<Integer>() {{
            add(2);
            add(4);
            add(0);
        }};
        String res = joinToString2(arr, "-", "", "");
        System.out.println(res);
    }

    public void test02() {
        List<Integer> arr = new ArrayList<Integer>() {{
            add(2);
            add(4);
            add(0);
        }};
        String res = joinToString2New(arr, "-");
        System.out.println(res);
        String res2 = joinToString2New(arr, "-", "=>");
        System.out.println(res2);
    }

}
