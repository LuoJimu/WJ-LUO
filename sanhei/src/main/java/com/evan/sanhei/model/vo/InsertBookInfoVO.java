package com.evan.sanhei.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * @program: WJ-LUO
 * @description: 图书新增-入参
 * @author: Jimu.Luo
 * @create: 2021-08-14 18:59
 **/

@ApiModel("图书新增-入参")
public class InsertBookInfoVO {

    @ApiModelProperty(value = "图书封面ip",example = "https://i.loli.net/2019/04/10/5cadaa0d0759b.jpg")
    @NotEmpty(message = "图书封面ip不能为空")
    private String cover;

    @ApiModelProperty(value = "图书标题",example = "且在人间")
    @NotEmpty(message = "图书标题不能为空")
    private String title;

    @ApiModelProperty(value = "作者",example = "余秀华")
    @NotEmpty(message = "作者不能为空")
    private String author;

    @ApiModelProperty(value = "出版时间",example = "2021-8")
    private String pubDate;

    @ApiModelProperty(value = "出版社",example = "湖南文艺出版社")
    @NotEmpty(message = "出版社不能为空")
    private String press;

    @ApiModelProperty(value = "图书简介",example = "诗人余秀华中篇小说首次结集出版")
    private String abs;

    @ApiModelProperty(value = "图书类型id",example = "1")
    @NotEmpty(message = "图书类型id不能为空")
    private String cid;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "InsertBookInfoVO{" +
                "cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", press='" + press + '\'' +
                ", abs='" + abs + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
