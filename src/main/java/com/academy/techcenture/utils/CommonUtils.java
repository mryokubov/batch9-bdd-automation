package com.academy.techcenture.utils;

import java.util.Random;

public class CommonUtils {

    private CommonUtils(){}

    public static int generateId() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}
