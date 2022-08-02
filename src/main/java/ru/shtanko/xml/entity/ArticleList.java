package ru.shtanko.xml.entity;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "articles")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArticleList {
    @XmlElement(name = "article")
    private List<Article> articleList;

    public ArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public ArticleList() {
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
