package com.openmind.netdevice.framework.model;

import com.alibaba.fastjson.JSON;
import com.openmind.netdevice.framework.sqlutil.MysqlErrTranslator;

//import com.openmind.netdevice.socket.xml.model.common.XMLDTO;

/**
 * The return value of controller. (Work as DTO?)
 *
 * @author LiuBin
 * @version Created on 2017/7/11
 */
public class Result {
    private Object data;
    private int errorCode;
    //    String errorMessage;
    private String message;
    private boolean success;//用于 ajax

    public Result() {
        this.success=true;
    }



    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public static Result getSuccessResult(String msg){
        Result result = new Result();
        result.setMessage(msg);
        result.setSuccess(true);
        return result;
    }

    public static Result getErrResult(Exception e) {
        Result result = new Result();
        result.setErrorCode(1);
        result.setMessage(MysqlErrTranslator.getErrorInfo(e));
        result.setSuccess(false);
        return result;
    }

    public static Result getErrResult(Throwable t) {
        Result result = new Result();
        result.setErrorCode(1);
        result.setMessage(t.getClass().toString());
        result.setSuccess(false);
        return result;
    }

    public static Result getFailureResult(String msg) {
        Result result = new Result();
        result.setErrorCode(1);
        result.setMessage(msg);
        result.setSuccess(false);
        return result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
