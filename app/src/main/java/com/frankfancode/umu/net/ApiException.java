package com.frankfancode.umu.net;

/**
 * Created by FrankFan on 2016/11/20.
 */

public class ApiException  extends RuntimeException {

    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PASSWORD = 101;

    public ApiException(int resultCode,String resultMessage) {
        this(getApiExceptionMessage(resultCode));
        if (resultMessage!=null&&resultMessage.length()==0){

        }

    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code){
        String message = "";
        switch (code) {
            case USER_NOT_EXIST:
                message = "该用户不存在";
                break;
            case WRONG_PASSWORD:
                message = "密码错误";
                break;
            default:
                message = "未知错误";

        }
        return message;
    }
}
