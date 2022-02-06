package WordCounter;

import Utils.TextToWordsAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HashMapWordCounter implements WordCounter {
    private final Map<String, Integer> wordsOccurrences;

    public HashMapWordCounter() {
        this.wordsOccurrences = new HashMap<>();
    }

    private void processWord(String word) {
        String wordLowerCase = word.toLowerCase();
        if (wordsOccurrences.containsKey(wordLowerCase)) {
            wordsOccurrences.put(wordLowerCase, wordsOccurrences.get(wordLowerCase) + 1);
        } else {
            wordsOccurrences.put(wordLowerCase, 1);
        }
    }

    @Override
    public void processText(String sourceText) {
        List<String> words = TextToWordsAdapter.getWords(sourceText);
        words.forEach(word -> processWord(word));

    }

    @Override
    public Map<String, Integer> getStatictics() {
        return wordsOccurrences;
    }

}
