package com.frankfancode.umu.net;

/**
 * Created by FrankFan on 2016/11/19.
 */

public class HttpResult<T> {
    private int resultCode;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    private String resultMessage;

    public T data;
}