package com.example.common;

public class Result {

    private int code;
    private String msg;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.setCode(1);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(1);
        result.setData(data);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
