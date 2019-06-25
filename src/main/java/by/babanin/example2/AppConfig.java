package by.babanin.example2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class AppConfig {
    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger("logger");
    }
}
