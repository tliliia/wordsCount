import java.util.HashMap;
import java.util.Map;

public class HashMapWordCounter implements WordCounter {
    private final Map<String, Integer> wordsOccurrences;

    public HashMapWordCounter() {
        this.wordsOccurrences = new HashMap<>();
    }

    public void processWord(String word) {
        String wordLowerCase = word.toLowerCase();
        if (wordsOccurrences.containsKey(wordLowerCase)) {
            wordsOccurrences.put(wordLowerCase, wordsOccurrences.get(wordLowerCase) + 1);
        } else {
            wordsOccurrences.put(wordLowerCase, 1);
        }
    }

    public Map<String, Integer> getStatictics() {
        return wordsOccurrences;
    }

}
