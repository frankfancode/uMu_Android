package com.frankfancode.umu.app;


import com.frankfancode.umu.BuildConfig;

/**
 * Created by FrankFan on 16/6/26.
 */
public class UmuConfig {
    public static final boolean DEBUG = BuildConfig.DEBUG;
    public static final boolean DEMO = BuildConfig.FLAVOR_enviroment.equals("DEMO");
    public static final boolean Dev = BuildConfig.FLAVOR_enviroment.equals("Dev");


    private static final String URL_DEMO = "http://192.168.1.104:8080";
    private static final String URL_ONLINE = "http://192.168.1.104:8080";
    public static final String URL = DEMO ? URL_DEMO : URL_ONLINE;

}
