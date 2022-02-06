import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class StatisticServiceImpl {
    Logger log = Logger.getLogger(StatisticServiceImpl.class.getName());

    private final TextSource textSource;
    private final WordCounter wordCounter;
    private final ResultSaver saver;


    public StatisticServiceImpl(TextSource textSource, WordCounter wordCounter, ResultSaver saver) {
        this.textSource = textSource;
        this.wordCounter = wordCounter;
        this.saver = saver;
    }

    public void doWork() {
        log.debug("Получение текста");
        String sourceText = textSource.getText();

        log.debug("Проведение статистики");
        List<String> words = TextToWordsAdapter.getWords(sourceText);
        words.forEach(word -> wordCounter.processWord(word));

        log.debug("Сохранение результата");
        saver.saveResult(wordCounter.getStatictics());
    }

}
