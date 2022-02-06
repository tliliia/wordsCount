package Service;

import ResultSaver.ResultSaver;
import TextSource.TextSource;
import WordCounter.WordCounter;
import org.apache.log4j.Logger;

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
        String sourceText = sourceText = textSource.getText();

        log.debug("Проведение статистики");
        wordCounter.processText(sourceText);

        log.debug("Сохранение результата");
        try {
            saver.saveResult(wordCounter.getStatictics());
        } catch (Exception e) {
            log.error("Сохранение результата", e);
        }
    }

}
