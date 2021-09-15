package com.evan.sanhei.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: WJ-LUO
 * @description: 图书查询-入参
 * @author: Jimu.Luo
 * @create: 2021-08-12 15:23
 **/

@ApiModel("图书查询-入参")
public class QueryInfoBookVO extends CommonVO{

    @ApiModelProperty(value = "书名或者作者", example = "三体")
    private String keyName;

    @ApiModelProperty(value = "图书类型", example = "1")
    private String cid;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "QueryInfoBookVO{" +
                "keyName='" + keyName + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
