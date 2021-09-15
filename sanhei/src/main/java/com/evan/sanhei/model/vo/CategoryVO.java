package com.evan.sanhei.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


/**
 * @program: WJ-LUO
 * @description: 图书类型入参
 * @author: Jimu.Luo
 * @create: 2021-07-07 16:54
 **/

//@Data
@Entity
@Table(name = "category")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@ApiModel("图书类型查询-入参")
public class CategoryVO extends CommonVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    @ApiModelProperty(value = "类型ID", example = "1")
    private String typeId;

    @ApiModelProperty(value = "类型名称", example = "文学"/*, hidden = true*/)
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
        return "CategoryVO{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
