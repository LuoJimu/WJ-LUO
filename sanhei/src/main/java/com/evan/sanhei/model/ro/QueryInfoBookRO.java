package com.evan.sanhei.model.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: WJ-LUO
 * @description: 图书查询-出参
 * @author: Jimu.Luo
 * @create: 2021-08-13 22:44
 **/

@ApiModel("图书查询-出参")
public class QueryInfoBookRO {

    @ApiModelProperty(value = "图书id")
    private String bookId;

    @ApiModelProperty(value = "图书封面ip")
    private String cover;

    @ApiModelProperty(value = "图书标题")
    private String title;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "出版时间")
    private String pubDate;

    @ApiModelProperty(value = "出版社")
    private String press;

    @ApiModelProperty(value = "图书简介")
    private String abs;

    @ApiModelProperty(value = "图书类型id")
    private String cid;

    @ApiModelProperty(value = "图书类型名称")
    private String typeName;

    @ApiModelProperty(value = "图书类型信息")
    private CategoryRO category;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public CategoryRO getCategory() {
        return category;
    }

    public void setCategory(CategoryRO category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "QueryInfoBookRO{" +
                "bookId='" + bookId + '\'' +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", press='" + press + '\'' +
                ", abs='" + abs + '\'' +
                ", cid='" + cid + '\'' +
                ", typeName='" + typeName + '\'' +
                ", category=" + category +
                '}';
    }
}
