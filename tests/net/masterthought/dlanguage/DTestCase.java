package net.masterthought.dlanguage;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.masterthought.dlanguage.codeinsight.DFindUsagesTest;
import net.masterthought.dlanguage.lexer.DLexerTest;
import net.masterthought.dlanguage.parser.DParserTest;
import net.masterthought.dlanguage.resolve.DResolveTest;

/**
 * Main testsuite driver. Specifies which components that should be tested.
 * Test cases belong in the individual test suites.
 */
@SuppressWarnings("ALL")
public class DTestCase extends TestCase {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        // TODO: The order of the tests seem to matter.  If the HaskellTypedHandlerTest does not come first it seems (not sure about this)
        // to fail.  Once re-ordered, the HaskellParserTest.testInternalLexer seems to produce a different AST,
        // so there seems to be something strange going on.
        // See https://github.com/carymrobbins/intellij-haskforce/issues/63
//        suite.addTestSuite(HaskellTypedHandlerTest.class);
        suite.addTestSuite(DResolveTest.class);
        suite.addTestSuite(DLexerTest.class);

        // not working in ant for some reason
//        suite.addTestSuite(DParserTest.class);
//        suite.addTestSuite(DFindUsagesTest.class);


//        suite.addTestSuite(HaskellParsingLexerTest.class);
//        suite.addTestSuite(HaskellParserTest.class);
//        suite.addTestSuite(HaskellFeaturesTest.class);
//        suite.addTestSuite(HaskellFoldingBuilderTest.class);
//        suite.addTestSuite(HaskellCompletionTest.class);
//        suite.addTestSuite(HaskellFindUsagesTest.class);
//        suite.addTestSuite(HaskellRenameTest.class);
//        suite.addTestSuite(HaskellResolveTest.class);
        return suite;
    }
}

