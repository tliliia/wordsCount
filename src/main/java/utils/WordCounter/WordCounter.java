package utils.WordCounter;

import java.util.Map;

public interface WordCounter {
    /**
     * Получиьт статистику по используемым в тексте словам
     * @param text анализируемый текст
     */
    void processText(String text);

    /**
     * Получиьт статистику по используемым в тексте словам
     * @return
     */
    Map<String, Integer> getStatictics();
}
