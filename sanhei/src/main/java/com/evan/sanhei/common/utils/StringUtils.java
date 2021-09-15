package com.evan.sanhei.common.utils;

import java.util.Random;

/**
 * @program: WJ-LUO
 * @description: 编写生成指定长度随机字符串的方法
 * 后端上传图片主要解决如下两个问题：
 *  1、如何接收前端传来的图片数据并保存
 *  2、如何避免重名（图片资源的名字很可能重复，如不修改可能出现问题）
 * @author: Jimu.Luo
 * @create: 2021-09-15 10:11
 **/

public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
