package by.babanin.example1.interfaces;

import java.util.Map;

public interface RobotPool {
    Map<Integer, Robot> getRobots();

    void action();
}
