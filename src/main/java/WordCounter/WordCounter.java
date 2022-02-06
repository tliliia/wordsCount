package WordCounter;

import java.util.Map;

public interface WordCounter {
    /**
     * Анализировать вхождения слов
     * @param text анализируемый текст
     */
    void processText(String text);

    /**
     * Получиьт статистику по используемым в тексте словам
     * @return
     */
    Map<String, Integer> getStatictics();
}
