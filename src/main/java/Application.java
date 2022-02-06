import ResultSaver.FileResultSaver;
import Service.StatisticServiceImpl;
import TextSource.HTMLTextSource;
import WordCounter.HashMapWordCounter;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        StatisticServiceImpl service = applicationContext.getBean(StatisticServiceImpl.class);
        service.doWork();
    }

}
