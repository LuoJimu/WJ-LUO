package com.evan.sanhei.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: WJ-LUO
 * @description: 公共入参
 * @author: Jimu.Luo
 * @create: 2021-08-12 17:58
 **/

@ApiModel("公共入参")
public class CommonVO {
    @ApiModelProperty(value = "是否排序", example = "1|是;0|否")
    private String paging = "0";

    @ApiModelProperty(value = "当前页码", example = "1")
    private Integer pageNo;

    @ApiModelProperty(value = "单页记录数", example = "10")
    private Integer pageLength;

    @ApiModelProperty(value = "排序字段", example = "")
    private String sort;

//    @ApiModelProperty(value = "管理人ID", hidden = true)
//    private String mgrId;

    public String getPaging() {
        return paging;
    }

    public void setPaging(String paging) {
        this.paging = paging;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageLength() {
        return pageLength;
    }

    public void setPageLength(Integer pageLength) {
        this.pageLength = pageLength;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "CommonVO{" +
                "paging='" + paging + '\'' +
                ", pageNo=" + pageNo +
                ", pageLength=" + pageLength +
                ", sort='" + sort + '\'' +
                '}';
    }
}
