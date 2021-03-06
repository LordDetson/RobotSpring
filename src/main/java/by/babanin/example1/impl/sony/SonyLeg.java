package by.babanin.example1.impl.sony;

import by.babanin.example1.interfaces.Leg;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static by.babanin.example1.Constant.*;

@Component
@Lazy
@Qualifier("sony")
public class SonyLeg implements Leg {
    @Override
    public void go() {
        System.out.printf(GO_TO_FORMAT, SONY);
    }
}
