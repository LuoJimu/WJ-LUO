package com.evan.sanhei.model.ro;

/**
 * @program: sanhei
 * @description: 结果输出
 * @author: Jimu.Luo
 * @create: 2021-01-16 18:42
 **/

public class ResultRO {

    //响应码
    private int code;
    private String message;
    private Object result;

    //将响应码结果传给前端
    public ResultRO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultRO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
