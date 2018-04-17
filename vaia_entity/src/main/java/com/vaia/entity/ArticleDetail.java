package com.vaia.entity;

public class ArticleDetail {
    private Integer articleId;

    private String article;

    public ArticleDetail() {
    }

    public ArticleDetail(Integer articleId, String article) {
        this.articleId = articleId;
        this.article = article;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article == null ? null : article.trim();
    }

    @Override
    public String toString() {
        return "ArticleDetail{" +
                "articleId=" + articleId +
                ", article='" + article + '\'' +
                '}';
    }
}