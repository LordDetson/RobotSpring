package by.babanin;

import by.babanin.interfaces.Robot;
import by.babanin.interfaces.RobotFactory;
import by.babanin.interfaces.RobotPool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        Robot t1000 = ac.getBean("t1000", Robot.class);
        System.out.println(t1000);
        t1000.dance();
        t1000.action();

        Robot modelT1000 = ac.getBean("modelT1000", Robot.class);
        System.out.println(modelT1000);
        modelT1000.dance();
        modelT1000.action();

        RobotFactory robotFactory = ac.getBean("modelT1000Factory", RobotFactory.class);
        Robot terminator1 = robotFactory.create();
        Robot terminator2 = robotFactory.create();
        Robot terminator3 = robotFactory.create();
        terminator1.setName("terminator1");
        terminator2.setName("terminator2");
        terminator3.setName("terminator3");
        System.out.println("terminator1");
        terminator1.action();
        System.out.println("terminator2");
        terminator2.action();
        System.out.println("terminator3");
        terminator3.action();

        RobotPool robotPool = ac.getBean("modelT1000Pool", RobotPool.class);
        Map<Integer, Robot> robots = robotPool.getRobots();
        System.out.println(robots);
        robots.forEach((integer, robot) -> robot.action());
    }
}
