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

    //将响应码传给前端
    public ResultRO(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResultRO{" +
                "code=" + code +
                '}';
    }
}
