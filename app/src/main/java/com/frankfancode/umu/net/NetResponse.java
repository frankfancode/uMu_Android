package com.frankfancode.umu.net;

import java.io.Serializable;

/**
 * Created by FrankFan on 16/6/25.
 */
public class NetResponse<T> implements Serializable {
    public static String PARSE_ERROR = "解析失败";

    public Error error;
    public Success<T> success;

    public class Error implements Serializable {
        public String code;
        public String msg;
    }

    public class Success<T> implements Serializable {
        public String code;
        public String msg;
        public T o;

    }
}
