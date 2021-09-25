package com.evan.sanhei.model.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @program: WJ-LUO
 * @description: 笔记本查询出参
 * @author: Jimu.Luo
 * @create: 2021-09-23 13:36
 **/

@ApiModel("笔记本查询-出参")
public class QueryJotterArticleRO {

    @ApiModelProperty(value = "文章id")
    private int articleId;

    @ApiModelProperty(value = "文章标题")
    private String articleTitle;

    @ApiModelProperty(value = "文章内容渲染")
    private String articleContentHtml;

    //Article content in markdown syntax.
    @ApiModelProperty(value = "文章内容")
    private String articleContentMd;

    @ApiModelProperty(value = "文章摘要")
    private String articleAbstract;

    @ApiModelProperty(value = "文章封面URL")
    private String articleCover;

    @ApiModelProperty(value = "发布时间")
    private Date articleDate;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContentHtml() {
        return articleContentHtml;
    }

    public void setArticleContentHtml(String articleContentHtml) {
        this.articleContentHtml = articleContentHtml;
    }

    public String getArticleContentMd() {
        return articleContentMd;
    }

    public void setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    @Override
    public String toString() {
        return "QueryJotterArticleRO{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContentHtml='" + articleContentHtml + '\'' +
                ", articleContentMd='" + articleContentMd + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                ", articleCover='" + articleCover + '\'' +
                ", articleDate=" + articleDate +
                '}';
    }
}
