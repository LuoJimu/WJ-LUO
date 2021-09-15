package com.evan.sanhei.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.chinastock.communication.BaseResponse;

/**
 * @program: WJ-LUO
 * @description: 返回JSON格式
 * @author: Jimu.Luo
 * @create: 2021-08-09 15:39
 **/

public class ApiBaseResponse<T> extends BaseResponse {
    @JSONField(name = "columnNames")
    private JSONArray columnNames;

    public ApiBaseResponse() {
        super();
    }

    public JSONArray getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(JSONArray columnNames) {
        this.columnNames = columnNames;
    }

}
