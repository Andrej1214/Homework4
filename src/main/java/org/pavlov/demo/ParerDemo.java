package org.pavlov.demo;

import org.pavlov.parsers.DOMParserForJournal;
import org.pavlov.parsers.StAXParserForJournal;

import javax.xml.stream.XMLStreamException;

public class ParerDemo {
    private static final String XML_PATH = "journal.xml";

    public static void main(String[] args) {
        StAXParserForJournal stAXParser = new StAXParserForJournal();
        try {
            System.out.println(stAXParser.parseDocumentWithStAX(XML_PATH));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        DOMParserForJournal domParser = new DOMParserForJournal();
        System.out.println(domParser.parseDocumentWithDOM(XML_PATH));
    }
}
