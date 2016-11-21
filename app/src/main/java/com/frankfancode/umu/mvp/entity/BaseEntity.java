package com.frankfancode.umu.mvp.entity;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by FrankFan on 2016/11/18.
 */

public class BaseEntity implements Serializable {
    public int errCode;
    public String errMessage;

    public String toString(){
        return new Gson().toJson(this);
    }

}
