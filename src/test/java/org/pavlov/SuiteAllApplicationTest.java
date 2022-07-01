package org.pavlov;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.pavlov.dom.DomParserForJournalTest;
import org.pavlov.dom.util.DomParserUtilTest;
import org.pavlov.stax.StaxParserForJournalTest;

@Suite
@SelectClasses({
        DomParserForJournalTest.class,
        StaxParserForJournalTest.class,
        DomParserUtilTest.class
})
public class SuiteAllApplicationTest {
}
