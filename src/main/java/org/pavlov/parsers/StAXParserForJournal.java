package org.pavlov.parsers;

import org.pavlov.entity.Journal;
import org.pavlov.parsers.util.StAXParserUtil;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXParserForJournal {

    public Journal parseDocumentWithStAX(String path) throws XMLStreamException {
        System.out.println("\n----------Parsing with StAXParser---------------");

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream(path));
        StAXParserUtil stAXParserUtil = new StAXParserUtil();

        return stAXParserUtil.setJournalWithXmlNodeValues(reader);
    }
}

