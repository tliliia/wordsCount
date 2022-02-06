package utils.ResultSaver;

import java.util.Map;

public interface ResultSaver {
    /**
     * Сохранение результата сбора статистики
     * @param result результат сбора статистики
     */
    void saveResult(Map<String, Integer> result);
}
