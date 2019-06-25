package by.babanin.example1.impl.robot;

import by.babanin.example1.interfaces.Robot;
import by.babanin.example1.interfaces.RobotPool;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Lazy
public class ModelT1000Pool implements RobotPool {
    Map<Integer, Robot> robots;

    public ModelT1000Pool(Map<Integer, Robot> robots) {
        this.robots = robots;
    }

    @Override
    public Map<Integer, Robot> getRobots() {
        return robots;
    }

    @Override
    public void action() {
        getRobots().forEach((integer, robot) -> robot.action());
    }
}
