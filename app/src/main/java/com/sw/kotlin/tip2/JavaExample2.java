package com.sw.kotlin.tip2;


public class JavaExample2 {

    /*
    * java中，if 是语句，没有值，必须显示的return
    * */
    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /*
    * java中三元运算符，kotlin中if完全可以做到，故kotlin中已没有三元运算符了
    * */
    public int max2(int a, int b) {
        return a > b ? a : b;
    }
}
