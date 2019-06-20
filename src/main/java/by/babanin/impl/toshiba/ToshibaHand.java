package by.babanin.impl.toshiba;

import by.babanin.interfaces.Hand;

import static by.babanin.Constant.CATCHED_FROM_FORMAT;
import static by.babanin.Constant.TOSHIBA;

public class ToshibaHand implements Hand {
    @Override
    public void catchSomething() {
        System.out.printf(CATCHED_FROM_FORMAT, TOSHIBA);
    }
}
