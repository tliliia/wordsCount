import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FileResultSaver implements ResultSaver {

    private final String fileName;

    public FileResultSaver(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveResult(Map<String, Integer> result) {
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            result.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry -> printWriter.println(String.format("%s - %d", entry.getKey(), entry.getValue())));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
