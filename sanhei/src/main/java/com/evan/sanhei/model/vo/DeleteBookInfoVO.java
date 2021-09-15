package com.evan.sanhei.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: WJ-LUO
 * @description: 图书删除-入参
 * @author: Jimu.Luo
 * @create: 2021-08-14 19:44
 **/

@ApiModel("图书删除-入参")
public class DeleteBookInfoVO {

    @ApiModelProperty(value = "ID")
//    @NotEmpty(message = "ID不能为空")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DeleteBookInfoVO{" +
                "id=" + id +
                '}';
    }
}
