import static org.junit.Assert.assertFalse;
import java.util.Arrays;

import org.junit.Test;

public class ParserTest {

    @Test
    public void testsLetters() {
        assert (Parser.checkAll(Arrays.asList("a", "b", "z")));
    }

    @Test
    public void shouldGiveError() {
        assertFalse(
                Parser.checkAll(Arrays.asList("a", "b", "2")));
    }

}