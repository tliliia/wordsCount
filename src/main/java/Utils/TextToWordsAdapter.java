package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Класс для преобразования входного текста в список слов
 */
public class TextToWordsAdapter {

    public static List<String> getWords(String sourceText) {
        if (sourceText == null) {
            throw new IllegalArgumentException("Нет входного текста");
        }
        String delimiters = delimitersFromProperties().isPresent() ? delimitersFromProperties().get() : " ";
        String[] splitted = sourceText.split(delimiters);
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(splitted));
        words.removeIf(word -> word.isBlank());
        return words;
    }

    private static Optional<String> delimitersFromProperties() {
        String delimiters = null;
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            delimiters = prop.getProperty("delimiters");
        } catch (IOException ex) {
            throw new RuntimeException("Невозмжно получить список разделителей для слов");
        } finally {
            return Optional.ofNullable(delimiters);
        }
    }
}
