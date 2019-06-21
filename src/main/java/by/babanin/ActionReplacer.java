package by.babanin;

import by.babanin.impl.robot.ModelT1000;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ActionReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        ModelT1000 robot = (ModelT1000) o;
        System.out.println("name: " + robot.getName());
        if (robot.haveHeadHandLeg()) {
            robot.getHead().calc();
            robot.getHand().catchSomething();
            robot.getLeg().go();
        }
        System.out.println("color: " + robot.getColor());
        System.out.println("year: " + robot.getYear());
        System.out.println("soundEnabled: " + robot.isSoundEnabled());
        return robot;
    }
}
