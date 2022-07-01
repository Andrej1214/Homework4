package org.pavlov.dom.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.pavlov.entity.Journal;
import org.pavlov.parsers.util.DomParserUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.assertj.core.api.Assertions.assertThat;


public class DomParserUtilTest {
    private static final String XML_PATH = "journal.xml";
    private static final String XML_PATH_TWO = "journalSecondVersion.xml";
    private static final String XML_PATH_THREE = "journalThirdVersion.xml";
    private static final String XML_PATH_FOR_EASY_JOURNAL = "easyJournal.xml";

    @ParameterizedTest
    @CsvSource(value = {XML_PATH, XML_PATH_TWO, XML_PATH_THREE})
    void testParseXmlDocument(String PATH) {
        assertThat(DomParserUtil.parseXmlDocument(PATH)).as("  document doesn't create")
                .isNotNull();
    }

    @Test
    void testsSetJournalTitleWithXmlNodeValues() {
        Document document = DomParserUtil.parseXmlDocument(XML_PATH_FOR_EASY_JOURNAL);
        Node node = document.getFirstChild();
        NodeList nodeList = node.getChildNodes();
        Node node1 = nodeList.item(1);
        Journal journal = new Journal();
        DomParserUtil.setJournalWithXmlNodeValues(journal, node1);
        assertThat(journal.getJournalTitle()).as("The value of the node is not assigned to journal")
                .isEqualTo("new Journal");
    }
}
