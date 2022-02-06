import ResultSaver.FileResultSaver;
import TextSource.HTMLTextSource;
import WordCounter.HashMapWordCounter;

public class Program {
    public static void main(String[] args) {
        if(args.length < 1) {
            throw  new IllegalArgumentException("Необходимо ввести параметр URL");
        }
        StatisticServiceImpl service = new StatisticServiceImpl(
                new HTMLTextSource(args[0]),
                new HashMapWordCounter(),
                new FileResultSaver("out.txt"));
        service.doWork();
    }

}
