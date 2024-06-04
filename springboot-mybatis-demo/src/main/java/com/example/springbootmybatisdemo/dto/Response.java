package com.example.springbootmybatisdemo.dto;

public class Response<T> {
    private int code;
    private String msg;
    private String traceId;
    private T data;

    public Response(int code, String msg, String traceId, T data){
        this.code = code;
        this.msg = msg;
        this.traceId = traceId;
        this.data = data;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getTraceId() {
        return traceId;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
