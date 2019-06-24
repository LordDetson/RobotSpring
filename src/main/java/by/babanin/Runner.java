package by.babanin;

import by.babanin.impl.robot.ModelT1000;
import by.babanin.impl.robot.ModelT1000Factory;
import by.babanin.impl.robot.ModelT1000Pool;
import by.babanin.interfaces.Robot;
import by.babanin.interfaces.RobotFactory;
import by.babanin.interfaces.RobotPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    private static Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Robot t1000 = ac.getBean("t1000", ModelT1000.class);
        System.out.println(t1000);
        t1000.dance();
        t1000.action();

        Robot modelT1000 = ac.getBean("modelT1000", ModelT1000.class);
        System.out.println(modelT1000);
        modelT1000.dance();
        modelT1000.action();

        RobotFactory robotFactory = ac.getBean("modelT1000Factory", ModelT1000Factory.class);
        ModelT1000 terminator1 = (ModelT1000) robotFactory.create();
        ModelT1000 terminator2 = (ModelT1000) robotFactory.create();
        ModelT1000 terminator3 = (ModelT1000) robotFactory.create();
        terminator1.setName("terminator1");
        terminator2.setName("terminator2");
        terminator3.setName("terminator3");
        System.out.println("terminator1");
        terminator1.action();
        System.out.println("terminator2");
        terminator2.action();
        System.out.println("terminator3");
        terminator3.action();

        ModelT1000Pool robotPool = ac.getBean("modelT1000Pool", ModelT1000Pool.class);
        robotPool.action();
    }
}
