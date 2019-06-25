package by.babanin.example1.impl.toshiba;

import by.babanin.example1.interfaces.Hand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static by.babanin.example1.Constant.CATCHED_FROM_FORMAT;
import static by.babanin.example1.Constant.TOSHIBA;

@Component
@Lazy
@Qualifier("toshiba")
public class ToshibaHand implements Hand {
    @Override
    public void catchSomething() {
        System.out.printf(CATCHED_FROM_FORMAT, TOSHIBA);
    }
}
