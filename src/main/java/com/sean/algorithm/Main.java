package com.sean.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class Main {

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        if (s1 == s2)
        {
            System.out.println("s1 = s2");
        }
        String t1 = new String("Hello");
        String t2 = new String("Hello");
        if (t1 == t2)
        {
            System.out.println("t1 = t2");
        }

    }
}
