import java.util.Map;

public class StatisticUtil {
    private final TextSource textSource;
    private final WordCounter wordCounter;


    public StatisticUtil(TextSource textSource, WordCounter wordCounter) {
        this.textSource = textSource;
        this.wordCounter = wordCounter;
    }

    public Map<String, Integer> getStatistics() {

        String sourceText = textSource.getText();
        String[] words = TextToWordsAdapter.getWords(sourceText);
        for(String word : words) {
            wordCounter.processWord(word);
        }
        return wordCounter.getStatictics();
    }
}
