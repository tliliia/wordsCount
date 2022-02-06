import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.WordCounter.HashMapWordCounter;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapWordCounterTest {
    private HashMapWordCounter testWordCounter;

    @BeforeEach
    void before() {
        testWordCounter = new HashMapWordCounter();
    }

    @Test
    void testWordCounter() {
        testWordCounter.processText("one two two three three three four four four four");
        Map<String, Integer> stat = testWordCounter.getStatictics();
        assertEquals(1, stat.get("one"));
        assertEquals(2, stat.get("two"));
        assertEquals(3, stat.get("three"));
        assertEquals(4, stat.get("four"));
    }
    }
