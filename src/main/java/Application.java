import services.StatisticServiceImpl;
import utils.WordCounter.HashMapWordCounter;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        StatisticServiceImpl service = applicationContext.getBean(StatisticServiceImpl.class);
        service.doWork();
    }

}
