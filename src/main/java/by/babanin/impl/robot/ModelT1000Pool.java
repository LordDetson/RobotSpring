package by.babanin.impl.robot;

import by.babanin.interfaces.Robot;
import by.babanin.interfaces.RobotPool;

import java.util.Map;

public class ModelT1000Pool implements RobotPool {
    Map<Integer, Robot> robots;

    public ModelT1000Pool(Map<Integer, Robot> robots) {
        this.robots = robots;
    }

    @Override
    public Map<Integer, Robot> getRobots() {
        return robots;
    }

    public void action() {
        robots.forEach((integer, robot) -> robot.action());
    }
}
