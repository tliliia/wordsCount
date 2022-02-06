import java.util.Map;

public interface WordCounter {
    void processWord(String word);

    Map<String, Integer> getStatictics();
}
