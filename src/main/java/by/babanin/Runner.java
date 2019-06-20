package by.babanin;

import by.babanin.impl.robot.ModelT1000;
import by.babanin.interfaces.Robot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Robot t1000 = ac.getBean("t1000", ModelT1000.class);
        t1000.dance();
        t1000.action();

        ModelT1000 modelT1000 = ac.getBean("modelT1000", ModelT1000.class);
        modelT1000.dance();
        modelT1000.action();
    }
}
