import org.junit.jupiter.api.Test;
import utils.TextSource.HTMLTextSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HTMLTextSourceTest {
    private HTMLTextSource testTextSource;

    @Test
    void testWordCounter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testTextSource = new HTMLTextSource(null);
        });
    }
}
