package org.pavlov.entity;

import java.util.List;

public class Journal {
    private String journalTitle;
    private Contacts contacts;
    private List<Article> articleList;

    public Journal() {
    }

    public Journal(String journalTitle, Contacts contacts, List<Article> articleList) {
        this.journalTitle = journalTitle;
        this.contacts = contacts;
        this.articleList = articleList;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Journal journal = (Journal) o;

        if (!journalTitle.equals(journal.journalTitle)) return false;
        if (!contacts.equals(journal.contacts)) return false;
        return articleList.equals(journal.articleList);
    }

    @Override
    public int hashCode() {
        int result = journalTitle.hashCode();
        result = 31 * result + contacts.hashCode();
        result = 31 * result + articleList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Journal{");
        sb.append("journalTitle='").append(journalTitle).append('\'');
        sb.append(",\n        contacts=").append(contacts);
        sb.append(",\n        articleList=").append(articleList);
        sb.append("}");
        return sb.toString();
    }
}
