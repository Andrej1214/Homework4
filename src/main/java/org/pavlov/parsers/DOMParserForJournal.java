package org.pavlov.parsers;

import org.pavlov.entity.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.pavlov.parsers.util.DomParserUtil.parseXmlDocument;
import static org.pavlov.parsers.util.DomParserUtil.setJournalWithXmlNodeValues;

public class DOMParserForJournal {

    public Journal parseDocumentWithDOM(String path) {
        System.out.println("\n----------Parsing with DOMParser---------------");
        Journal journal = new Journal();
        Document document = parseXmlDocument(path);
        Node root = document.getFirstChild();
        NodeList rootChildNodes = root.getChildNodes();
        for (int i = 0; i < rootChildNodes.getLength(); i++) {
            journal = setJournalWithXmlNodeValues(journal, rootChildNodes.item(i));
        }
        return journal;
    }
}
