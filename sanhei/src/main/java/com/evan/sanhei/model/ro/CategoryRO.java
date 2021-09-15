package com.evan.sanhei.model.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: WJ-LUO
 * @description: 图书类型查询出参
 * @author: Jimu.Luo
 * @create: 2021-07-08 10:45
 **/

@ApiModel("图书类型查询-出参")
public class CategoryRO {

    @ApiModelProperty(value = "类型ID")
    private String typeId;

    @ApiModelProperty(value = "类型名称")
    private String typeName;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "CategoryRO{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
