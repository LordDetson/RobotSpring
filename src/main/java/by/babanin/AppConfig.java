package by.babanin;

import by.babanin.impl.robot.ModelT1000;
import by.babanin.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    public Logger logger;

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger("logger");
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Robot t1000(
            @Qualifier("sony") Head head,
            @Qualifier("sony") Hand hand,
            @Qualifier("sony") Leg leg) {
        return new ModelT1000("t1000", head, hand, leg, "silver", 2017, true);
    }

    @Bean
    public Map<Integer, Robot> robots(RobotFactory robotFactory) {
        Map<Integer, Robot> robots = new HashMap<>();
        Robot robot = robotFactory.create();
        if (robot instanceof ModelT1000) {
            ModelT1000 modelT1000 = (ModelT1000) robot;
            modelT1000.setYear(2005);
            robots.put(modelT1000.getYear(), robot);
        }
        robot = robotFactory.create();
        if (robot instanceof ModelT1000) {
            ModelT1000 modelT1000 = (ModelT1000) robot;
            robots.put(modelT1000.getYear(), robot);
        }
        return robots;
    }
}
