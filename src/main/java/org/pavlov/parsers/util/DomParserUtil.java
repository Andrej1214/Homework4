package org.pavlov.parsers.util;

import org.pavlov.entity.Article;
import org.pavlov.entity.Contacts;
import org.pavlov.entity.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DomParserUtil {

    public static Document parseXmlDocument(String path) {
        DocumentBuilder documentBuilder = createDocumentBuilder();
        Document document = null;
        if (null != documentBuilder) {
            try {
                document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(path));
            } catch (Exception e) {
                System.out.println("Error when parsing document");
            }
        }
        return document;
    }

    public static Journal setJournalWithXmlNodeValues(Journal journal, Node node) {
        switch (node.getNodeName()) {
            case "title" -> setJournalTitleWithXmlNodeValues(journal, node);
            case "contacts" -> {
                Contacts contacts = setContactsWithXmlNodeValues(node);
                journal.setContacts(contacts);
            }
            case "articles" -> {
                List<Article> articleList = setArticlesWithXmlNodeValues(node);
                journal.setArticleList(articleList);
            }
        }
        return journal;
    }

    private static Stream<Node> getNodeListStream(NodeList nodeList) {
        return IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item);
    }

    private static Journal setJournalTitleWithXmlNodeValues(Journal journal, Node node) {
        String content = node.getTextContent().trim();
        if (node.getNodeName().equals("title")) {
            journal.setJournalTitle(content);
        }
        return journal;
    }

    private static Contacts setContactsWithXmlNodeValues(Node node) {
        NodeList childNodes = node.getChildNodes();
        Contacts contacts = new Contacts();
        for (int j = 0; j < childNodes.getLength(); j++) {
            if (childNodes.item(j) instanceof Element) {
                Node child = childNodes.item(j);
                switch (child.getNodeName()) {
                    case "address" -> contacts.setAddress(child.getTextContent().trim());
                    case "tel" -> contacts.setTel(child.getTextContent().trim());
                    case "email" -> contacts.setEmail(child.getTextContent().trim());
                    case "url" -> contacts.setUrl(child.getTextContent().trim());
                }
            }
        }
        return contacts;
    }

    private static Article setArticleWithXmlNodeValues(Article article, Node node) {
        NodeList nodeList = node.getChildNodes();
        getNodeListStream(nodeList).forEach(node1 -> {
            if (node1 instanceof Element) {
                String content = node1.getTextContent().trim();
                switch (node1.getNodeName()) {
                    case "title" -> article.setArticleTitle(content);
                    case "articleAuthor" -> article.setArticleAuthor(content);
                    case "url" -> article.setArticleUrl(content);
                }
                List<String> hotkeys = DomParserUtil.setHotkeyListWithXmlNodeValues(node1);
                article.setListOfHotkeys(hotkeys);
            }
        });
        return article;
    }

    private static List<String> setHotkeyListWithXmlNodeValues(Node node) {
        List<String> hotkeys = new ArrayList<>();
        NodeList nodeList4 = node.getChildNodes();
        getNodeListStream(nodeList4).forEach(node2 -> {
            if (node2 instanceof Element) {
                if (node2.getNodeName().trim().equals("hotkey")) {
                    hotkeys.add(node2.getTextContent());
                }
            }
        });
        return hotkeys;
    }

    private static List<Article> setArticlesWithXmlNodeValues(Node node) {
        List<Article> articleList = new ArrayList<>();
        NodeList childNodes = node.getChildNodes();
        getNodeListStream(childNodes).forEach(node1 -> {
            if (node1 instanceof Element) {
                Article article = new Article();
                article.setId(Integer.parseInt(node1.getAttributes()
                        .getNamedItem("ID").getNodeValue()));
                setArticleWithXmlNodeValues(article, node1);
                articleList.add(article);
            }
        });
        return articleList;
    }

    private static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newDefaultInstance();
        try {
            return builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("Error in creation document builder");
            return null;
        }
    }
}
