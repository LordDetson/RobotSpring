package by.babanin.interfaces;

import java.util.Map;

public interface RobotPool {
    Map<Integer, Robot> getRobots();

    void action();
}
