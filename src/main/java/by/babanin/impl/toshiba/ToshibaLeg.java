package by.babanin.impl.toshiba;

import by.babanin.interfaces.Leg;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static by.babanin.Constant.*;

@Component
@Lazy
@Qualifier("toshiba")
public class ToshibaLeg implements Leg {
    @Override
    public void go() {
        System.out.printf(GO_TO_FORMAT, TOSHIBA);
    }
}
