package com.maidao.edu.store.common.util;

import java.io.InputStream;

public class R {

    public static InputStream getStream(String path) {
        return R.class.getResourceAsStream("/" + path);
    }

}
