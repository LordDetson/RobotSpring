package by.babanin.example1;

import by.babanin.example1.impl.robot.ModelT1000;
import by.babanin.example1.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Lazy
public class AppConfig {
    @Bean
    @Lazy
    public Logger logger() {
        return LoggerFactory.getLogger("logger");
    }

    @Bean
    @Lazy
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Robot t1000(
            @Qualifier("sony") Head head,
            @Qualifier("sony") Hand hand,
            @Qualifier("sony") Leg leg) {
        return new ModelT1000("t1000", head, hand, leg, "silver", 2017, true);
    }

    @Bean
    @Lazy
    public Map<Integer, Robot> robots(RobotFactory robotFactory) {
        Map<Integer, Robot> robots = new HashMap<>();
        Robot robot = robotFactory.create();
        robot.setYear(2005);
        robots.put(robot.getYear(), robot);
        robot = robotFactory.create();
        robots.put(robot.getYear(), robot);
        return robots;
    }
}
