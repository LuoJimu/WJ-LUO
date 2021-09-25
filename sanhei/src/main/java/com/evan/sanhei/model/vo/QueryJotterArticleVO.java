package com.evan.sanhei.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
/**
 * @program: WJ-LUO
 * @description: 笔记本页面入参
 * @author: Jimu.Luo
 * @create: 2021-09-23 13:17
 **/

@ApiModel("笔记本页面查询-入参")
public class QueryJotterArticleVO extends CommonVO {

    @ApiModelProperty(value = "文章id", example = "1")
//    @NotNull(message = "文章id 不能为 null")
    private int articleId;

    @ApiModelProperty(value = "文章标题", example = "罗三黑自传")
//    @NotEmpty(message = "文章标题不能为空")
    private String articleTitle;

    @ApiModelProperty(value = "文章内容渲染", example = "一个月黑风高的晚上")
    private String articleContentHtml;

    //Article content in markdown syntax.
    @ApiModelProperty(value = "文章内容", example = "一个月黑风高的晚上")
    private String articleContentMd;

    @ApiModelProperty(value = "文章摘要", example = "一个月黑风高的晚上")
    private String articleAbstract;

    @ApiModelProperty(value = "文章封面URL", example = "https://i.loli.net/2020/01/19/egDEfu5jXlJ6r3a.png")
    private String articleCover;

    @ApiModelProperty(value = "发布时间", example = "2021-09-23")
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
        return "JotterArticleVO{" +
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

