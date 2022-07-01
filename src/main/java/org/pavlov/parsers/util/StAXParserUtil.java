package org.pavlov.parsers.util;

import org.pavlov.entity.Article;
import org.pavlov.entity.Contacts;
import org.pavlov.entity.Journal;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.stream.XMLStreamConstants.*;

public class StAXParserUtil {
    private List<Article> articleList;
    private Journal journal;
    private Contacts contacts;
    private Article article;
    private List<String> hotkeys = new ArrayList<>();
    private String content = "";
    private int counterForTitle = 0;
    private int counterForUrl = 0;

    public Journal setJournalWithXmlNodeValues(XMLStreamReader reader) throws XMLStreamException {
        journal = new Journal();
        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case START_ELEMENT -> startElementsOfParsing(reader);
                case CHARACTERS -> readContextOfElements(reader);
                case END_ELEMENT -> endElementsOfParsing(reader);
            }
        }
        return journal;
    }

    private Journal startElementsOfParsing(XMLStreamReader reader) {
        switch (reader.getLocalName()) {
            case "journal" -> journal = new Journal();
            case "title" -> counterForTitle++;
            case "contacts" -> contacts = new Contacts();
            case "url" -> counterForUrl++;
            case "articles" -> articleList = new ArrayList<>();
            case "article" -> {
                article = new Article();
                article.setId(Integer.parseInt(reader.getAttributeValue(null, "ID")));
            }
        }
        return journal;
    }

    private Journal readContextOfElements(XMLStreamReader reader) {
        content = reader.getText().trim();
        return journal;
    }

    private Journal endElementsOfParsing(XMLStreamReader reader) {
        switch (reader.getLocalName()) {
            case "title" -> {
                if (counterForTitle == 1) {
                    journal.setJournalTitle(content);
                } else {
                    article.setArticleTitle(content);
                }
            }
            case "contacts" -> journal.setContacts(contacts);
            case "address" -> contacts.setAddress(content);
            case "tel" -> contacts.setTel(content);
            case "email" -> contacts.setEmail(content);
            case "articles" -> {
                journal.setArticleList(articleList);
                article = new Article();
            }
            case "article" -> articleList.add(article);
            case "articleAuthor" -> article.setArticleAuthor(content);
            case "url" -> {
                if (counterForUrl == 1) {
                    contacts.setUrl(content);
                } else {
                    article.setArticleUrl(content);
                }
            }
            case "hotkey" -> hotkeys.add(content);
            case "hotkeys" -> {
                article.setListOfHotkeys(hotkeys);
                hotkeys = new ArrayList<>();
            }
        }
        return journal;
    }
}
