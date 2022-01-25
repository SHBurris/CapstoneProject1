package cs4273.oucapstone.app;

import static org.junit.Assert.assertTrue;
import cs4273.oucapstone.app.Parser;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ParserTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testIsLang(){
        assertTrue(Parser.isLang('a'));
        assertTrue(Parser.isLang('Z'));
        assertFalse(Parser.isLang(']'));
        assertFalse(Parser.isLang('<'));
    }


}