package trainee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource(value = "classpath:application.properties")
@ComponentScan()
public class AppConfig {
    private final Environment environment;

    @Autowired
    public AppConfig(Environment environment) {
        this.environment = environment;
    }

}