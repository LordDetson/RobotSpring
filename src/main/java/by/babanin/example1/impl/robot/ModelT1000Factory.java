package by.babanin.example1.impl.robot;

import by.babanin.example1.interfaces.Robot;
import by.babanin.example1.interfaces.RobotFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public abstract class ModelT1000Factory implements RobotFactory {
    @Lookup("t1000")
    public abstract Robot create();
}
