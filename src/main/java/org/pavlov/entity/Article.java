package org.pavlov.entity;

import java.util.List;

public class Article {
    private int id;
    private String articleTitle;
    private String articleAuthor;
    private String articleUrl;
    private List<String> listOfHotkeys;

    public Article() {
    }

    public Article(int id, String articleTitle, String articleAuthor,
                   String articleUrl, List<String> listOfHotkeys) {
        this.id = id;
        this.articleTitle = articleTitle;
        this.articleAuthor = articleAuthor;
        this.articleUrl = articleUrl;
        this.listOfHotkeys = listOfHotkeys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public List<String> getListOfHotkeys() {
        return listOfHotkeys;
    }

    public void setListOfHotkeys(List<String> listOfHotkeys) {
        this.listOfHotkeys = listOfHotkeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Article article = (Article) o;

        if (id != article.id) {
            return false;
        }
        if (!articleTitle.equals(article.articleTitle)) {
            return false;
        }
        if (!articleAuthor.equals(article.articleAuthor)) {
            return false;
        }
        if (!articleUrl.equals(article.articleUrl)) {
            return false;
        }
        return listOfHotkeys.equals(article.listOfHotkeys);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + articleTitle.hashCode();
        result = 31 * result + articleAuthor.hashCode();
        result = 31 * result + articleUrl.hashCode();
        result = 31 * result + listOfHotkeys.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Article{");
        sb.append("id=").append(id);
        sb.append(", articleTitle='").append(articleTitle).append('\'');
        sb.append(", articleAuthor='").append(articleAuthor).append('\'');
        sb.append(", articleUrl='").append(articleUrl).append('\'');
        sb.append(", listOfHotkeys=").append(listOfHotkeys);
        sb.append("} \n                   ");
        return sb.toString();
    }
}
