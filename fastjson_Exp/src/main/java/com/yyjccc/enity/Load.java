package com.yyjccc.enity;

import java.io.IOException;

public class Load {

    static {
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
