package org.pavlov.dom;

import org.junit.jupiter.api.Test;
import org.pavlov.entity.Article;
import org.pavlov.entity.Contacts;
import org.pavlov.entity.Journal;
import org.pavlov.parsers.DOMParserForJournal;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DomParserForJournalTest {
    private static final String XML_PATH_FOR_EASY_JOURNAL = "easyJournal.xml";

    @Test
    void testParseDocumentWithDOMMethod(){
        List<String> listOne = new ArrayList<>();
        listOne.add("language1");
        List<String> listTwo = new ArrayList<>();
        listTwo.add("language2");
        listTwo.add("whitespace");
        Article articleOne = new Article(1,"title1","author1","article1",listOne);
        Article articleTwo = new Article(2,"title2","author2","article2",listTwo);
        List<Article> articleList = new ArrayList<>();
        articleList.add(articleOne);
        articleList.add(articleTwo);
        Contacts contacts = new Contacts("Minsk","1234567","org.com","www.j.com");
        Journal journal = new Journal("new Journal",contacts,articleList);
        DOMParserForJournal domParser = new DOMParserForJournal();
        assertThat(domParser.parseDocumentWithDOM(XML_PATH_FOR_EASY_JOURNAL)).as("The objects are different")
                .isEqualTo(journal);
    }
}
