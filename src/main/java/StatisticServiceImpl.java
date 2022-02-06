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
        String sourceText = null;
        try {
            sourceText = textSource.getText();
        } catch (Exception e) {
            log.error("Получение текста", e);
        }

        log.debug("Проведение статистики");
        try {
            List<String> words = TextToWordsAdapter.getWords(sourceText);
            words.forEach(word -> wordCounter.processWord(word));
        } catch (Exception e) {
            log.error("Проведение статистики", e);
        }

        log.debug("Сохранение результата");
        try {
            saver.saveResult(wordCounter.getStatictics());
        } catch (Exception e) {
            log.error("Сохранение результата", e);
        }
    }

}
