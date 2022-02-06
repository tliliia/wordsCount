public class TextToWordsAdapter {

    public static String[] getWords(String sourceText) {
        String[] words = sourceText.split("[ ,.!?\";:\\[\\]()\\n\\r\\t]");
        //todo:properties

        return words;
    }
}
