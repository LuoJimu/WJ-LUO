package com.evan.sanhei.model.ro;

/**
 * @program: WJ-LUO
 * @description: 响应结果生产工厂
 * @author: Jimu.Luo
 * @create: 2021-09-16 17:43
 **/

public class ResultFactoryRO {
    public static ResultRO buildSuccessResult(Object data) {
        return buildResult(ResultCodeRO.SUCCESS, "成功", data);
    }

    public static ResultRO buildFailResult(String message) {
        return buildResult(ResultCodeRO.FAIL, message, null);
    }

    public static ResultRO buildResult(ResultCodeRO resultCodeRO, String message, Object data) {
        return buildResult(resultCodeRO.code, message, data);
    }

    public static ResultRO buildResult(int resultCodeRO, String message, Object data) {
        return new ResultRO(resultCodeRO, message, data);
    }
}
