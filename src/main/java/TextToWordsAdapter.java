import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextToWordsAdapter {

    public static String[] getWords(String sourceText) {
        List<String> words = new ArrayList<>();
        String[] splitted = sourceText.split("[ ,.!?\";:\\[\\]()\\n\\r\\t]");
        words.addAll(Arrays.asList(splitted));
        words.removeIf(word -> word.length() == 0);
        //todo:properties

        return splitted;
    }
}
